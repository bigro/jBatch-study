DROP TABLE IF EXISTS people;
DROP TABLE IF EXISTS people_upper_case;

CREATE TABLE people  (
    person_id SERIAL NOT NULL PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20)
);

CREATE TABLE people_upper_case  (
    person_id SERIAL NOT NULL PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20)
);