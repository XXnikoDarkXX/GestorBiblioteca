Create DATABASE BIBLIOTECA;
USE BIBLIOTECA;

CREATE TABLE USUARIO(
	NOMBRE CHARACTER(20),
    APELLIDOS CHARACTER (20),
    EDAD INTEGER(2),
    DNI CHARACTER(20),
    ESTADO CHARACTER(20));

    

CREATE TABLE LIBROS(
	CODIGO INTEGER(2) primary KEY,
	NOMBRE CHARACTER(20),
    CATEGORIA CHARACTER(20),
    PRESTAMO CHARACTER (20));
    
ALTER TABLE LIBROS ADD(EDITORIAL CHARACTER(20));
    
 
CREATE TABLE periodico(
	CODIGO INTEGER(2) primary KEY,
	NOMBRE CHARACTER(20),
    EDITORIAL CHARACTER(20),
    TIPODENOTICIAS CHARACTER(20),
    PRESTAMO CHARACTER (20));   
   


    SELECT * FROM LIBROS;
INSERT INTO LIBROS VALUES(1,'PRUEBA','FANTASIA','NO EN USO');

select * from libros;