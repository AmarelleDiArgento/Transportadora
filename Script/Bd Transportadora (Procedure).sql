-- ------------------------------------------------------------------------------------------------------------------------
-- TABLA "PERMISO"
-- ------------------------------------------------------------------------------------------------------------------------
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
-- procedimiento Eliminar  (Delete)
-- ---------------------------------------------------------

  delimiter $$
  CREATE PROCEDURE perDe(
    in IDPer int
  )
  BEGIN
    DELETE FROM permiso WHERE ID = IDPer;
  END $$
  delimiter $$

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
-- procedimiento Listar  (All)
-- ---------------------------------------------------------
delimiter $$
CREATE PROCEDURE perAl()
BEGIN
SELECT ID,Nombre,Url,Estado FROM Permiso;
END $$
delimiter $$

-- ------------------------------------------------------------------------------------------------------------------------
-- TABLA "RUTA"
-- ------------------------------------------------------------------------------------------------------------------------
-- ---------------------------------------------------------
-- procedimiento insertar (Insert)
-- ---------------------------------------------------------
-- ---------------------------------------------------------

delimiter $$
CREATE PROCEDURE rutIn(
  in rNombre varchar(45),
  in rHoraIni time,
  in rHorafin time,
  in rKm float,
  in rLugarInicio varchar(60),
  in rLugarFin varchar(60)
)
BEGIN
 INSERT INTO Ruta (Nombre,HoraIni,Horafin,Km,LugarInicio,LugarFin)
 VALUES (rNombre,rHoraIni,rHorafin,rKm,rLugarInicio,rLugarFin);
END $$
delimiter $$

-- ---------------------------------------------------------
-- procedimiento Modificar (Update)
-- ---------------------------------------------------------

delimiter $$
CREATE PROCEDURE Transportadora.rutUp(
  in rID int,
  in rNombre varchar(45),
  in rHoraIni time,
  in rHorafin time,
  in rKm float,
  in rLugarInicio varchar(60),
  in rLugarFin varchar(60)

)
BEGIN
UPDATE Ruta SET
Nombre=rNombre,HoraIni=rHoraIni,Horafin=rHorafin,Km=rKm,LugarInicio=rLugarInicio,LugarFin=rLugarFin
WHERE
ID = rID;
END $$
DELIMITER $$

-- ---------------------------------------------------------
-- procedimiento Eliminar  (Delete)
-- ---------------------------------------------------------

delimiter $$
CREATE PROCEDURE Transportadora.rutDe(
  in rID int
)
BEGIN
DELETE FROM Ruta WHERE ID=rID;
END $$
delimiter $$

-- ---------------------------------------------------------
-- procedimiento Consultar  (One)
-- ---------------------------------------------------------
delimiter $$
CREATE PROCEDURE Transportadora.rutOn(
  in rID int
)
BEGIN
SELECT ID,Nombre,HoraIni,Horafin,Km,LugarInicio,LugarFin
FROM Ruta
WHERE ID = rID;
END $$
delimiter $$
-- ---------------------------------------------------------
-- procedimiento Listar  (All)
-- ---------------------------------------------------------
delimiter $$
CREATE PROCEDURE Transportadora.rutAl()
BEGIN
SELECT ID,Nombre,HoraIni,Horafin,Km,LugarInicio,LugarFin
FROM Ruta;
END $$
delimiter $$

-- ------------------------------------------------------------------------------------------------------------------------
-- TABLA "EMPRESA"
-- ------------------------------------------------------------------------------------------------------------------------
-- ---------------------------------------------------------
-- procedimiento insertar (Insert)
-- ---------------------------------------------------------

delimiter $$
CREATE PROCEDURE Transportadora.empIn(
  eNit varchar(11),
  eRazonSoc varchar(70),
  eRepresentante varchar (70),
  eTelefono varchar(10),
  eDireccion varchar(65),
  eArl varchar(30),
  eEstado boolean
)
BEGIN
INSERT INTO Empresa (Nit,RazonSoc,Representante,Telefono,Direccion,Arl,Estado)
VALUES (eNit,eRazonSoc,eRepresentante,eTelefono,eDireccion,eArl,eEstado);
END $$
delimiter $$

-- ---------------------------------------------------------
-- procedimiento Modificar (Update)
-- ---------------------------------------------------------

delimiter $$
CREATE PROCEDURE Transportadora.empUp(
  eNit varchar(11),
  eRazonSoc varchar(70),
  eRepresentante varchar (70),
  eTelefono varchar(10),
  eDireccion varchar(65),
  eArl varchar(30),
  eEstado boolean
)
BEGIN
UPDATE Empresa SET
Nit=eNit,RazonSoc=eRazonSoc,Representante=eRepresentante,Telefono=eTelefono,Direccion=eDireccion,Arl=eArl,Estado=eEstado
WHERE NIT = eNit;
END $$
delimiter $$

-- ---------------------------------------------------------
-- procedimiento Eliminar  (Delete)
-- ---------------------------------------------------------
delimiter $$
CREATE PROCEDURE Transportadora.empDe(
  eNit varchar(11)
)
BEGIN
DELETE FROM Empresa
WHERE Nit = eNit;
END $$
delimiter $$
-- ---------------------------------------------------------
-- procedimiento Consultar  (One)
-- ---------------------------------------------------------
delimiter $$
CREATE PROCEDURE Transportadora.empCo(
  eNit varchar(11)
)
BEGIN
SELECT Nit,RazonSoc,Representante,Telefono,Direccion,Arl,Estado
FROM Empresa
WHERE Nit = eNit;
END $$
delimiter $$
-- ---------------------------------------------------------
-- procedimiento Listar  (All)
-- ---------------------------------------------------------
delimiter $$
CREATE PROCEDURE Transportadora.empAl()
BEGIN
SELECT Nit,RazonSoc,Representante,Telefono,Direccion,Arl,Estado
FROM Empresa;
END $$
delimiter $$

-- ------------------------------------------------------------------------------------------------------------------------
-- TABLA "RUTA"
-- ------------------------------------------------------------------------------------------------------------------------
-- ---------------------------------------------------------
-- procedimiento insertar (Insert)
-- ---------------------------------------------------------
-- ---------------------------------------------------------
-- procedimiento Modificar (Update)
-- ---------------------------------------------------------
-- ---------------------------------------------------------
-- procedimiento Eliminar  (Delete)
-- ---------------------------------------------------------
-- ---------------------------------------------------------
-- procedimiento Consultar  (One)
-- ---------------------------------------------------------
-- ---------------------------------------------------------
-- procedimiento Listar  (All)
-- ---------------------------------------------------------
