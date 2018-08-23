/* Procedimientos tabla Roles */


CREATE procedure if not EXISTS LisRoles() select * from Roles;



create procedure InsRol(in NombreNew varchar(20), in DescripcionNew varchar(30))
insert into Roles(Nombre, Descripcion) values(NombreNew, DescripcionNew);



create procedure ActRol(in IDold int,in Descrip varchar(30))
update Roles set Descripcion=Descrip where ID=IDold;



create procedure EliRol(in IDold int)
delete from Roles where ID=IDold;



/*  Procedimientos tabla empresa */



create procedure LisRoles() select * from Empresa;



create procedure InsEmp(in NitNew varchar(15),in RazonSocNew varchar(10),in RepresentanteNew varchar(20),
in TelefonoNew varchar(12),in DireccionNew varchar(20),in EstadoNew enum('Activo', 'inactivo'))

insert into Empresa (Nit,RazonSoc,Representante,Telefono,Direccion,Estado) values(NitNew,RazonSocNew,RepresentanteNew,TelefonoNew,DireccionNew,EstadoNew);



create procedure ActuEmp(in NitOld varchar(15),in RazonSocNew varchar(10),in RepresentanteNew varchar(20),
in TelefonoNew varchar(12), in DireccionNew varchar(20),in EstadoNew enum('Activo', 'inactivo'))

update Empresa set RazonSoc=RazonSocNew,Representante=RepresentanteNew,Telefono=TelefonoNew,Direccion=DireccionNew,Estado=EstadoNew where Nit=NitOld;



create procedure ElimEmp(in NitOld varchar(15))
delete from Roles where Nit=NitOld;



/*  Procedimientos tabla Usuario*/


create procedure LisUsu() select TipoDocumento,NumDocumento,Nombres,Telefono,Direccion,Eps,Correo,Foto,Nombre,RazonSoc from Usuario
inner join Roles on Usuario.Rol=Roles.Nombre inner join Empresa on Usuario.Empreza=Empreza.RazonSoc;



create procedure InsUsu(in TipoDocumentoNew varchar(10),in NumDocumentoNew varchar(15),in NombresNew varchar(50),

in TelefonoNew varchar(12),in DireccionNew varchar(20),in EpsNew enum ('Nueva EPS', 'Coomeva', 'Famisanar'),
in ArlNew enum('Sura'),
in CorreoNew varchar(50),in
Contrase�aNew varchar(12),in FotoNew varchar(250),in RolNew int,

in EmpresaNew varchar(15),in EstadoNew enum('Activo','inactivo'))

insert into Usuario(TipoDocumento,NumDocumento,Nombres,Telefono,Direccion,Eps,Eps,Correo,Contrase�a,Foto,Rol,Empresa,Estado)

values(TipoDocumentoNew,NumDocumentoNew,NombresNew,TelefonoNew,DireccionNew,EpsNew,EpsNew,CorreoNew,Contrase�aNew,FotoNew,RolNew,EmpresaNew,EstadoNew);



create procedure ActUsu(in TipoDocumento varchar(10),in NumDocumentoOld varchar(15),in NombresNew varchar(50),

in TelefonoNew varchar(12),in DireccionNew varchar(20),in EpsNew enum ('Nueva EPS', 'Coomeva', 'Famisanar'),
in Arl enum('Sura'),
in Correo varchar(50),in
Contrase�a varchar(12),in Foto varchar(250),in Estado enum('Activo', 'inactivo'))
update Usuario set TipoDocumento=TipoDocumentoNew,Nombres=NombresNew,Telefono=TelefonoNew,Direccion=DireccionNew,Eps=EpsNew,Correo=CorreoNew,Contrase�a=Contrase�aNew,Foto=FotoNew,Estado=EstadoNew where NumDocumentoOld=NumDocumentoOld;

create procedure ElimEmp(in NumDocumentoOld varchar(15))
delete from Empresa where NumDocumento=NumDocumentoOld;


/*  Procedimientos tabla Rutas */

create procedure LisRut() select * from Rutas;



create procedure InsRut(in NombreNew varchar(20),in HorarioIniNew time,in horarioFinNew time,

in KmNew dec(5,2),
in LugarIniNew varchar(12),
in LugarFinNew varchar(12))

insert into Rutas(Nombre, HorarioIni, horarioFin, Km, LugarIni,LugarFin)values(NombreNew, HorarioIniNew, horarioFinNew, KmNew, LugarIniNew,LugarFinNew);



create procedure ActRut(in IDOld int,in NombreNew varchar(20),in HorarioIniNew time,in horarioFinNew time,

in KmNew dec(5,2),
in LugarIniNew varchar(12),
in LugarFinNew varchar(12))

update Ruta set Nombre=NombreNew, HorarioIni=HorarioIniNew, horarioFin=horarioFin, Km=KmNew, LugarIni=LugarIniNew, LugarFin=LugarFinNew where ID=IDOld;



create procedure EliRut(in IDOld int)delete from Rutas where ID=IDOld;



/* Procedimientos tabla Eventos */



create procedure LisEve() select * from Eventos;

create procedure InsEve(in NombreEveNew enum('Accidente','Asigna Ruta','Asigna Conductor','Falla mecanica','Mantenimiento','Robo')
)

insert into Eventos(nombreEve) values(NombreEveNew);

create procedure EliEve(in IDOld int) delete from Evento where ID=IDOld;

/* Procedimientos tabla hojdaVehi */



/*create procedure LisHV() select */


create procedure InsHVV(in TecnomecanicaNew varchar(250), in SoatNew varchar(250)
)
insert into HojaVehi(Tecnomecanica ,Soat)values(TecnomecanicaNew, SoatNew);



create procedure ActHVV(in IDOld int, in TecnomecanicaNew varchar(250), in SoatNew varchar(250))
update HojaVehi set Tecnomecanica=TecnomecanicaNew ,Soat=SoatNew where ID=IDOld;



create procedure EliHVV(in IDOld int) delete from HojaVehi where ID=IDOld;



/* Procedimientos Tabla Vehiculo */



create procedure LisVehi()select Placa,Marca,Modelo,Chasis, Pasajeros, RazonSoc from Vehiculo;

create procedure InsVehi(in PlacaNew varchar(12),in MarcaNew varchar(12),in ModeloNew int,

in ChasisNew varchar(20),in PasajerosNew int,in EmpresaNew varchar(15),in DatoHojaVehiNew int)

insert into Vehiculo(Placa,Marca,Modelo,Chasis,Pasajeros,Empresa,DatoHojdaVehi)
values(PlacaNew,MarcaNew,ModeloNew,ChasisNew,PasajerosNew,EmpresaNew,DatoHojdaVehiNew);



/* Este es para poder ver los datos incritos en la tabla HojdaVida por Vehiculo */
create procedure LisDaVe(in PlacaOld varchar(12))select Tecnomecanica,Soat from HojaVehi inner join Vehiculo
on HojaVehi.ID=Vehiculo.DatoHojaVehi where Placa=PlacaOld;



create procedure ActVehi(in PlacaOld varchar(12),in MarcaNew varchar(12),in ModeloNew int,
in ChasisNew varchar(20),in PasajerosNew int,in EmpresaNew varchar(15),in DatoHojaVehiNew int)
update Vehiculo set Marca=MarcaNew,Modelo=ModeloNew,Chasis=ChasisNew,Pasajeros=PasajerosNew, Empresa=EmpresaNew, DatoHojaVehi=DatoHojaVehiNew where placa=PlacaOld;



create procedure EliVehi(in PlacaOld varchar(12)) delete From Vehiuclo where Placa=PlacaOld;



/*  Procediminetos Historico */



create procedure LisHis() select * from Historico;



create procedure InsHis(in PlacaNew varchar(12),ConductorNew varchar(15),in RutaNew int,in EventoNew int,in DescripcionNew varchar(250),in LugarNew varchar(250),in FechaIniNew datetime,in FechaFinNew datetime,
in EstadoNew enum('Proceso', 'Finalizado')

)

insert into Historico(Placa,Conductor,Ruta,Evento,Descripcion,Lugar,FechaIni,FechaFin,Estado)values(PlacaNew,ConductorNew,RutaNew,EventoNew,DescripcionNew,LugarNew,FechaIniNew,FechaFinNew,EstadoNew);



create procedure ActHis(in IdOld int,in PlacaNew varchar(12),ConductorNew varchar(15),in RutaNew int,in EventoNew int,in DescripcionNew varchar(250),in LugarNew varchar(250),in FechaIniNew datetime,in FechaFinNew datetime,
in EstadoNew enum('Proceso', 'Finalizado'))

update Historico set Placa=PlacaNew,Conductor=ConductorNew,Ruta=RutaNew,Evento=EventoNew,Descripcion=DescripcionNew,Lugar=LugarNew,FechaIni=FechaIniNew,FechaFin=FechaFinNew,Estado=EstadoNew where ID=IdOld;



create procedure EliHis(in IdOld int) delete from Historico where ID=IdOld;
