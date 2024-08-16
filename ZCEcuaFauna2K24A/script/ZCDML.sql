-- database: ../database/ZCEcuaFauna2k24A.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| pat_mic@hotmail.com           pat_mic  |
|----------------------------------------|
Autor : Cesar Zapata 
Fecha : 15.agosto.2k24
Script: Insertando datos en la base de datos EcuaFauna
*/

-- Insertando datos en la tabla Región
INSERT INTO Region (Nombre, IdPais) VALUES
('Costa', (SELECT IdPais FROM Pais WHERE Nombre = 'Ecuador')),
('Sierra', (SELECT IdPais FROM Pais WHERE Nombre = 'Ecuador')),
('Oriente', (SELECT IdPais FROM Pais WHERE Nombre = 'Ecuador')),
('Galápagos', (SELECT IdPais FROM Pais WHERE Nombre = 'Ecuador'));

-- Insertando datos en la tabla Provincia
INSERT INTO Provincia (Nombre, IdRegion) VALUES
('Guayas', 1),       -- Costa
('Pichincha', 2),    -- Sierra
('Pastaza', 3),      -- Oriente
('Santa Cruz', 4);   -- Galápagos

-- Insertando datos en la tabla Alimento
INSERT INTO Alimento (IngestaNativa, GenoAlimento) VALUES
('Carnívoro', 'XY'),
('Herbívoro', 'XX'),
('Omnívoro', 'X'),
('Insectívoro', 'XY'),
('Nectarivoros', 'X');

-- Insertando datos en la tabla Sexo
INSERT INTO Sexo (Descripcion) VALUES
('Macho'),
('Hembra'),
('Asexual');

-- Insertando datos en la tabla Hormiga
INSERT INTO Hormiga (TipoHormiga, IdSexo, IdProvincia, IdAlimento, IngestaNativa) VALUES
-- ('Soldado', 1, 1, 1, 'Carnívoro'),        -- Macho, Guayas, Carnívoro
('Rastreadora', 2, 2, 2, 'Herbívoro'),    -- Hembra, Pichincha, Herbívoro
-- ('Zángano', 3, 3, 3, 'Omnívoro'),         -- Asexual, Pastaza, Omnívoro
-- ('Reina', 1, 4, 4, 'Insectívoro'),        -- Macho, Santa Cruz, Insectívoro
('Larva', 1, 4, 5, 'Nectarivoros');       -- Macho, Santa Cruz, Nectarivoros


-- Consultas de verificación
SELECT * FROM Pais;
SELECT * FROM Region;
SELECT * FROM Provincia;
SELECT * FROM Alimento;
SELECT * FROM Sexo;
SELECT * FROM Hormiga;
