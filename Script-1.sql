CREATE TABLE squadron(
	squa_id serial PRIMARY KEY,
	squa_name TEXT UNIQUE NOT NULL,
	active_personal int,
	base_location TEXT NOT NULL,
	years_in_service int,
	aircraft_type TEXT NOT NULL
);
