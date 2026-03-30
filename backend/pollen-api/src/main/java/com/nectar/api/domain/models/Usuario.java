package com.nectar.api.domain.models;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import com.nectar.api.domain.models.empresarial.Empresa;
import com.nectar.api.domain.models.empresarial.Equipe;
import com.nectar.api.utils.RoleUsuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_private")
    private Long idPrivate;

    @UuidGenerator
    private UUID idPublic;

    @Column(length = 50,unique = true)
    private String nome;
    @Column(length = 40,unique = true)
    private String email;
    @Column(length = 50)
    private String senha; // acabei de adicionar
    @Column
    private Boolean atividade = true;

    @Enumerated(EnumType.STRING)
    private RoleUsuario tipo;

    
    
    @CreationTimestamp
    private Instant dataCriacao;
    
    @UpdateTimestamp
    private Instant  dataAtualizacao;
    
    @OneToMany(mappedBy = "manager")
    private List<Empresa> empresas;
    
    @ManyToMany
    private List<Equipe> contribuidor;

    @OneToMany(mappedBy = "criador")
    List<Workspace> workspaces;

    @OneToMany(mappedBy = "criadorDaColmeia")
    List<Colmeia> colmeias;

}
