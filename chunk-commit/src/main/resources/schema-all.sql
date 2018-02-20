DROP TABLE IF EXISTS status;
DROP TABLE IF EXISTS status_after;

CREATE TABLE status  (
    person_id SERIAL NOT NULL PRIMARY KEY,
    status VARCHAR(20)
);

CREATE TABLE status_after  (
    person_id SERIAL NOT NULL PRIMARY KEY,
    status VARCHAR(20)
);