create database evaluacion;

use evaluacion;
create table usuario(
idUsuario int auto_increment unique,
apellido varchar(100),
nombre varchar(70),
genero varchar(30),
ocupacion varchar(50),
CV varchar(200),
edad int
)
select * from usuario
