-- database: ../database/ZCEcuaFauna2k24A.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| pat_mic@hotmail.com           pat_mic  |
|----------------------------------------|
Autor : Cesar Zapata 
Fecha : 15.julio.2k24
Script: Creacion de la estructura de datos para EcuaFauna
*/

-- Eliminación de tablas existentes
DROP TABLE IF EXISTS Hormiga;
DROP TABLE IF EXISTS Alimento;
DROP TABLE IF EXISTS Sexo;
DROP TABLE IF EXISTS Provincia;
DROP TABLE IF EXISTS Region;
DROP TABLE IF EXISTS Pais;

-- Creación de tabla País
-- CREATE TABLE Pais (
--      IdPais        INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
--     ,Nombre        VARCHAR(50) NOT NULL UNIQUE
--     ,Estado        VARCHAR(1)  NOT NULL DEFAULT('A')
--     ,FechaCrea DATETIME    DEFAULT(datetime('now','localtime'))
--     ,FechaModifica DATETIME
-- );

-- Creación de tabla País
CREATE TABLE Pais (
     IdPais        INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT,
     Nombre        VARCHAR(50) NOT NULL UNIQUE,
     Estado        VARCHAR(1)  NOT NULL DEFAULT('A'),
     FechaCrea     DATETIME    DEFAULT(datetime('now','localtime')),
     FechaModifica DATETIME
);

-- Insertando el país Ecuador si aún no existe
INSERT OR IGNORE INTO Pais (Nombre) VALUES ('Ecuador');



-- Creación de tabla Región
CREATE TABLE Region (
     IdRegion      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Nombre        VARCHAR(50) NOT NULL UNIQUE
    ,IdPais        INTEGER     NOT NULL REFERENCES Pais (IdPais)
    ,Estado        VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCrea DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica DATETIME
);

-- Creación de tabla Provincia
CREATE TABLE Provincia (
     IdProvincia   INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Nombre        VARCHAR(50) NOT NULL UNIQUE
    ,IdRegion      INTEGER     NOT NULL REFERENCES Region (IdRegion)
    ,Estado        VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCrea DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica DATETIME
);

-- Creación de tabla Alimento
CREATE TABLE Alimento (
     IdAlimento    INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IngestaNativa VARCHAR(20) NOT NULL CHECK (IngestaNativa IN ('Carnívoro', 'Herbívoro', 'Omnívoro', 'Insectívoro', 'Nectarivoros'))
    ,GenoAlimento  VARCHAR(2)  NOT NULL CHECK (GenoAlimento IN ('X', 'XX', 'XY'))
    ,Estado        VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCrea DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica DATETIME
);

-- Creación de tabla Sexo
CREATE TABLE Sexo (
     IdSexo        INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Descripcion   VARCHAR(20) NOT NULL UNIQUE
    ,Estado        VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCrea DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica DATETIME
);

-- Creación de tabla Hormiga
CREATE TABLE Hormiga (
     IdHormiga     INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,TipoHormiga   VARCHAR(50) NOT NULL
    ,IdSexo        INTEGER     NOT NULL REFERENCES Sexo (IdSexo)
    ,IdProvincia   INTEGER     NOT NULL REFERENCES Provincia (IdProvincia)
    ,IdAlimento    INTEGER     NOT NULL REFERENCES Alimento (IdAlimento)
    ,IngestaNativa VARCHAR(20) NOT NULL
    ,Estado        VARCHAR(1)  NOT NULL DEFAULT('VIVA')
    ,FechaCrea DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica DATETIME
);
