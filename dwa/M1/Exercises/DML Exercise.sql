DROP DATABASE IF EXISTS MovieCatalogue;

CREATE DATABASE MovieCatalogue;

USE MovieCatalogue;

CREATE TABLE Genre (
	GenreID INT PRIMARY KEY AUTO_INCREMENT,
    GenreName VARCHAR(30) NOT NULL
);

CREATE TABLE Director (
	DirectorID INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(30) NOT NULL,
    LastName VARCHAR(30) NOT NULL,
    BirthDate DATE
);

CREATE TABLE Rating (
	RatingID INT PRIMARY KEY AUTO_INCREMENT,
    RatingName VARCHAR(5) NOT NULL
);

CREATE TABLE Actor (
	ActorID INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(30) NOT NULL,
    LastName VARCHAR(30) NOT NULL,
    BirthDate DATE
);

CREATE TABLE Movie (
	MovieID INT PRIMARY KEY AUTO_INCREMENT,
    GenreID INT NOT NULL,
    DirectorID INT,
    RatingID INT,
    Title VARCHAR(128) NOT NULL,
    ReleaseDate DATE,
    FOREIGN KEY (GenreID) REFERENCES Genre(GenreID),
    FOREIGN KEY (DirectorID) REFERENCES Director(DirectorID),
    FOREIGN KEY (RatingID) REFERENCES Rating(RatingID)
);

CREATE TABLE CastMember (
	CastMemberID INT PRIMARY KEY AUTO_INCREMENT,
    ActorID INT NOT NULL,
    MovieID INT NOT NULL,
    `Role` VARCHAR(50) NOT NULL,
    FOREIGN KEY (ActorID) REFERENCES Actor(ActorID),
    FOREIGN KEY (MovieID) REFERENCES Movie(MovieID)
);

INSERT INTO Actor(FirstName, LastName, BirthDate) VALUES 
	('Bill', 'Murray', '1950/09/21'),
    ('Dan', 'Akroyd', '1952/07/01'),
    ('John', 'Candy', '1950/10/31'),
    ('Steve', 'Martin', NULL),
	('Syllvester', 'Stallone', NULL);
    
INSERT INTO Director(FirstName, LastName, BirthDate) VALUES
	('Ivan', 'Reitman', '1946/10/27'),
    ('Ted', 'Kotcheff', NULL);
    
INSERT INTO Rating(RatingName) VALUES
	('G'),
    ('PG'),
    ('PG-13'),
    ('R');
    
    
INSERT INTO Genre(GenreName) VALUES
	('Action'),
    ('Comedy'),
    ('Drama'),
    ('Horror');
    
INSERT INTO Movie(GenreID, DirectorID, RatingID, Title, ReleaseDate) VALUES
	(1, 2, 4, 'Rambo: First Blood', '1982/10/22'),
    (2, NULL, 4, 'Planes, Trains & Automobiles', '1987/11/25'),
    (2, 1, 2, 'Ghostbusters', NULL),
    (2, NULL, 2, 'The Great Outdoors', '1988/06/17');
    
INSERT INTO CastMember(ActorID, MovieID, `Role`) VALUES 
	(5, 1, 'John Rambo'),
    (4, 2, 'Neil Page'),
    (3, 2, 'Del Griffith'),
    (1, 3, 'Dr. Peter Venkman'),
    (2, 3, 'Dr. Raymond Stanz'),
    (2, 4, 'Roman Craig'),
    (3, 4, 'Chet Ripley');
    
UPDATE Movie SET
	Title = 'Ghostbusters (1984)',
    ReleaseDate = '1984-06-08'
WHERE MovieID = 3;

UPDATE Genre SET
	GenreName = 'Action/Adventure'
WHERE GenreID = 1;

DELETE FROM CastMember
WHERE CastMemberID = 1;

DELETE FROM Movie
WHERE MovieID = 1;

ALTER TABLE Actor
	ADD COLUMN (DateOfDeath DATE NULL);

UPDATE Actor SET
	DateOfDeath = '1994/03/04'
WHERE ActorID = 3;