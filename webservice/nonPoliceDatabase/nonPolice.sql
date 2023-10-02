CREATE TABLE nonPoliceProgram (
    id int,
    name varchar(255)
);
CREATE TABLE nonPoliceProject (
    id int,
    name varchar(255),
    program_id int
);

create table nonPoliceTRX ( id int, name varchar(20),description varchar(120),year int)
alter table nonPoliceTRX add column date TIMESTAMP with default current timestamp;
INSERT INTO nonPoliceTRX (id, name,description,year) VALUES (1, '§Stalking','',2023);
INSERT INTO nonPoliceTRX (id, name,description,year) VALUES (1, 'SQ.CDCR','SQ.CPVA.§187.PREA  IPX[].INT PRESIDENT.AVALABLITY (52 Deere Park Ave),thomas-is-dieter:wieland,Raik',2007);

INSERT INTO nonPoliceProgram (id, name) VALUES (1, 'JFK');
INSERT INTO nonPoliceProject (id, name) VALUES (2, 'Meiers v. Meiers');
INSERT INTO nonPoliceProject (id, name) VALUES (3, 'Meiers v. Meiers');
INSERT INTO nonPoliceProject (id, name) VALUES (4, 'COMPUTER');
INSERT INTO nonPoliceProject (id, name) VALUES (3, 'REAL ESTATE');
INSERT INTO nonPoliceProgram (id, name) VALUES (2, 'Chruch');
INSERT INTO nonPoliceProgram (id, name) VALUES (5, 'USD');
INSERT INTO nonPoliceProgram (id, name) VALUES (6, '1D8723');
INSERT INTO nonPoliceProgram (id, name) VALUES (7, 'COMMUNCATIONS');
INSERT INTO nonPoliceProgram (id, name) VALUES (8, 'ATOMBOMB');
#db2 -c "select * from nonPoliceProgram"
#db2 -tvf /tmp/nonPolice.sql

#<nonPoliceProgram>
#<nonPoliceName>PENTAGON.EMEA</nonPoliceProgram>
#<nonPolicePorjects>
#<nonPoliceProject><nonPoliceName>JFK</nonPoliceName><nonPoliceAddress>ATOMCLOCK</nonPoliceAddress></nonPoliceProject>
#<nonPoliceProject><nonPoliceName>Meiers v. Meiers</nonPoliceName><nonPoliceAddress>REDHOUSE</nonPoliceAddress></nonPoliceProject>
#</nonPoliceProjects> 
#</nonPoliceProgram>

#SQL1024N  A database connection does not exist
#connect to npolice
