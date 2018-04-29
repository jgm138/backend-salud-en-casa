SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema saludencasadb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema saludencasadb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `saludencasadb` DEFAULT CHARACTER SET utf8 ;
USE `saludencasadb` ;

-- -----------------------------------------------------
-- Table `saludencasadb`.`categorias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saludencasadb`.`categorias` (
  `pkcategoria` INT NOT NULL AUTO_INCREMENT,
  `categoria` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`pkcategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `saludencasadb`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saludencasadb`.`productos` (
  `pkproducto` INT NOT NULL AUTO_INCREMENT,
  `producto` VARCHAR(60) NOT NULL,
  `descripcion` VARCHAR(500) NOT NULL,
  `caracteristicas` VARCHAR(200) NOT NULL,
  `volumen` VARCHAR(20) NOT NULL,
  `appmovil` TINYINT NOT NULL DEFAULT 0,
  `precio` DECIMAL(10,2) NOT NULL,
  `fkcategoria` INT NOT NULL,
  PRIMARY KEY (`pkproducto`),
  INDEX `fk_productos_categorias_idx` (`fkcategoria` ASC),
  CONSTRAINT `fk_productos_categorias`
    FOREIGN KEY (`fkcategoria`)
    REFERENCES `saludencasadb`.`categorias` (`pkcategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `saludencasadb`.`fotos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saludencasadb`.`fotos` (
  `pkfoto` INT NOT NULL AUTO_INCREMENT,
  `ubicacion` VARCHAR(120) NOT NULL,
  `fkproducto` INT NOT NULL,
  PRIMARY KEY (`pkfoto`),
  INDEX `fk_fotos_productos1_idx` (`fkproducto` ASC),
  CONSTRAINT `fk_fotos_productos1`
    FOREIGN KEY (`fkproducto`)
    REFERENCES `saludencasadb`.`productos` (`pkproducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `saludencasadb`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saludencasadb`.`roles` (
  `pkrol` INT NOT NULL AUTO_INCREMENT,
  `authority` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`pkrol`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `saludencasadb`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saludencasadb`.`usuarios` (
  `pkusuario` INT NOT NULL AUTO_INCREMENT,
  `pkemail` VARCHAR(60) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `nombres` VARCHAR(70) NULL,
  `apellidos` VARCHAR(70) NULL,
  `genero` VARCHAR(45) NULL,
  `fechanacimiento` VARCHAR(45) NULL,
  `primeravez` TINYINT NOT NULL DEFAULT 1,
  `fkrol` INT NOT NULL,
  PRIMARY KEY (`pkusuario`),
  INDEX `fk_usuarios_roles1_idx` (`fkrol` ASC),
  CONSTRAINT `fk_usuarios_roles1`
    FOREIGN KEY (`fkrol`)
    REFERENCES `saludencasadb`.`roles` (`pkrol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `saludencasadb`.`compras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saludencasadb`.`compras` (
  `pkcompra` INT NOT NULL AUTO_INCREMENT,
  `fecha_hora` DATETIME NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `fkusuario` INT NOT NULL,
  `descuento` DECIMAL(10,2) NOT NULL DEFAULT 0,
  PRIMARY KEY (`pkcompra`),
  INDEX `fk_compras_usuarios1_idx` (`fkusuario` ASC),
  CONSTRAINT `fk_compras_usuarios1`
    FOREIGN KEY (`fkusuario`)
    REFERENCES `saludencasadb`.`usuarios` (`pkusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `saludencasadb`.`detalle_compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saludencasadb`.`detalle_compra` (
  `cantidad` INT NOT NULL,
  `valor_unidad` VARCHAR(45) NOT NULL,
  `fkcompra` INT NOT NULL,
  `fkproducto` INT NOT NULL,
  INDEX `fk_detalle_compra_compras1_idx` (`fkcompra` ASC),
  INDEX `fk_detalle_compra_productos1_idx` (`fkproducto` ASC),
  CONSTRAINT `fk_detalle_compra_compras1`
    FOREIGN KEY (`fkcompra`)
    REFERENCES `saludencasadb`.`compras` (`pkcompra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_compra_productos1`
    FOREIGN KEY (`fkproducto`)
    REFERENCES `saludencasadb`.`productos` (`pkproducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `saludencasadb`.`pagos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saludencasadb`.`pagos` (
  `pkpago` INT NOT NULL,
  `valor` DECIMAL(10,2) NOT NULL,
  `fecha_hora` DATETIME NOT NULL,
  `fkcompra` INT NOT NULL,
  PRIMARY KEY (`pkpago`),
  INDEX `fk_pagos_compras1_idx` (`fkcompra` ASC),
  CONSTRAINT `fk_pagos_compras1`
    FOREIGN KEY (`fkcompra`)
    REFERENCES `saludencasadb`.`compras` (`pkcompra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `saludencasadb`.`acciones_historia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saludencasadb`.`acciones_historia` (
  `pkacciones` INT NOT NULL AUTO_INCREMENT,
  `accion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`pkacciones`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `saludencasadb`.`historia_productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saludencasadb`.`historia_productos` (
  `pkhistoria` INT NOT NULL AUTO_INCREMENT,
  `fecha_hora` DATETIME NOT NULL,
  `fkusuario` INT NOT NULL,
  `fkaccion` INT NOT NULL,
  `fkproducto` INT NOT NULL,
  `producto` VARCHAR(60) NOT NULL,
  `descripcion` VARCHAR(500) NOT NULL,
  `caracteristicas` VARCHAR(200) NOT NULL,
  `volumen` VARCHAR(20) NOT NULL,
  `appmovil` TINYINT NOT NULL,
  `precio` DECIMAL(10,2) NOT NULL,
  `fkcategoria` INT NOT NULL,
  PRIMARY KEY (`pkhistoria`),
  INDEX `fk_historia_productos_usuarios1_idx` (`fkusuario` ASC),
  INDEX `fk_historia_productos_acciones_historia1_idx` (`fkaccion` ASC),
  INDEX `fk_historia_productos_productos1_idx` (`fkproducto` ASC),
  CONSTRAINT `fk_historia_productos_usuarios1`
    FOREIGN KEY (`fkusuario`)
    REFERENCES `saludencasadb`.`usuarios` (`pkusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_historia_productos_acciones_historia1`
    FOREIGN KEY (`fkaccion`)
    REFERENCES `saludencasadb`.`acciones_historia` (`pkacciones`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_historia_productos_productos1`
    FOREIGN KEY (`fkproducto`)
    REFERENCES `saludencasadb`.`productos` (`pkproducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `saludencasadb`.`carrito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `saludencasadb`.`carrito` (
  `pkcarrito` INT NOT NULL AUTO_INCREMENT,
  `cantidad` INT NULL,
  `fkusuario` INT NOT NULL,
  `fkproducto` INT NOT NULL,
  PRIMARY KEY (`pkcarrito`),
  INDEX `fk_carrito_usuarios1_idx` (`fkusuario` ASC),
  INDEX `fk_carrito_productos1_idx` (`fkproducto` ASC),
  CONSTRAINT `fk_carrito_usuarios1`
    FOREIGN KEY (`fkusuario`)
    REFERENCES `saludencasadb`.`usuarios` (`pkusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_carrito_productos1`
    FOREIGN KEY (`fkproducto`)
    REFERENCES `saludencasadb`.`productos` (`pkproducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
