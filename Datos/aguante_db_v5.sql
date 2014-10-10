SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `aguantedb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `aguantedb` ;

-- -----------------------------------------------------
-- Table `aguantedb`.`Persona`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `aguantedb`.`Persona` (
  `codPer` INT NOT NULL AUTO_INCREMENT ,
  `tipoPer` VARCHAR(10) NOT NULL ,
  `nombres` VARCHAR(50) NOT NULL ,
  `paterno` VARCHAR(50) NOT NULL ,
  `materno` VARCHAR(50) NOT NULL ,
  `sexo` CHAR NOT NULL ,
  `tipoDoc` VARCHAR(10) NOT NULL ,
  `numDoc` VARCHAR(45) NOT NULL ,
  `correo` VARCHAR(50) NULL ,
  `password` VARCHAR(10) NOT NULL ,
  `fecNac` DATE NOT NULL ,
  `celular` INT NULL ,
  PRIMARY KEY (`codPer`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aguantedb`.`Local`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `aguantedb`.`Local` (
  `codLoc` INT NOT NULL AUTO_INCREMENT ,
  `desLoc` VARCHAR(50) NOT NULL ,
  `direccion` VARCHAR(100) NOT NULL ,
  `distrito` VARCHAR(50) NOT NULL ,
  `dicGoogle` VARCHAR(100) NULL ,
  `telefonoFijo` INT NOT NULL ,
  `Persona_codPer` INT NOT NULL ,
  PRIMARY KEY (`codLoc`) ,
  INDEX `fk_Local_Persona1` (`Persona_codPer` ASC) ,
  CONSTRAINT `fk_Local_Persona1`
    FOREIGN KEY (`Persona_codPer` )
    REFERENCES `aguantedb`.`Persona` (`codPer` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aguantedb`.`Evento`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `aguantedb`.`Evento` (
  `codEvento` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(50) NULL ,
  `premio` VARCHAR(50) NULL ,
  `limiteCantidad` INT NULL ,
  `plazoInscripcion` DATE NULL ,
  `Local_codLoc` INT NOT NULL ,
  PRIMARY KEY (`codEvento`) ,
  INDEX `fk_Evento_Local1` (`Local_codLoc` ASC) ,
  CONSTRAINT `fk_Evento_Local1`
    FOREIGN KEY (`Local_codLoc` )
    REFERENCES `aguantedb`.`Local` (`codLoc` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aguantedb`.`Cancha`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `aguantedb`.`Cancha` (
  `numCancha` INT NOT NULL AUTO_INCREMENT ,
  `nombre` VARCHAR(50) NOT NULL ,
  `caracteristicas` VARCHAR(250) NOT NULL ,
  `diasAtencion` VARCHAR(250) NOT NULL ,
  `horasAtencion` VARCHAR(250) NOT NULL ,
  `tarifaDiurna` DOUBLE NOT NULL ,
  `tarifaNocturna` DOUBLE NOT NULL ,
  `promo` VARCHAR(250) NULL ,
  `foto` VARCHAR(250) NOT NULL ,
  `Local_codLoc` INT NOT NULL ,
  PRIMARY KEY (`numCancha`) ,
  INDEX `fk_Cancha_Local1` (`Local_codLoc` ASC) ,
  CONSTRAINT `fk_Cancha_Local1`
    FOREIGN KEY (`Local_codLoc` )
    REFERENCES `aguantedb`.`Local` (`codLoc` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aguantedb`.`Alquiler`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `aguantedb`.`Alquiler` (
  `codAlquiler` INT NOT NULL AUTO_INCREMENT ,
  `fecAlquiler` DATE NOT NULL ,
  `Persona_codPer` INT NOT NULL ,
  PRIMARY KEY (`codAlquiler`) ,
  INDEX `fk_Alquiler_Persona1` (`Persona_codPer` ASC) ,
  CONSTRAINT `fk_Alquiler_Persona1`
    FOREIGN KEY (`Persona_codPer` )
    REFERENCES `aguantedb`.`Persona` (`codPer` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aguantedb`.`Horario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `aguantedb`.`Horario` (
  `codHorario` INT NOT NULL AUTO_INCREMENT ,
  `fecha` DATE NOT NULL ,
  `horaInicio` VARCHAR(50) NOT NULL ,
  `horaFin` VARCHAR(50) NOT NULL ,
  `estado` VARCHAR(1) NOT NULL ,
  `Cancha_numCancha` INT NOT NULL ,
  `Alquiler_codAlquiler` INT NOT NULL ,
  PRIMARY KEY (`codHorario`) ,
  INDEX `fk_Horario_Cancha1` (`Cancha_numCancha` ASC) ,
  INDEX `fk_Horario_Alquiler1` (`Alquiler_codAlquiler` ASC) ,
  CONSTRAINT `fk_Horario_Cancha1`
    FOREIGN KEY (`Cancha_numCancha` )
    REFERENCES `aguantedb`.`Cancha` (`numCancha` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Horario_Alquiler1`
    FOREIGN KEY (`Alquiler_codAlquiler` )
    REFERENCES `aguantedb`.`Alquiler` (`codAlquiler` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aguantedb`.`servAdicional`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `aguantedb`.`servAdicional` (
  `codServ` INT NOT NULL AUTO_INCREMENT ,
  `tipo` VARCHAR(50) NOT NULL ,
  `descripcion` VARCHAR(50) NOT NULL ,
  `tarifa` DOUBLE NOT NULL ,
  `Local_codLoc` INT NOT NULL ,
  PRIMARY KEY (`codServ`) ,
  INDEX `fk_servAdicional_Local1` (`Local_codLoc` ASC) ,
  CONSTRAINT `fk_servAdicional_Local1`
    FOREIGN KEY (`Local_codLoc` )
    REFERENCES `aguantedb`.`Local` (`codLoc` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aguantedb`.`Publicidad`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `aguantedb`.`Publicidad` (
  `codPublicidad` INT NOT NULL AUTO_INCREMENT ,
  `titulo` VARCHAR(50) NOT NULL ,
  `contenido` VARCHAR(50) NOT NULL ,
  `fechaInicio` DATE NOT NULL ,
  `fechaFin` DATE NOT NULL ,
  `tarifa` DOUBLE NOT NULL ,
  `clicks` INT NOT NULL ,
  `seccion` VARCHAR(50) NOT NULL ,
  `Persona_codPer` INT NOT NULL ,
  PRIMARY KEY (`codPublicidad`) ,
  INDEX `fk_Publicidad_Persona` (`Persona_codPer` ASC) ,
  CONSTRAINT `fk_Publicidad_Persona`
    FOREIGN KEY (`Persona_codPer` )
    REFERENCES `aguantedb`.`Persona` (`codPer` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `aguantedb`.`Comentario`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `aguantedb`.`Comentario` (
  `idComent` INT NOT NULL AUTO_INCREMENT ,
  `texto` VARCHAR(50) NOT NULL ,
  `calificacion` INT NULL ,
  `nivel` INT NOT NULL ,
  `Comentario_idComent` INT NULL ,
  `Persona_codPer` INT NOT NULL ,
  `Cancha_numCancha` INT NOT NULL ,
  PRIMARY KEY (`idComent`) ,
  INDEX `fk_Comentario_Comentario1` (`Comentario_idComent` ASC) ,
  INDEX `fk_Comentario_Persona1` (`Persona_codPer` ASC) ,
  INDEX `fk_Comentario_Cancha1` (`Cancha_numCancha` ASC) ,
  CONSTRAINT `fk_Comentario_Comentario1`
    FOREIGN KEY (`Comentario_idComent` )
    REFERENCES `aguantedb`.`Comentario` (`idComent` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comentario_Persona1`
    FOREIGN KEY (`Persona_codPer` )
    REFERENCES `aguantedb`.`Persona` (`codPer` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comentario_Cancha1`
    FOREIGN KEY (`Cancha_numCancha` )
    REFERENCES `aguantedb`.`Cancha` (`numCancha` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
