-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-07-2016 a las 16:33:44
-- Versión del servidor: 5.7.11
-- Versión de PHP: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `practicaservlets`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyecto`
--
drop database practicaservlets;
create database practicaservlets;
use practicaservlets;

CREATE TABLE `proyecto` (
  `id` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `rol` varchar(100) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `user` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `tarea` (
  `id` int(11) NOT NULL,
  `id_proyecto` int(11) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `estado` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `proyecto`
--
ALTER TABLE `proyecto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `tarea`
  ADD PRIMARY KEY (`id`);
--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `proyecto`
--
ALTER TABLE `proyecto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `tarea`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `proyecto`
--
ALTER TABLE `proyecto`
  ADD CONSTRAINT `proyecto_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`);
  
ALTER TABLE `tarea`
  ADD CONSTRAINT `tarea_ibfk_1` FOREIGN KEY (`id_proyecto`) REFERENCES `proyecto` (`id`);

insert into usuario(email,rol,nombre,password,user) values ('test@test.com','Administrador','nombreTest','admin','root');
insert into usuario(email,rol,nombre,password,user) values ('test@test.com2','Diseñador','nombreTest2','admin2','root2');
insert into usuario(email,rol,nombre,password,user) values ('test@test.com3','Administrador','nombreTest3','admin3','root3');
insert into usuario(email,rol,nombre,password,user) values ('test@test.com4','Desarrollador','nombreTest4','admin4','root4');
insert into usuario(email,rol,nombre,password,user) values ('test@test.com5','Desarrollador','nombreTest5','admin5','root5');

insert into proyecto(id_usuario,nombre,descripcion) values (1,'nombre1','descripcion1');
insert into proyecto(id_usuario,nombre,descripcion) values (2,'nombre2','descripcion2');
insert into proyecto(id_usuario,nombre,descripcion) values (3,'nombre3','descripcion3');
insert into proyecto(id_usuario,nombre,descripcion) values (4,'nombre4','descripcion4');
insert into proyecto(id_usuario,nombre,descripcion) values (5,'nombre5','descripcion5');
insert into proyecto(id_usuario,nombre,descripcion) values (5,'nombre6','descripcion6');
insert into proyecto(id_usuario,nombre,descripcion) values (4,'nombre7','descripcion7');
insert into proyecto(id_usuario,nombre,descripcion) values (3,'nombre8','descripcion8');
insert into proyecto(id_usuario,nombre,descripcion) values (2,'nombre9','descripcion9');
insert into proyecto(id_usuario,nombre,descripcion) values (1,'nombre10','descripcion10');

insert into tarea(id_proyecto,titulo,estado) values (1,'tarea1','Inicial');
insert into tarea(id_proyecto,titulo,estado) values (2,'tarea2','En desarrollo');
insert into tarea(id_proyecto,titulo,estado) values (3,'tarea3','Terminado');
insert into tarea(id_proyecto,titulo,estado) values (4,'tarea4','Inicial');
insert into tarea(id_proyecto,titulo,estado) values (5,'tarea5','En desarrollo');
insert into tarea(id_proyecto,titulo,estado) values (6,'tarea6','Inicial');
insert into tarea(id_proyecto,titulo,estado) values (7,'tarea7','En desarrollo');
insert into tarea(id_proyecto,titulo,estado) values (8,'tarea8','Terminado');
insert into tarea(id_proyecto,titulo,estado) values (9,'tarea9','Inicial');
insert into tarea(id_proyecto,titulo,estado) values (10,'tarea10','En desarrollo');
insert into tarea(id_proyecto,titulo,estado) values (1,'tarea11','Terminado');
insert into tarea(id_proyecto,titulo,estado) values (2,'tarea12','En desarrollo');
insert into tarea(id_proyecto,titulo,estado) values (3,'tarea13','Inicial');
insert into tarea(id_proyecto,titulo,estado) values (4,'tarea14','Terminado');
insert into tarea(id_proyecto,titulo,estado) values (5,'tarea15','En desarrollo');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
