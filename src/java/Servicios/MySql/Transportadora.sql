/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  freyd
 * Created: 1/09/2018
 */

CREATE USER IF NOT EXISTS 'Taller1' @'localhost' IDENTIFIED BY 'Taller1';
GRANT ALL PRIVILEGES ON *.* TO 'Taller1' @'localhost';
FLUSH PRIVILEGES;

CREATE DATABASE IF NOT EXISTS taller1;

USE taller1;

CREATE TABLE IF NOT EXISTS Rol (
    ID INT auto_increment PRIMARY KEY,
    Nombre VARCHAR ( 20 ) UNIQUE NOT NULL,
    Descripcion VARCHAR ( 30 ),
    Jerarquia INT NOT NULL,
    Estado boolean DEFAULT FALSE);

CREATE TABLE IF NOT EXISTS Permiso ( 
    ID INT auto_increment PRIMARY KEY, 
    Nombre VARCHAR ( 20 ) UNIQUE NOT NULL, 
    Url text, 
    Estado boolean DEFAULT FALSE);

CREATE TABLE IF NOT EXISTS Asignar (
    IdRol INT NOT NULL,
    IdPer INT NOT NULL,
    Leer INT ( 4 ),
    Nuevo boolean DEFAULT FALSE,
    Modificar boolean DEFAULT FALSE,
    Eliminar boolean DEFAULT FALSE,
        CONSTRAINT Asignar_Rol FOREIGN KEY ( IdRol ) REFERENCES Rol ( ID ) ON DELETE CASCADE ON UPDATE CASCADE,
        CONSTRAINT Asignar_Permiso FOREIGN KEY ( IdPer ) REFERENCES Permiso ( ID ) ON DELETE CASCADE ON UPDATE CASCADE);

CREATE TABLE IF NOT EXISTS Empresa (
    Nit VARCHAR ( 15 ) PRIMARY KEY,
    RazonSoc VARCHAR ( 10 ) UNIQUE NOT NULL,
    Representante VARCHAR ( 20 ),
    Telefono VARCHAR ( 12 ),
    Direccion VARCHAR ( 20 ),
    Arl VARCHAR ( 20 ),
    Estado boolean DEFAULT FALSE);

CREATE TABLE
IF
	NOT EXISTS Usuario (
		TipoDocumento VARCHAR ( 10 ) NOT NULL,
		NumDocumento VARCHAR ( 15 ) PRIMARY KEY,
		Nombres VARCHAR ( 50 ) NOT NULL,
		Telefono VARCHAR ( 12 ),
		Direccion VARCHAR ( 20 ),
		Eps VARCHAR ( 20 ),
		Correo VARCHAR ( 50 ),
		Contrasena VARCHAR ( 255 ) NOT NULL,
		Foto VARCHAR ( 255 ),
		Rol INT,
		Empresa VARCHAR ( 20 ),
		Estado boolean DEFAULT FALSE,
		CONSTRAINT Usuario_Rol FOREIGN KEY ( Rol ) REFERENCES Rol ( ID ) ON DELETE CASCADE ON UPDATE CASCADE,
		CONSTRAINT Usuario_Empresa FOREIGN KEY ( Empresa ) REFERENCES Empresa ( Nit ) ON DELETE CASCADE ON UPDATE CASCADE 
	);
CREATE TABLE
IF
	NOT EXISTS Ruta (
		ID INT auto_increment PRIMARY KEY,
		Nombre VARCHAR ( 20 ) UNIQUE NOT NULL,
		HorarioIni time NOT NULL,
		horarioFin time NOT NULL,
		Km DEC ( 5, 2 ) NOT NULL,
		LugarIni VARCHAR ( 12 ) NOT NULL,
		LugarFin VARCHAR ( 12 ) NOT NULL,
		Estado boolean DEFAULT FALSE 
	);
CREATE TABLE
IF
	NOT EXISTS Evento ( ID INT auto_increment PRIMARY KEY, NombreEve enum ( 'Accidente', 'Asigna Ruta', 'Asigna Conductor', 'Falla mecanica', 'Mantenimiento', 'Robo' ) );
CREATE TABLE
IF
	NOT EXISTS Vehiculo (
		Placa VARCHAR ( 12 ) PRIMARY KEY,
		Marca VARCHAR ( 12 ),
		Modelo INT,
		Chasis VARCHAR ( 20 ) UNIQUE NOT NULL,
		Pasajeros INT NOT NULL,
		Empresa VARCHAR ( 15 ),
		Estado boolean DEFAULT FALSE,
		CONSTRAINT Vehiculo_Empresa FOREIGN KEY ( Empresa ) REFERENCES Empresa ( Nit ) ON DELETE CASCADE ON UPDATE CASCADE 
	);
CREATE TABLE
IF
	NOT EXISTS Historico (
		ID INT auto_increment PRIMARY KEY,
		Placa VARCHAR ( 12 ),
		Conductor VARCHAR ( 15 ),
		Ruta INT,
		Evento INT,
		Descripcion VARCHAR ( 250 ),
		Lugar VARCHAR ( 250 ),
		FechaIni datetime,
		FechaFin datetime,
		Estado boolean DEFAULT TRUE,
		CONSTRAINT Historico_Vehiculo FOREIGN KEY ( Placa ) REFERENCES Vehiculo ( Placa ) ON DELETE CASCADE ON UPDATE CASCADE,
		CONSTRAINT Historico_Usuario FOREIGN KEY ( Conductor ) REFERENCES Usuario ( NumDocumento ) ON DELETE CASCADE ON UPDATE CASCADE,
		CONSTRAINT Historico_Ruta FOREIGN KEY ( Ruta ) REFERENCES Ruta ( ID ) ON DELETE CASCADE ON UPDATE CASCADE,
		CONSTRAINT Historico_Eventos FOREIGN KEY ( Evento ) REFERENCES Evento ( ID ) ON DELETE CASCADE ON UPDATE CASCADE 
	);
/***************************************************************************************************************************/
/* Procedimientos tabla Roles */
CREATE PROCEDURE IF	NOT EXISTS RolIns ( IN NombreNew VARCHAR ( 20 ), IN JerarquiaNew INT, IN DescripcionNew VARCHAR ( 30 ), IN EstadoNew boolean ) 
BEGIN
		INSERT INTO Rol ( Nombre, Jerarquia, Descripcion, Estado )
	VALUES
		( NombreNew, JerarquiaNew, DescripcionNew, EstadoNew );
END;
CALL taller1.RolIns ( "Administrador", 1, "Control total", TRUE );
CALL taller1.RolIns ( "Coordinador Empresa", 2, "Control total", TRUE );
CALL taller1.RolIns ( "Conductor", 3, "Acceso minimo", TRUE );

CREATE PROCEDURE IF NOT EXISTS RolAct ( IN IdOld INT, IN NombreOld VARCHAR ( 20 ), IN DescripcionOld VARCHAR ( 30 ), IN JerarquiaOld INT, IN EstadoOld boolean ) 
BEGIN
		UPDATE Rol 
		SET Nombre = NombreOld,
		Jerarquia = JerarquiaOld,
		Descripcion = DescripcionOld,
		Estado = EstadoOld 
	WHERE
		ID = IdOld;	
END;

CREATE PROCEDURE IF	NOT EXISTS RolEli ( IN IDold INT ) BEGIN
	DELETE 
	FROM Rol WHERE ID = IDold;	
END;

CREATE PROCEDURE IF NOT EXISTS RolLis ( ) 
BEGIN
	SELECT ID,Nombre,Jerarquia,Descripcion,Estado 
	FROM Rol;	
END;

CREATE PROCEDURE IF	NOT EXISTS RolCon (IN IdOld INT ) 
BEGIN
	SELECT ID,Nombre,Jerarquia,Descripcion,Estado 
	FROM Rol 
	WHERE ID = IdOld;
END;

/*  Procedimientos tabla empresa */
CREATE PROCEDURE IF NOT EXISTS EmpIns (IN NitNew VARCHAR ( 15 ),IN RazonSocNew VARCHAR ( 10 ),IN RepresentanteNew VARCHAR (20),IN TelefonoNew VARCHAR ( 12 ),IN DireccionNew VARCHAR ( 20 ),IN ArlNew VARCHAR ( 20 ),IN EstadoNew boolean ) 
BEGIN
		INSERT INTO Empresa ( Nit, RazonSoc, Representante, Telefono, Direccion, Arl, Estado )
	VALUES
		( NitNew, RazonSocNew, RepresentanteNew, TelefonoNew, DireccionNew, ArlNew, EstadoNew );
END;

CALL taller1.EmpIns ( "800678943-7", "Coltrans", "Antonio de las Casas", "2456789", "Cra. 35 No. 12 56", "Sura", TRUE ) 

CREATE PROCEDURE IF NOT EXISTS EmpAct (IN NitOld VARCHAR ( 15 ),IN RazonSocOld VARCHAR ( 10 ),IN RepresentanteOld VARCHAR ( 20 ),IN TelefonoOld VARCHAR ( 12 ),IN DireccionOld VARCHAR ( 20 ),IN ArlOld VARCHAR ( 20 ),	IN EstadoOld boolean ) 
BEGIN
		UPDATE Empresa 
		SET 
		RazonSoc = RazonSocOld,
		Representante = RepresentanteOld,
		Telefono = TelefonoOld,
		Direccion = DireccionOld,
		Arl = ArlOld,
		Estado = EstadoOld 
	WHERE
		Nit = NitOld;
END;

CREATE PROCEDURE EmpEli ( IN NitOld VARCHAR ( 15 ) ) 
BEGIN
	DELETE 
	FROM
		Empresa WHERE Nit = NitOld;	
END;

CREATE PROCEDURE IF NOT EXISTS EmpLis ( ) 
BEGIN
	SELECT Nit,RazonSoc,Representante,Telefono,Direccion,Arl,Estado 
	FROM Empresa;	
END;

CREATE PROCEDURE IF NOT EXISTS EmpCon ( IN NitOld VARCHAR ( 15 ) ) 
BEGIN
	SELECT Nit,RazonSoc,Representante,Telefono,Direccion,Arl,Estado 
	FROM Empresa
	WHERE Nit=NitOld;
END;

/*  Procedimientos tabla Usuario*/
CREATE PROCEDURE InsUsu (
	IN TipoDocumentoNew VARCHAR ( 10 ),
	IN NumDocumentoNew VARCHAR ( 15 ),
	IN NombresNew VARCHAR ( 50 ),
	IN TelefonoNew VARCHAR ( 12 ),
	IN DireccionNew VARCHAR ( 20 ),
	IN EpsNew enum ( 'Nueva EPS', 'Coomeva', 'Famisanar' ),
	IN CorreoNew VARCHAR ( 50 ),
	IN ContrasenaNew VARCHAR ( 12 ),
	IN FotoNew VARCHAR ( 250 ),
	IN RolNew INT,
	IN EmpresaNew VARCHAR ( 15 ) 
) INSERT INTO Usuario ( TipoDocumento, NumDocumento, Nombres, Telefono, Direccion, Eps, Correo, Contrasena, Foto, Rol, Empresa )
VALUES
	( TipoDocumentoNew, NumDocumentoNew, NombresNew, TelefonoNew, DireccionNew, EpsNew, CorreoNew, ContrasenaNew, FotoNew, RolNew, EmpresaNew );
CREATE PROCEDURE ActUsu (
	IN TipoDocumentoNew VARCHAR ( 10 ),
	IN NumDocumentoOld VARCHAR ( 15 ),
	IN NombresNew VARCHAR ( 50 ),
	IN TelefonoNew VARCHAR ( 12 ),
	IN DireccionNew VARCHAR ( 20 ),
	IN EpsNew enum ( 'Nueva EPS', 'Coomeva', 'Famisanar' ),
	IN CorreoNew VARCHAR ( 50 ),
	IN ContrasenaNew VARCHAR ( 12 ),
	IN FotoNew VARCHAR ( 250 ),
	IN EstadoNew boolean 
) UPDATE Usuario 
SET TipoDocumento = TipoDocumentoNew,
Nombres = NombresNew,
Telefono = TelefonoNew,
Direccion = DireccionNew,
Eps = EpsNew,
Correo = CorreoNew,
Contrasena = ContrasenaNew,
Foto = FotoNew,
Estado = EstadoNew 
WHERE
	NumDocumento = NumDocumentoOld;
CREATE PROCEDURE EliUsu ( IN NumDocumentoOld VARCHAR ( 15 ) ) DELETE 
FROM
	Usuario 
WHERE
	NumDocumento = NumDocumentoOld;
	
CREATE PROCEDURE LisUsu ( ) 
SELECT TipoDocumento,NumDocumento,Nombres,Usuario.Telefono,Usuario.Direccion,Eps,Correo,Foto,Rol.Nombre,Empresa.RazonSoc,Usuario.Estado 
FROM Usuario
	INNER JOIN Rol ON Usuario.Rol = Rol.ID
	INNER JOIN Empresa ON Usuario.Empresa = Empresa.Nit;
	
/*  Procedimientos tabla Rutas */
CREATE PROCEDURE LisRut ( ) SELECT
* 
FROM
	Ruta;
CREATE PROCEDURE InsRut (
	IN NombreNew VARCHAR ( 20 ),
	IN HorarioIniNew time,
	IN horarioFinNew time,
	IN KmNew DEC ( 5, 2 ),
	IN LugarIniNew VARCHAR ( 12 ),
	IN LugarFinNew VARCHAR ( 12 ) 
) INSERT INTO Ruta ( Nombre, HorarioIni, horarioFin, Km, LugarIni, LugarFin )
VALUES
	( NombreNew, HorarioIniNew, horarioFinNew, KmNew, LugarIniNew, LugarFinNew );
CREATE PROCEDURE ActRut (
	IN IdOld INT,
	IN NombreNew VARCHAR ( 20 ),
	IN HorarioIniNew time,
	IN horarioFinNew time,
	IN KmNew DEC ( 5, 2 ),
	IN LugarIniNew VARCHAR ( 12 ),
	IN LugarFinNew VARCHAR ( 12 ) 
) UPDATE Ruta 
SET Nombre = NombreNew,
HorarioIni = HorarioIniNew,
horarioFin = horarioFin,
Km = KmNew,
LugarIni = LugarIniNew,
LugarFin = LugarFinNew 
WHERE
	ID = IdOld;
CREATE PROCEDURE EliRut ( IN IdOld INT ) DELETE 
FROM
	Ruta 
WHERE
	ID = IdOld;
/* Procedimientos tabla Eventos */
CREATE PROCEDURE LisEve ( ) SELECT
* 
FROM
	Evento;
CREATE PROCEDURE InsEve ( IN NombreEveNew enum ( 'Accidente', 'Asigna Ruta', 'Asigna Conductor', 'Falla mecanica', 'Mantenimiento', 'Robo' ) ) INSERT INTO Evento ( nombreEve )
VALUES
	( NombreEveNew );
CREATE PROCEDURE EliEve ( IN IdOld INT ) DELETE 
FROM
	Evento 
WHERE
	ID = IdOld;
/* Procedimientos Tabla Vehiculo */
CREATE PROCEDURE LisVehi ( ) SELECT
Placa,
Marca,
Modelo,
Chasis,
Pasajeros,
RazonSoc 
FROM
	Vehiculo
	INNER JOIN Empresa ON Vehiculo.Empresa = Empresa.nit;
CREATE PROCEDURE InsVehi (
	IN PlacaNew VARCHAR ( 12 ),
	IN MarcaNew VARCHAR ( 12 ),
	IN ModeloNew INT,
	IN ChasisNew VARCHAR ( 20 ),
	IN PasajerosNew INT,
	IN EmpresaNew VARCHAR ( 15 ) 
) INSERT INTO Vehiculo ( Placa, Marca, Modelo, Chasis, Pasajeros, Empresa )
VALUES
	( PlacaNew, MarcaNew, ModeloNew, ChasisNew, PasajerosNew, EmpresaNew );
CREATE PROCEDURE ActVehi (
	IN PlacaOld VARCHAR ( 12 ),
	IN MarcaNew VARCHAR ( 12 ),
	IN ModeloNew INT,
	IN ChasisNew VARCHAR ( 20 ),
	IN PasajerosNew INT,
	IN EmpresaNew VARCHAR ( 15 ) 
) UPDATE Vehiculo 
SET Marca = MarcaNew,
Modelo = ModeloNew,
Chasis = ChasisNew,
Pasajeros = PasajerosNew,
Empresa = EmpresaNew 
WHERE
	placa = PlacaOld;
CREATE PROCEDURE EliVehi ( IN PlacaOld VARCHAR ( 12 ) ) DELETE 
FROM
	Vehiculo 
WHERE
	Placa = PlacaOld;
/*  Procediminetos Historico */
CREATE PROCEDURE LisHis ( ) SELECT
* 
FROM
	Historico;
CREATE PROCEDURE LisHis1 ( ) SELECT
Historico.ID,
placa,
Usuario.Nombres,
Ruta.Nombre,
Evento.NombreEve,
Descripcion,
Lugar,
FechaIni,
FechaFin,
Historico.Estado 
FROM
	Historico
	INNER JOIN Usuario ON historico.Conductor = Usuario.NumDocumento
	INNER JOIN Evento ON Historico.Evento = Evento.ID
	INNER JOIN Ruta ON Historico.Ruta = Ruta.ID;
CREATE PROCEDURE InsHis (
	IN PlacaNew VARCHAR ( 12 ),
	IN ConductorNew VARCHAR ( 15 ),
	IN RutaNew INT,
	IN EventoNew INT,
	IN DescripcionNew VARCHAR ( 250 ),
	IN LugarNew VARCHAR ( 250 ) 
) INSERT INTO Historico ( Placa, Conductor, Ruta, Evento, Descripcion, Lugar, FechaIni )
VALUES
	( PlacaNew, ConductorNew, RutaNew, EventoNew, DescripcionNew, LugarNew, now( ) );
CREATE PROCEDURE ActHis (
	IN IdOld INT,
	IN PlacaNew VARCHAR ( 12 ),
	IN ConductorNew VARCHAR ( 15 ),
	IN RutaNew INT,
	IN EventoNew INT,
	IN DescripcionNew VARCHAR ( 250 ),
	IN LugarNew VARCHAR ( 250 ) 
) UPDATE Historico 
SET Placa = PlacaNew,
Conductor = ConductorNew,
Ruta = RutaNew,
Evento = EventoNew,
Descripcion = DescripcionNew,
Lugar = LugarNew 
WHERE
	ID = IdOld;
CREATE PROCEDURE TerminarHisto ( IN IdOld INT ) UPDATE Historico 
SET FechaFin = now( ),
Estado = FALSE 
WHERE
	ID = IdOld;
CREATE PROCEDURE EliHis ( IN IdOld INT ) DELETE 
FROM
	Historico 
WHERE
	ID = IdOld;