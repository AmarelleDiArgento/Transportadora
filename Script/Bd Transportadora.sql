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
-- ------------------------------------------------------------------------------------------------------------------------
-- TABLA "RUTA"
-- ------------------------------------------------------------------------------------------------------------------------
 create table if not exists Transportadora.Ruta (
   ID int auto_increment primary key,
   Nombre varchar(45) unique not null,
   HoraIni time,
   Horafin time,
   Km float,
   LugarInicio varchar(60),
   LugarFin varchar(60)
 );

 -- ------------------------------------------------------------------------------------------------------------------------
 -- TABLA "EMPRESA"
 -- ------------------------------------------------------------------------------------------------------------------------
 create table if not exists Transportadora.Empresa(
   Nit varchar(11) primary key,
   RazonSoc varchar(70) unique,
   Representante varchar (70),
   Telefono varchar(10),
   Direccion varchar(65),
   Arl varchar(30),
   Estado boolean
 )

 /*
 Campos:
   ID,Nombre,HoraIni,Horafin,Km,LugarInicio,LugarFin
   rID,rNombre,rHoraIni,rHorafin,rKm,rLugarInicio,rLugarFin
 */
