DROP TABLE if exists Films;

DROP TABLE if exists Director;

CREATE TABLE Director
(
    id integer NOT NULL PRIMARY KEY
    , first_name varchar(255) NOT NULL
    , last_name varchar(255) NOT NULL
    , birth_date date NOT NULL
);

CREATE TABLE Films
(
    id integer NOT NULL PRIMARY KEY
    , director_id integer NOT NULL
    , name varchar(255)
    , release_date date
    , genre varchar(255)
);

ALTER TABLE Films
    ADD CONSTRAINT DirectorId FOREIGN KEY(director_id) REFERENCES Director(id);

INSERT INTO Director VALUES
                         (1, 'Brian', 'De Palma', '1940-09-11'),
                         (2, 'Danny', 'DeVito', '1944-11-17'),
                         (3, 'Luc', 'Besson', '1959-03-18'),
                         (4, 'Sofiya', 'Kustikova', '2002-04-01'),
                         (5, 'Alexey', 'Deboy', '1999-09-27');

INSERT INTO Films VALUES
                      (1, 1, 'Scarface', '1983-12-01', 'Thriller'),
                      (2, 2, 'Matilda', '1996-08-02', 'Comedy'),
                      (3, 3, 'Leon', '1994-09-14', 'Thriller'),
                      (4, 1, 'Femme Fatale', '2002-11-06', 'Neo-noir'),
                      (5, 5, 'Psychologist', '2021-08-06', 'Neo-noir'),
                      (6, 5, 'Voencomat', '2021-08-06', 'Horror');