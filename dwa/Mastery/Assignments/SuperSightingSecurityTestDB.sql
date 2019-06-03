DROP DATABASE IF EXISTS superSightingSecurityDBTest;
CREATE DATABASE superSightingSecurityDBTest;
USE superSightingSecurityDBTest;

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
    locationName VARCHAR(60) NOT NULL,
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

CREATE TABLE Supers_Organizations(
	superID INT NOT NULL,
    organizationID INT NOT NULL,
    FOREIGN KEY (superID) REFERENCES Supers(superID),
    FOREIGN KEY (organizationID) REFERENCES Organizations(organizationID),
    CONSTRAINT PK_SuperOrganization PRIMARY KEY (superID, organizationID)
);

CREATE TABLE Sightings(
	sightingID INT PRIMARY KEY AUTO_INCREMENT,
    sightingDate DATE NOT NULL,
    superID INT NOT NULL,
    locationID INT NOT NULL,
    FOREIGN KEY (superID) REFERENCES Supers(superID),
    FOREIGN KEY (locationID) REFERENCES Locations(locationID)
);

CREATE TABLE Users(
	userID INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    userPassword VARCHAR(50) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE Roles(
	roleID INT PRIMARY KEY AUTO_INCREMENT,
    userRole VARCHAR(50) NOT NULL
);

CREATE TABLE Users_Roles(
	userID INT NOT NULL,
    roleID INT NOT NULL,
    PRIMARY KEY(userID, roleID),
    FOREIGN KEY (userID) REFERENCES Users(userID),
    FOREIGN KEY (roleID) REFERENCES Roles(roleID)
);

CREATE TABLE Files(
	fileID INT PRIMARY KEY AUTO_INCREMENT,
    fileName VARCHAR(50) NOT NULL,
    superID INT NOT NULL UNIQUE,
    FOREIGN KEY (superID) REFERENCES Supers(superID)
);