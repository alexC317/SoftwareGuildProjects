DROP DATABASE IF EXISTS HotelReservation;

CREATE DATABASE HotelReservation;

USE HotelReservation;

CREATE TABLE RoomTypes(
	RoomTypeID INT PRIMARY KEY AUTO_INCREMENT,
    RoomType VARCHAR(50) NOT NULL
);

CREATE TABLE Amenities(
	AmenityID INT PRIMARY KEY AUTO_INCREMENT,
    AmenityName VARCHAR(50) NOT NULL
);

CREATE TABLE Reservations(
	ReservationID INT PRIMARY KEY AUTO_INCREMENT,
    CheckInDate DATE NOT NULL,
    CheckOutDate DATE NOT NULL
);

CREATE TABLE RoomRates(
	RoomRateID INT PRIMARY KEY AUTO_INCREMENT,
    RoomRate DECIMAL(8,2) NOT NULL,
    StartDate DATE NOT NULL,
    EndDate DATE NOT NULL,
    PeakSeason BIT NOT NULL DEFAULT 0,
    ShortTermEvent BIT NOT NULL DEFAULT 1,
    RoomTypeID INT NOT NULL,
    FOREIGN KEY (RoomTypeID) REFERENCES RoomTypes(RoomTypeID)
);

CREATE TABLE Rooms(
	RoomID INT PRIMARY KEY AUTO_INCREMENT,
    RoomNumber INT NOT NULL,
    RoomFloor INT NOT NULL,
    OccupancyLimit INT NOT NULL,
    RoomTypeID INT NOT NULL,
    ReservationID INT,
    FOREIGN KEY (RoomTypeID) REFERENCES RoomTypes(RoomTypeID),
    FOREIGN KEY (ReservationID) REFERENCES Reservations(ReservationID)
);

CREATE TABLE RoomAmenities(
	RoomID INT NOT NULL,
    AmenityID INT NOT NULL,
    CONSTRAINT PK_RoomAmenities PRIMARY KEY (RoomID, AmenityID),
    FOREIGN KEY (RoomID) REFERENCES Rooms(RoomID),
    FOREIGN KEY (AmenityID) REFERENCES Amenities(AmenityID)
);

