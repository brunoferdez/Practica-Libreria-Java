CREATE DATABASE libros;
USE libros;
CREATE TABLE libro(
	id VARCHAR(30) PRIMARY KEY,
	titulo VARCHAR(30),
	autor VARCHAR(30),
	leido VARCHAR(30),
	fecha VARCHAR(30)
);