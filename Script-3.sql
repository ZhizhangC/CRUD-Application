CREATE TABLE squadron(
	squa_id int PRIMARY KEY,
	squa_name TEXT UNIQUE NOT NULL,
	active_personal int,
	base_location TEXT NOT NULL,
	aircraft_type TEXT NOT NULL
);

CREATE TABLE personal(
	personal_id serial PRIMARY KEY,
	personal_name TEXT NOT NULL,
	years_in_service int,
	squa_id_fk serial REFERENCES squadron(squa_id)
)

INSERT INTO squadron (squa_id, squa_name, active_personal, base_location, aircraft_type)
VALUES ('1', 'Alpha', '34', 'Norfolk', 'Lightning'),
	   ('2', 'Bravo', '28', 'SanDiego', 'Strike Eagle'),
	   ('3', 'Delta', '89', 'Pensacola', 'Lancer'),
	   ('4', 'Echo', '20', 'Everitte', 'Harrier');

INSERT INTO personal(personal_name, years_in_service, squa_id_fk)
VALUES ('Mario', '12', '2'),
	   ('Luigi', '12', '2'),
	   ('Todd', '8', '3'),
	   ('Peach', '15', '1'),
	   ('Dassy', '10', '4'),
	   ('Yoshi', '4', '4');