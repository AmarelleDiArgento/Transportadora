create database if not exists  Transportadora;
use Transportadora;

-- ------------------------------------------------------------------------------------------------------------------------
-- TABLA "PERMISO"
-- ------------------------------------------------------------------------------------------------------------------------

 CREATE TABLE IF NOT EXISTS Transportadora.Permiso (
 ID int auto_increment primary key,
 Nombre varchar(45) unique not null,
 Url varchar(255) unique not null,
 estado boolean);

 /*
 Campos:
   ID,Nombre,Url,Estado
   IDPer,NombrePer,UrlPer,EstadoPer
 */
 
 -- --------------------------------------------------------
 -- procedimiento insertar (Insert)
 -- --------------------------------------------------------

 delimiter $$
 CREATE PROCEDURE perIn(
   in NombrePer varchar(45),
   in UrlPer varchar(255),
   in EstadoPer boolean
 )
BEGIN
  INSERT INTO Permiso (Nombre,Url,Estado)
  VALUES (NombrePer,UrlPer,EstadoPer);
END $$
delimiter $$

-- ---------------------------------------------------------
-- CALL insertar
-- ---------------------------------------------------------
CALL Transportadora.perIn("Asignar","asignar.jsp",true);
CALL Transportadora.perIn("Empresa","empresa.jsp",true);
CALL Transportadora.perIn("Evento","evento.jsp",true);
CALL Transportadora.perIn("Historico","main.jsp",true);
CALL Transportadora.perIn("Permiso","permiso.jsp",true);
CALL Transportadora.perIn("Rol","rol.jsp",true);
CALL Transportadora.perIn("Ruta","ruta.jsp",true);
CALL Transportadora.perIn("Usuario","usuario.jsp",true);
CALL Transportadora.perIn("Vehiculo","vehiculo.jsp",false);
CALL Transportadora.perIn("para borrar","borrar.jsp",true);
-- CALL Transportadora.perIn(?,?,?);

-- ---------------------------------------------------------
-- procedimiento Modificar (Update)
-- ---------------------------------------------------------

delimiter $$
CREATE PROCEDURE perUp(
  in IDPer int,
  in NombrePer varchar(45),
  in UrlPer varchar(255),
  in EstadoPer boolean
)
BEGIN
  UPDATE Permiso SET
    Nombre=NombrePer, Url=UrlPer, Estado=EstadoPer
  WHERE ID=IDPer;
END $$
delimiter $$

-- ---------------------------------------------------------
-- CALL Modificar
-- ---------------------------------------------------------
CALL Transportadora.perUp(9, "Vehiculo","vehiculo.jsp",true);
-- CALL Transportadora.perUp(?,?,?,?);
-- ---------------------------------------------------------
-- procedimiento Eliminar  (Delete)
-- ---------------------------------------------------------

  delimiter $$
  CREATE PROCEDURE perEl(
    in IDPer int
  )
  BEGIN
    DELETE FROM permiso WHERE ID = IDPer;
  END $$
  delimiter $$

  -- -------------------------------------------------------
  -- CALL Eliminar
  -- -------------------------------------------------------
  call transportadora.perEl(10);
  -- CALL Transportadora.perEl(?);

  -- -------------------------------------------------------
  -- procedimiento Consultar  (One)
  -- -------------------------------------------------------
delimiter $$
CREATE PROCEDURE perOn(
  in IDPer int
)
BEGIN
  SELECT ID,Nombre,Url,Estado FROM Permiso WHERE ID=IDPer;
END $$
delimiter $$

-- ---------------------------------------------------------
-- CALL Consultar
-- ---------------------------------------------------------
call transportadora.perOn(2);
-- CALL Transportadora.perOn(?);

-- ---------------------------------------------------------
-- procedimiento Listar  (All)
-- ---------------------------------------------------------
delimiter $$
CREATE PROCEDURE perAl()
BEGIN
SELECT ID,Nombre,Url,Estado FROM Permiso;
END $$
delimiter $$

-- ---------------------------------------------------------
-- CALL Listar
-- ---------------------------------------------------------
call transportadora.perAl();
-- CALL Transportadora.perAl();


-- ------------------------------------------------------------------------------------------------------------------------
-- TABLA "RUTA"
-- ------------------------------------------------------------------------------------------------------------------------
 create table if not exists transportadora.Ruta (
   ID int auto_increment primary key,
   Nombre varchar(45) unique not null,
   HoraIni time,
   Horafin time,
   Km float,
   LugarInicio varchar(60),
   LugarFin varchar(60)
 );
