create database imobiliario;
use imobiliario;
create table cliente(
	id int auto_increment not null primary key,
    nome varchar(100)not null,
    email varchar(100)not null,
    senha varchar(45)not null,
    sexo char(1)not null
);