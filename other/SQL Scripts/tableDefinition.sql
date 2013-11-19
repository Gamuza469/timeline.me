CREATE DATABASE `timeline`;
USE `timeline`;

CREATE TABLE entidad (
	cuit INTEGER,
	domicilio VARCHAR(255),
	telefono VARCHAR(127),
	eMail VARCHAR(127),
	PRIMARY KEY (`cuit`)
);

CREATE TABLE empresa (
	cuit INTEGER,
	razon_social VARCHAR(255) NOT NULL,
	PRIMARY KEY (`cuit`),
	FOREIGN KEY (`cuit`) REFERENCES `entidad` (`cuit`)
		ON UPDATE CASCADE
		ON DELETE CASCADE
);

CREATE TABLE agente (
	cuit INTEGER,
	nombre VARCHAR(255) NOT NULL,
	apellido VARCHAR(255) NOT NULL,
	empresaContratante INTEGER NOT NULL,
	PRIMARY KEY (`cuit`),
	FOREIGN KEY (`cuit`) REFERENCES `entidad` (`cuit`)
		ON UPDATE CASCADE
		ON DELETE CASCADE
);

CREATE TABLE noticia (
	idNoticia INTEGER AUTO_INCREMENT,
	cuit INTEGER,
	fechaCreacion DATE NOT NULL,
	encabezado VARCHAR(255) NOT NULL,
	contenido VARCHAR(1024) NOT NULL,
	PRIMARY KEY (`idNoticia`, `cuit`),
	FOREIGN KEY (`cuit`) REFERENCES `empresa` (`cuit`)
		ON UPDATE CASCADE
		ON DELETE CASCADE
);

CREATE TABLE archivo_adjunto (
	idNoticia INTEGER,
	adjunto BLOB,
	PRIMARY KEY (`idNoticia`),
	FOREIGN KEY (`idNoticia`) REFERENCES `noticia` (`idNoticia`)
		ON UPDATE CASCADE
		ON DELETE CASCADE
);