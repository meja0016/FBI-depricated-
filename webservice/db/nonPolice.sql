CREATE TABLE nonPoliceProgram (
    id int,
    name varchar(255)
);
CREATE TABLE nonPoliceProject (
    id int,
    name varchar(255),
    program_id int
);

INSERT INTO nonPoliceProgram (id, name) VALUES (1, 'JFK');
INSERT INTO nonPoliceProject (id, name) VALUES (2, 'Meiers v. Meiers');
INSERT INTO nonPoliceProject (id, name) VALUES (3, 'Meiers v. Meiers');
INSERT INTO nonPoliceProject (id, name) VALUES (4, 'COMPUTER');
INSERT INTO nonPoliceProject (id, name) VALUES (3, 'REAL ESTATE');
INSERT INTO nonPoliceProgram (id, name) VALUES (2, 'Chruch');
INSERT INTO nonPoliceProgram (id, name) VALUES (5, 'USD');
INSERT INTO nonPoliceProgram (id, name) VALUES (6, '1D8723');
INSERT INTO nonPoliceProgram (id, name) VALUES (7, '');
#db2 -c "select * from nonPoliceProgram"
#db2 -tvf /tmp/nonPolice.sql


#<nonPoliceProgram>
#<nonPoliceName>PENTAGON.EMEA</nonPoliceProgram>
#<nonPolicePorjects>
#<nonPoliceProject><nonPoliceName>JFK</nonPoliceName><nonPoliceAddress>ATOMCLOCK</nonPoliceAddress></nonPoliceProject>
#<nonPoliceProject><nonPoliceName>Meiers v. Meiers</nonPoliceName><nonPoliceAddress>REDHOUSE</nonPoliceAddress></nonPoliceProject>
#</nonPoliceProjects> 
#</nonPoliceProgram>
