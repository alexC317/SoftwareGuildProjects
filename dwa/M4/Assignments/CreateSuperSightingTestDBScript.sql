DROP DATABASE IF EXISTS superSightingDBTest;
CREATE DATABASE superSightingDBTest;
USE superSightingDBTest;

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
    locationDescription VARCHAR(60) NOT NULL,
    locationAddress VARCHAR(60) NOT NULL,
    locationLongitude VARCHAR(50), 
    locationLatitude VARCHAR(50)
);

CREATE TABLE Organizations(
	organizationID INT PRIMARY KEY AUTO_INCREMENT, 
    organizationName VARCHAR(50) NOT NULL,
    organizatinDescription VARCHAR(50) NOT NULL,
    organizationAddress VARCHAR(50) NOT NULL,
    organizationContact VARCHAR(50) NOT NULL
);

CREATE TABLE Superpowers(
	superID INT NOT NULL,
    powerID INT NOT NULL,
    FOREIGN KEY (superID) REFERENCES Supers(superID),
    FOREIGN KEY (powerID) REFERENCES Powers(powerID),
    CONSTRAINT PK_Superpower PRIMARY KEY (superID, powerID)
);

CREATE TABLE Sightings(
	sightingID INT PRIMARY KEY AUTO_INCREMENT,
    sightingDate DATE NOT NULL,
    superID INT NOT NULL,
    locationID INT NOT NULL,
    FOREIGN KEY (superID) REFERENCES Supers(superID),
    FOREIGN KEY (locationID) REFERENCES Locations(locationID)
);

CREATE TABLE Supers_Organzations(
	superID INT NOT NULL,
    organzationID INT NOT NULL,
    FOREIGN KEY (superID) REFERENCES Supers(superID),
    FOREIGN KEY (organzationID) REFERENCES Organizations(organizationID),
    CONSTRAINT PK_SuperOrganization PRIMARY KEY (superID, organzationID)
);



