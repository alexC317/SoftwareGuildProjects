DROP DATABASE IF EXISTS DVDLibrary;
CREATE DATABASE DVDLibrary;

USE DVDLibrary;

CREATE TABLE Director(
	ID INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL
);

CREATE TABLE DVD(
	ID INT PRIMARY KEY AUTO_INCREMENT,
    directorID INT NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    releaseDate DATE NOT NULL,
    rating VARCHAR(5) NOT NULL,
    FOREIGN KEY (directorID) REFERENCES Director(ID)
);

INSERT INTO Director(`name`) VALUES('George Lucas');
INSERT INTO Director(`name`) VALUES('Mamoru Hosoda');
INSERT INTO Director(`name`) VALUES('Joseph Kosinski');

INSERT INTO DVD(directorID, `name`, releaseDate, rating) VALUES (1, 'Return of the Jedi', '2006-09-12', 'PG');
INSERT INTO DVD(directorID, `name`, releaseDate, rating) VALUES (2, 'Mirai', '2019-04-09', 'PG');
INSERT INTO DVD(directorID, `name`, releaseDate, rating) VALUES (2, 'Wolf Children', '2013-11-26', 'PG');
INSERT INTO DVD(directorID, `name`, releaseDate, rating) VALUES (3, 'Tron: Legacy', '2011-04-05', 'PG');