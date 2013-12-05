CREATE TABLE entidad (
	cuit INTEGER,
	PRIMARY KEY (`cuit`)
);

CREATE TABLE tipo_sociedad (
	id_tipo_sociedad INTEGER AUTO_INCREMENT,
	nombre VARCHAR(128) NOT NULL,
	abreviacion VARCHAR(10) NOT NULL,
	PRIMARY KEY (`id_tipo_sociedad`)
);

CREATE TABLE empresa (
	cuit INTEGER,
	razon_social VARCHAR(255) NOT NULL,
	id_tipo_sociedad int NOT NULL,
	PRIMARY KEY (`cuit`),
	FOREIGN KEY (`cuit`) REFERENCES `entidad` (`cuit`)
		ON UPDATE CASCADE
		ON DELETE CASCADE
	FOREIGN KEY (`id_tipo_sociedad`) REFERENCES `tipo_sociedad` (`id_tipo_sociedad`)
		ON UPDATE CASCADE
		ON DELETE CASCADE
);

CREATE TABLE agente (
	cuit INTEGER,
	nombre VARCHAR(255) NOT NULL,
	apellido VARCHAR(255) NOT NULL,
	PRIMARY KEY (`cuit`),
	FOREIGN KEY (`cuit`) REFERENCES `entidad` (`cuit`)
		ON UPDATE CASCADE
		ON DELETE CASCADE
);

CREATE TABLE email (
	cuit INTEGER,
	usuario VARCHAR(255) NOT NULL,
	servidor VARCHAR(255) NOT NULL,
	dominio VARCHAR(255) NOT NULL,
	PRIMARY KEY (`cuit`),
	FOREIGN KEY (`cuit`) REFERENCES `empresa` (`cuit`)
		ON UPDATE CASCADE
		ON DELETE CASCADE
);

CREATE TABLE tipo_de_via (
	id_tipo_via INTEGER AUTO_INCREMENT,
	nombre VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id_tipo_via`)
);

CREATE TABLE provincia (
	id_provincia INTEGER AUTO_INCREMENT,
	nombre VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id_provincia`)
);

CREATE TABLE municipio (
	id_municipio INTEGER AUTO_INCREMENT,
	id_provincia INTEGER,
	nombre VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id_municipio`, `id_provincia`),
	FOREIGN KEY (`id_provincia`) REFERENCES `provincia` (`id_provincia`)
		ON UPDATE CASCADE
		ON DELETE CASCADE
);

CREATE TABLE ciudad (
	id_municipio INTEGER,
	nombre VARCHAR(255) NOT NULL,
	PRIMARY KEY (`id_municipio`),
	FOREIGN KEY (`id_municipio`) REFERENCES `municipio` (`id_municipio`)
		ON UPDATE CASCADE
		ON DELETE CASCADE
);

CREATE TABLE domicilio (
	cuit INTEGER,
	id_municipio INTEGER NOT NULL,
	id_tipo_via INTEGER,
	nombre_via VARCHAR(255) NOT NULL,
	numero VARCHAR(64) NOT NULL,
	piso VARCHAR(3),
	oficina_depto VARCHAR(64),
	codigo_postal VARCHAR(8),
	PRIMARY KEY (`cuit`),
	FOREIGN KEY (`cuit`) REFERENCES `entidad` (`cuit`)
		ON UPDATE CASCADE
		ON DELETE CASCADE,
	FOREIGN KEY (`id_municipio`) REFERENCES `municipio` (`id_municipio`)
		ON UPDATE CASCADE
		ON DELETE CASCADE,
	FOREIGN KEY (`id_tipo_via`) REFERENCES `tipo_de_via` (`id_tipo_via`)
		ON UPDATE CASCADE
		ON DELETE CASCADE
);

CREATE TABLE telefono (
	cuit INTEGER,
	codigo_area INTEGER NOT NULL,
	caracteristica VARCHAR(8),
	linea VARCHAR(4),
	interno VARCHAR(10) NOT NULL,
	PRIMARY KEY (`cuit`),
	FOREIGN KEY (`cuit`) REFERENCES `entidad` (`cuit`)
		ON UPDATE CASCADE
		ON DELETE CASCADE
);

CREATE TABLE noticia (
	id_noticia INTEGER AUTO_INCREMENT,
	cuit INTEGER,
	encabezado VARCHAR(255) NOT NULL,
	contenido VARCHAR(1024) NOT NULL,
	PRIMARY KEY (`id_noticia`, `cuit`),
	FOREIGN KEY (`cuit`) REFERENCES `empresa` (`cuit`)
		ON UPDATE CASCADE
		ON DELETE CASCADE
);

CREATE TABLE archivo_adjunto (
	id_noticia INTEGER,
	archivo BLOB,
	PRIMARY KEY (`id_noticia`),
	FOREIGN KEY (`id_noticia`) REFERENCES `noticia` (`id_noticia`)
		ON UPDATE CASCADE
		ON DELETE CASCADE
);