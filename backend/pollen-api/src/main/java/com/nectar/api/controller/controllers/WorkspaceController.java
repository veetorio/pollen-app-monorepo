package com.nectar.api.controller.controllers;

import com.nectar.api.application.service.WorkspaceService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nectar.api.controller.in.WorkSpaceInput;
import com.nectar.api.controller.out.workspace.WorkspaceOutput;






@RestController
@RequestMapping("/workspaces")
public class WorkspaceController {

    @Autowired
    private WorkspaceService workspaceService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN', 'SCOPE_CONTRIBUIDOR')")
    public ResponseEntity<Void> create(@RequestBody WorkSpaceInput input) {
        return ResponseEntity.status(HttpStatus.CREATED).body(workspaceService.criarWorkspace(input));
    }

    @GetMapping("/{idPublic}")
    public ResponseEntity<WorkspaceOutput> getById(@PathVariable UUID idPublic) {
        return null;
    }

    @GetMapping
    public ResponseEntity<List<WorkspaceOutput>> getAll() {
        return null;
    }

    @PutMapping("/{idPublic}")
    public ResponseEntity<WorkspaceOutput> update(@PathVariable UUID idPublic, @RequestBody WorkSpaceInput input) {
        return null;
    }

    @DeleteMapping("/{idPublic}")
    public ResponseEntity<Void> delete(@PathVariable UUID idPublic) {
        return null;
    }
}