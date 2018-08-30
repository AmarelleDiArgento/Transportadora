CREATE USER IF NOT EXISTS 'Taller1'@'localhost' IDENTIFIED BY 'Taller1';
 GRANT ALL PRIVILEGES ON * . * TO 'Taller1'@'localhost';
 FLUSH PRIVILEGES;



CREATE DATABASE IF NOT EXISTS taller1;

use taller1;



CREATE TABLE IF NOT EXISTS Rol(

	ID int auto_increment primary key,

	Nombre varchar (20),

	Descripcion varchar (30),

	Estado boolean

);


CREATE TABLE IF NOT EXISTS  Empresa(

	Nit varchar(15) primary key,
	RazonSoc varchar(10),

	Representante varchar(20),

	Telefono varchar (12),

	Direccion varchar (20),

	Estado boolean
);

CREATE TABLE IF NOT EXISTS Usuario(

	TipoDocumento varchar(10),

	NumDocumento varchar(15) primary key,

	Nombres varchar(50),

	Telefono varchar(12),

	Direccion varchar(20),

	Eps enum ('Nueva EPS', 'Coomeva', 'Famisanar'),
	Arl enum('Sura'),

	Correo varchar(50),

	Contrasena varchar(12),

	Foto varchar(250),

	Rol int,

	Empresa varchar(15),
	Estado boolean,

   constraint Usuario_Rol Foreign Key (Rol) references Rol(ID) on delete cascade on update cascade,

   constraint Usuario_Empresa Foreign Key (Empresa) references Empresa (Nit) on delete cascade on update cascade

);


CREATE TABLE IF NOT EXISTS Ruta(

	ID int auto_increment primary key,

	Nombre varchar(20),

	HorarioIni time,

	horarioFin time,

	Km dec(5,2),

	LugarIni varchar(12),

	LugarFin varchar(12),

	Estado boolean

);

CREATE TABLE IF NOT EXISTS  Eventos(

	ID int auto_increment primary key,

	NombreEve enum('Accidente','Asigna Ruta','Asigna Conductor','Falla mecanica','Mantenimiento','Robo')

);


CREATE TABLE IF NOT EXISTS  HojaVehi(

	ID int auto_increment primary key,

	Tecnomecanica varchar(250),

	Soat varchar (250)

);


CREATE TABLE IF NOT EXISTS  Vehiculo(

	Placa varchar(12) primary key,

	Marca varchar(12),

	Modelo int,

	Chasis varchar(20),

	Pasajeros int,

	Empresa varchar(15),

	DatoHojaVehi int,

    constraint Vehiculo_Empresa Foreign Key (Empresa) references Empresa (Nit) on delete cascade on update cascade,

    constraint Vehiculo_HojaVehi Foreign Key (DatoHojaVehi) references HojaVehi (ID) on delete cascade on update cascade

);



CREATE TABLE IF NOT EXISTS Historico(

	ID int auto_increment primary key,
  Placa varchar(12),
  Conductor varchar(15),
  Ruta int,
  Evento int,
  Descripcion varchar(250),
	Lugar varchar(250),
  FechaIni datetime,
  FechaFin datetime,
  Estado boolean,

	constraint Historico_Vehiculo FOREIGN KEY (Placa) references Vehiculo (Placa) on delete cascade on update cascade,
	constraint Historico_Usuario Foreign Key (Conductor) references Usuario (NumDocumento) on delete cascade on update cascade,
	constraint Historico_Ruta Foreign Key (Ruta) references Ruta (ID) on delete cascade on update cascade,
	constraint Historico_Eventos Foreign Key (Evento) references Eventos (ID) on delete cascade on update cascade

);
