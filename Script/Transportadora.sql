CREATE USER IF NOT EXISTS 'Taller1'@'localhost' IDENTIFIED BY 'Taller1';
GRANT ALL PRIVILEGES ON * . * TO 'Taller1'@'localhost';FLUSH PRIVILEGES;

CREATE DATABASE IF NOT EXISTS taller1;

use taller1;



CREATE TABLE IF NOT EXISTS Rol(

	ID int auto_increment primary key,

	Nombre varchar (20) unique not null,

	Descripcion varchar (30),

	    Jerarquia int not null,
	Estado boolean default False


);

create table if not exists Permiso(

	ID int auto_increment primary key,

    Nombre varchar (20) unique not null,

    Url text,

    Estado boolean default False
);

create table if not exists Asignar(

	IdRol int not null,

    IdPer int  not null,

    Leer  int(4),

    Nuevo boolean default false,

    Modificar boolean default false,

    Eliminar boolean default false,

    constraint Asignar_Rol Foreign Key (IdRol) references Rol(ID) on delete cascade on update cascade,

    constraint Asignar_Permiso Foreign Key (IdPer) references Permiso(ID) on delete cascade on update cascade

);


CREATE TABLE IF NOT EXISTS  Empresa(

	Nit varchar(15) primary key,

	RazonSoc varchar(10) unique not null,

	Representante varchar(20),

	Telefono varchar (12),

	Direccion varchar (20),

    Arl varchar(20),

	Estado boolean default False
);

CREATE TABLE IF NOT EXISTS Usuario(

	TipoDocumento varchar(10) NOT NULL,

	NumDocumento varchar(15) primary key,

	Nombres varchar(50) NOT NULL,

	Telefono varchar(12),

	Direccion varchar(20),

	Eps varchar(20),

	Correo varchar(50),

	Contrasena varchar(255) NOT NULL,

	Foto varchar(255),

	Rol int,

	Empresa varchar(20),

	Estado boolean default False,

   constraint Usuario_Rol Foreign Key (Rol) references Rol(ID) on delete cascade on update cascade,

   constraint Usuario_Empresa Foreign Key (Empresa) references Empresa (Nit) on delete cascade on update cascade

);


CREATE TABLE IF NOT EXISTS Ruta(

	ID int auto_increment primary key,

	Nombre varchar(20) unique NOT NULL,

	HorarioIni time NOT NULL,

	horarioFin time NOT NULL,

	Km dec(5,2) NOT NULL,

	LugarIni varchar(12) NOT NULL,

	LugarFin varchar(12) NOT NULL,

	Estado boolean default false

);

CREATE TABLE IF NOT EXISTS  Evento(

	ID int auto_increment primary key,

	NombreEve enum('Accidente','Asigna Ruta','Asigna Conductor','Falla mecanica','Mantenimiento','Robo')

);


CREATE TABLE IF NOT EXISTS  Vehiculo(

	Placa varchar(12) primary key,

	Marca varchar(12),

	Modelo int,

	Chasis varchar(20) unique NOT NULL,

	Pasajeros int NOT NULL,

	Empresa varchar(15),

    Estado boolean default false,

    constraint Vehiculo_Empresa Foreign Key (Empresa) references Empresa (Nit) on delete cascade on update cascade

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
	Estado boolean default true,

	constraint Historico_Vehiculo FOREIGN KEY (Placa) references Vehiculo (Placa) on delete cascade on update cascade,
	constraint Historico_Usuario Foreign Key (Conductor) references Usuario (NumDocumento) on delete cascade on update cascade,
	constraint Historico_Ruta Foreign Key (Ruta) references Ruta (ID) on delete cascade on update cascade,
	constraint Historico_Eventos Foreign Key (Evento) references Evento (ID) on delete cascade on update cascade

);

/***************************************************************************************************************************/

/* Procedimientos tabla Roles */

create procedure if not exists InsRol(in NombreNew varchar(20), in JerarquiaNew int, in DescripcionNew varchar(30),  in EstadoNew boolean)
BEGIN
	insert into  Rol(Nombre, Jerarquia, Descripcion, Estado) values(NombreNew, JerarquiaNew, DescripcionNew, EstadoNew);
END;

	Call taller1.InsRol("Administrador",1,"Control total",true);
	Call taller1.InsRol("Coordinador Empresa",2,"Control total",true);
	Call taller1.InsRol("Conductor",3,"Acceso minimo",true);

create procedure if not exists ActRol(in IdOld int,in NombreOld varchar(20), in DescripcionOld varchar(30), in JerarquiaOld int, in EstadoOld boolean)
BEGIN
	update Rol set Nombre=NombreOld, Jerarquia=JerarquiaOld, Descripcion=DescripcionOld, Estado=EstadoOld where ID=IdOld;
END;

create procedure if not exists EliRol(in IDold int)
BEGIN
	delete from Rol where ID=IDold;
END;

create procedure if not exists LisRol()
BEGIN
	select ID, Nombre, Jerarquia, Descripcion, Estado from Rol;
END;


create procedure if not exists ConRol(in IdOld int)
BEGIN
	select ID, Nombre, Jerarquia, Descripcion, Estado from Rol where ID=IdOld;
END;

/*  Procedimientos tabla empresa */

create procedure if not exists LisEmp()
BEGIN
	select Nit,RazonSoc,Representante,Telefono,Direccion,Arl,Estado from Empresa;
END;

create procedure if not exists InsEmp(in NitNew varchar(15),in RazonSocNew varchar(10),in RepresentanteNew varchar(20),in TelefonoNew varchar(12),in DireccionNew varchar(20),in ArlNew varchar(20),in EstadoNew boolean)
BEGIN
	insert into Empresa (Nit,RazonSoc,Representante,Telefono,Direccion,Arl,Estado) values(NitNew,RazonSocNew,RepresentanteNew,TelefonoNew,DireccionNew,ArlNew,EstadoNew);
END;
Call taller1.InsEmp("800678943-7","Coltrans","Antonio de las Casas","2456789","Cra. 35 No. 12 56","Sura",true)

create procedure if not exists ActuEmp(in NitOld varchar(15),in RazonSocOld varchar(10),in RepresentanteOld varchar(20),in TelefonoOld varchar(12), in DireccionOld varchar(20),in ArlOld varchar(20), in EstadoOld boolean)
BEGIN
	update Empresa set RazonSoc=RazonSocOld,Representante=RepresentanteOld,Telefono=TelefonoOld,Direccion=DireccionOld,Arl=ArlOld,Estado=EstadoOld where Nit=NitOld;
END;

create procedure EliEmp(in NitOld varchar(15))
BEGIN
	delete from Empresa where Nit=NitOld;
END;

/*  Procedimientos tabla Usuario*/


create procedure LisUsu() select TipoDocumento,NumDocumento,Nombres,Usuario.Telefono,Usuario.Direccion,Eps,Correo,Foto,Rol.Nombre,Empresa.RazonSoc,Usuario.Estado from Usuario inner join Rol on Usuario.Rol=Rol.ID inner join Empresa on Usuario.Empresa=Empresa.Nit;



create procedure InsUsu(in TipoDocumentoNew varchar(10),in NumDocumentoNew varchar(15),in NombresNew varchar(50),
in TelefonoNew varchar(12),in DireccionNew varchar(20),in EpsNew enum ('Nueva EPS', 'Coomeva', 'Famisanar'),
in CorreoNew varchar(50),in ContrasenaNew varchar(12),in FotoNew varchar(250),
in RolNew int,in EmpresaNew varchar(15))

insert into Usuario(TipoDocumento,NumDocumento,Nombres,Telefono,Direccion,Eps,Correo,Contrasena,Foto,Rol,Empresa)

values(TipoDocumentoNew,NumDocumentoNew,NombresNew,TelefonoNew,DireccionNew,EpsNew,CorreoNew,ContrasenaNew,FotoNew,RolNew,EmpresaNew);



create procedure ActUsu(in TipoDocumentoNew varchar(10),in NumDocumentoOld varchar(15),in NombresNew varchar(50),
in TelefonoNew varchar(12),in DireccionNew varchar(20),
in EpsNew enum ('Nueva EPS', 'Coomeva', 'Famisanar'),
in CorreoNew varchar(50),in ContrasenaNew varchar(12),
in FotoNew varchar(250),in EstadoNew boolean)

update Usuario set TipoDocumento=TipoDocumentoNew,Nombres=NombresNew,Telefono=TelefonoNew,Direccion=DireccionNew,Eps=EpsNew,Correo=CorreoNew,Contrasena=ContrasenaNew,Foto=FotoNew,Estado=EstadoNew where NumDocumento=NumDocumentoOld;

create procedure EliUsu(in NumDocumentoOld varchar(15))delete from Usuario where NumDocumento=NumDocumentoOld;


/*  Procedimientos tabla Rutas */

create procedure LisRut() select * from Ruta;


create procedure InsRut(in NombreNew varchar(20),in HorarioIniNew time,in horarioFinNew time,

in KmNew dec(5,2),
in LugarIniNew varchar(12),
in LugarFinNew varchar(12))

insert into Ruta(Nombre, HorarioIni, horarioFin, Km, LugarIni,LugarFin)values(NombreNew, HorarioIniNew, horarioFinNew, KmNew, LugarIniNew,LugarFinNew);


create procedure ActRut(in IdOld int,in NombreNew varchar(20),in HorarioIniNew time,in horarioFinNew time,

in KmNew dec(5,2),
in LugarIniNew varchar(12),
in LugarFinNew varchar(12))

update Ruta set Nombre=NombreNew, HorarioIni=HorarioIniNew, horarioFin=horarioFin, Km=KmNew, LugarIni=LugarIniNew, LugarFin=LugarFinNew where ID=IdOld;


create procedure EliRut(in IdOld int)delete from Ruta where ID=IdOld;

/* Procedimientos tabla Eventos */

create procedure LisEve() select * from Evento;

create procedure InsEve(in NombreEveNew enum('Accidente','Asigna Ruta','Asigna Conductor','Falla mecanica','Mantenimiento','Robo'))
insert into Evento(nombreEve) values(NombreEveNew);

create procedure EliEve(in IdOld int) delete from Evento where ID=IdOld;


/* Procedimientos Tabla Vehiculo */


create procedure LisVehi()select Placa,Marca,Modelo,Chasis, Pasajeros, RazonSoc from Vehiculo inner join Empresa on Vehiculo.Empresa=Empresa.nit;

create procedure InsVehi(in PlacaNew varchar(12),in MarcaNew varchar(12),in ModeloNew int,
in ChasisNew varchar(20),in PasajerosNew int,in EmpresaNew varchar(15))
insert into Vehiculo(Placa,Marca,Modelo,Chasis,Pasajeros,Empresa)
values(PlacaNew,MarcaNew,ModeloNew,ChasisNew,PasajerosNew,EmpresaNew);



create procedure ActVehi(in PlacaOld varchar(12),in MarcaNew varchar(12),in ModeloNew int,
in ChasisNew varchar(20),in PasajerosNew int,in EmpresaNew varchar(15))
update Vehiculo set Marca=MarcaNew,Modelo=ModeloNew,Chasis=ChasisNew,Pasajeros=PasajerosNew, Empresa=EmpresaNew where placa=PlacaOld;


create procedure EliVehi(in PlacaOld varchar(12)) delete From Vehiculo where Placa=PlacaOld;


/*  Procediminetos Historico */



create procedure LisHis() select * from Historico;

create procedure LisHis1() select Historico.ID, placa, Usuario.Nombres,Ruta.Nombre,Evento.NombreEve,Descripcion,Lugar,FechaIni,FechaFin,Historico.Estado
from Historico inner join Usuario on historico.Conductor=Usuario.NumDocumento inner join Evento on Historico.Evento=Evento.ID inner join Ruta
on Historico.Ruta=Ruta.ID;



create procedure InsHis(in PlacaNew varchar(12),in ConductorNew varchar(15),in RutaNew int,in EventoNew int,in DescripcionNew varchar(250),in LugarNew varchar(250)
)insert into Historico(Placa,Conductor,Ruta,Evento,Descripcion,Lugar,FechaIni)values(PlacaNew,ConductorNew,RutaNew,EventoNew,DescripcionNew,LugarNew,now());



create procedure ActHis(in IdOld int,in PlacaNew varchar(12),in ConductorNew varchar(15),in RutaNew int,in EventoNew int,in DescripcionNew varchar(250),in LugarNew varchar(250)
)update Historico set Placa=PlacaNew,Conductor=ConductorNew,Ruta=RutaNew,Evento=EventoNew,Descripcion=DescripcionNew,Lugar=LugarNew where ID=IdOld;

create procedure TerminarHisto(in IdOld int)
update Historico set FechaFin=now(), Estado=False where ID=IdOld;


create procedure EliHis(in IdOld int) delete from Historico where ID=IdOld;
