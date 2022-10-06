/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Mariana Portela
 * Created: 6/10/2022
 */

CREATE TABLE usuario(
cedula varchar(10) primary key,
nombre varchar(30),
apellido varchar(30),
correo varchar(30),
contrasenia varchar(20));

create table articulo(
codProducto varchar(10) primary key,
nombre varchar(20),
precio int,
cantidad int,
descripcion varchar(50),
categoria varchar(30));

