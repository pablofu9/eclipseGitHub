DROP DATABASE hibernate_relacion_1an;
CREATE DATABASE hibernate_relacion_1an;
USE hibernate_relacion_1an;

CREATE TABLE IF NOT EXISTS departamento (
  id_departamento integer unsigned NOT NULL AUTO_INCREMENT,
  nombre varchar(500) NOT NULL,
  PRIMARY KEY (id_departamento)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;


INSERT INTO departamento (id_departamento, nombre) VALUES
(1, 'ventas'),
(2, 'marketing'),
(3, 'id',);



CREATE TABLE IF NOT EXISTS empleado (
  id_empleado integer unsigned NOT NULL AUTO_INCREMENT,
  nombre varchar(500) NOT NULL,
  id_departamento integer NOT NULL,
  PRIMARY KEY (id_empleado),
  FOREIGN KEY (id_departamento)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;



INSERT INTO empleado (id_empleado, nombre, id_departamento) VALUES
(1, 'juan',1),
(2, 'pedro', 3),
(3, 'luis', 1),
(4, 'Julian', 1),
(5, 'Maria', 2),
