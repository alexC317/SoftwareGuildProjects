DROP DATABASE IF EXISTS superSightingDB;
CREATE DATABASE superSightingDB;
USE superSightingDB;

CREATE TABLE Supers(
	superID INT PRIMARY KEY AUTO_INCREMENT,
    superName VARCHAR(50) NOT NULL UNIQUE,
    superDescription VARCHAR(50) NOT NULL
);

CREATE TABLE Powers(
	powerID INT PRIMARY KEY AUTO_INCREMENT,
    powerName VARCHAR(50) NOT NULL,
    powerDescription VARCHAR(50) NOT NULL
);
CREATE TABLE Locations(
	locationID INT PRIMARY KEY AUTO_INCREMENT,
    locationName VARCHAR(50) NOT NULL,
    locationDescription VARCHAR(60) NOT NULL,
    locationAddress VARCHAR(60) NOT NULL,
    locationLongitude VARCHAR(50), 
    locationLatitude VARCHAR(50)
);

CREATE TABLE Organizations(
	organizationID INT PRIMARY KEY AUTO_INCREMENT, 
    organizationName VARCHAR(50) NOT NULL,
    organizationDescription VARCHAR(50) NOT NULL,
    organizationContact VARCHAR(50) NOT NULL,
    locationID INT NULL,
    FOREIGN KEY (locationID) REFERENCES Locations(locationID)
);

CREATE TABLE Superpowers(
	superID INT NOT NULL,
    powerID INT NOT NULL,
    CONSTRAINT PK_Superpower PRIMARY KEY (superID, powerID),
    FOREIGN KEY (superID) REFERENCES Supers(superID),
    FOREIGN KEY (powerID) REFERENCES Powers(powerID)
);

CREATE TABLE Sightings(
	sightingID INT PRIMARY KEY AUTO_INCREMENT,
    sightingDate DATE NOT NULL,
    superID INT NOT NULL,
    locationID INT NOT NULL,
    FOREIGN KEY (superID) REFERENCES Supers(superID),
    FOREIGN KEY (locationID) REFERENCES Locations(locationID)
);

CREATE TABLE Supers_Organizations(
	superID INT NOT NULL,
    organizationID INT NOT NULL,
    FOREIGN KEY (superID) REFERENCES Supers(superID),
    FOREIGN KEY (organizationID) REFERENCES Organizations(organizationID),
    CONSTRAINT PK_SuperOrganization PRIMARY KEY (superID, organizationID)
);



