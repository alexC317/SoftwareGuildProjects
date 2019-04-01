DROP DATABASE IF EXISTS GuessTheNumberTestDB;
CREATE DATABASE GuessTheNumberTestDB;

USE GuessTheNumberTestDB;

CREATE TABLE Games(
	gameID INT PRIMARY KEY AUTO_INCREMENT,
    answer VARCHAR(4) NOT NULL,
    isFinished BOOLEAN NOT NULL
);

CREATE TABLE Rounds(
	roundID INT PRIMARY KEY AUTO_INCREMENT,
	gameID INT NOT NULL,
    guess VARCHAR(4) NOT NULL,
	guessTime TIMESTAMP NOT NULL,
    result VARCHAR(7) NOT NULL,
    FOREIGN KEY (gameID) REFERENCES Games(gameID)
);

select * from games;
    
    