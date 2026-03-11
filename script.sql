-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema NEO-POLLEN
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema NEO-POLLEN
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `NEO-POLLEN` DEFAULT CHARACTER SET utf8 ;
USE `NEO-POLLEN` ;

-- -----------------------------------------------------
-- Table `NEO-POLLEN`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NEO-POLLEN`.`usuarios` (
  `idusuarios` INT NOT NULL,
  `idpublic` VARCHAR(8) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `tipo_conta` ENUM("EMPRESARIAL", "INSTITUCIONAL", "COMUN") NOT NULL,
  `data_criacao` DATE NOT NULL,
  `data_atualização` DATE NOT NULL,
  `atividade` TINYINT NULL DEFAULT 1,
  UNIQUE INDEX `idpublic_UNIQUE` (`idpublic` ASC) VISIBLE,
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC) VISIBLE,
  PRIMARY KEY (`idusuarios`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NEO-POLLEN`.`workspace`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NEO-POLLEN`.`workspace` (
  `idwork` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `descricao` MEDIUMTEXT NULL,
  `usuarios_idusuarios` INT NOT NULL,
  PRIMARY KEY (`idwork`),
  INDEX `fk_workspace_usuarios1_idx` (`usuarios_idusuarios` ASC) VISIBLE,
  CONSTRAINT `fk_workspace_usuarios1`
    FOREIGN KEY (`usuarios_idusuarios`)
    REFERENCES `NEO-POLLEN`.`usuarios` (`idusuarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NEO-POLLEN`.`colmeia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NEO-POLLEN`.`colmeia` (
  `idcolmeia` INT NOT NULL,
  `usuarios_idusuarios` INT NOT NULL,
  PRIMARY KEY (`idcolmeia`),
  INDEX `fk_colmeia_usuarios1_idx` (`usuarios_idusuarios` ASC) VISIBLE,
  CONSTRAINT `fk_colmeia_usuarios1`
    FOREIGN KEY (`usuarios_idusuarios`)
    REFERENCES `NEO-POLLEN`.`usuarios` (`idusuarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NEO-POLLEN`.`favo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NEO-POLLEN`.`favo` (
  `idfavo` INT NOT NULL,
  `colmeia_idcolmeia` INT NOT NULL,
  PRIMARY KEY (`idfavo`),
  INDEX `fk_favo_colmeia1_idx` (`colmeia_idcolmeia` ASC) VISIBLE,
  CONSTRAINT `fk_favo_colmeia1`
    FOREIGN KEY (`colmeia_idcolmeia`)
    REFERENCES `NEO-POLLEN`.`colmeia` (`idcolmeia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NEO-POLLEN`.`anotacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NEO-POLLEN`.`anotacao` (
  `idanotacao` INT NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `corpo` MEDIUMTEXT NULL,
  `lixo` TINYINT NULL DEFAULT 0,
  `workspace_idgrupo` INT NOT NULL,
  PRIMARY KEY (`idanotacao`),
  INDEX `fk_anotacao_workspace1_idx` (`workspace_idgrupo` ASC) VISIBLE,
  CONSTRAINT `fk_anotacao_workspace1`
    FOREIGN KEY (`workspace_idgrupo`)
    REFERENCES `NEO-POLLEN`.`workspace` (`idwork`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NEO-POLLEN`.`tarefa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NEO-POLLEN`.`tarefa` (
  `idtarefa` INT NOT NULL,
  `titulo` VARCHAR(45) NULL,
  `corpo` VARCHAR(45) NULL,
  `lixo` VARCHAR(45) NULL,
  `etapas` VARCHAR(45) NULL,
  `progresso` TINYINT(3) UNSIGNED NOT NULL,
  `tarefacol` TINYINT(3) UNSIGNED NOT NULL,
  `workspace_idgrupo` INT NOT NULL,
  PRIMARY KEY (`idtarefa`),
  INDEX `fk_tarefa_workspace1_idx` (`workspace_idgrupo` ASC) VISIBLE,
  CONSTRAINT `fk_tarefa_workspace1`
    FOREIGN KEY (`workspace_idgrupo`)
    REFERENCES `NEO-POLLEN`.`workspace` (`idwork`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NEO-POLLEN`.`atividade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NEO-POLLEN`.`atividade` (
  `idatividade` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `descricao` VARCHAR(45) NULL,
  `data_de_atualizacao` DATE NULL,
  `data_de_criacao` DATE NULL,
  `usuarios_idusuarios` INT NOT NULL,
  PRIMARY KEY (`idatividade`),
  INDEX `fk_atividade_usuarios1_idx` (`usuarios_idusuarios` ASC) VISIBLE,
  CONSTRAINT `fk_atividade_usuarios1`
    FOREIGN KEY (`usuarios_idusuarios`)
    REFERENCES `NEO-POLLEN`.`usuarios` (`idusuarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NEO-POLLEN`.`anexo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NEO-POLLEN`.`anexo` (
  `idanexo` INT NOT NULL,
  `path` MEDIUMTEXT NULL,
  `atividade_idatividade` INT NOT NULL,
  PRIMARY KEY (`idanexo`),
  INDEX `fk_anexo_atividade_idx` (`atividade_idatividade` ASC) VISIBLE,
  CONSTRAINT `fk_anexo_atividade`
    FOREIGN KEY (`atividade_idatividade`)
    REFERENCES `NEO-POLLEN`.`atividade` (`idatividade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NEO-POLLEN`.`lembrete`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NEO-POLLEN`.`lembrete` (
  `idlembrete` INT NOT NULL,
  `titulo` VARCHAR(45) NULL,
  `corpo` VARCHAR(45) NULL,
  `data_de_termino` DATETIME NULL,
  `data_de_inicio` DATETIME NULL,
  `lixo` TINYINT NULL DEFAULT 1,
  `lembretecol` VARCHAR(45) NULL,
  `workspace_idwork` INT NOT NULL,
  PRIMARY KEY (`idlembrete`),
  INDEX `fk_lembrete_workspace1_idx` (`workspace_idwork` ASC) VISIBLE,
  CONSTRAINT `fk_lembrete_workspace1`
    FOREIGN KEY (`workspace_idwork`)
    REFERENCES `NEO-POLLEN`.`workspace` (`idwork`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NEO-POLLEN`.`grupo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NEO-POLLEN`.`grupo` (
  `idgrupo` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `descricao` VARCHAR(45) NULL,
  `data_de_atualizacao` DATE NULL,
  `data_de_criacao` DATE NULL,
  PRIMARY KEY (`idgrupo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `NEO-POLLEN`.`grupo_has_usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `NEO-POLLEN`.`grupo_has_usuarios` (
  `grupo_idgrupo` INT NOT NULL,
  `usuarios_idusuarios` INT NOT NULL,
  PRIMARY KEY (`grupo_idgrupo`, `usuarios_idusuarios`),
  INDEX `fk_grupo_has_usuarios_usuarios1_idx` (`usuarios_idusuarios` ASC) VISIBLE,
  INDEX `fk_grupo_has_usuarios_grupo1_idx` (`grupo_idgrupo` ASC) VISIBLE,
  CONSTRAINT `fk_grupo_has_usuarios_grupo1`
    FOREIGN KEY (`grupo_idgrupo`)
    REFERENCES `NEO-POLLEN`.`grupo` (`idgrupo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_grupo_has_usuarios_usuarios1`
    FOREIGN KEY (`usuarios_idusuarios`)
    REFERENCES `NEO-POLLEN`.`usuarios` (`idusuarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
