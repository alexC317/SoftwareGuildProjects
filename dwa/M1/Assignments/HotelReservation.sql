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

CREATE TABLE AddOns(
	AddOnID INT PRIMARY KEY AUTO_INCREMENT,
    AddOnName VARCHAR(50),
    AddOnFee DECIMAL(8,2),
    StartDate DATE NOT NULL,
    EndDate DATE NOT NULL
);

CREATE TABLE PromotionalCodes(
	PromotionalID INT PRIMARY KEY AUTO_INCREMENT,
    StartDate DATE,
    EndDate DATE,
    Percent INT,
    DollarAmt INT,
    ReservationID INT NOT NULL,
    FOREIGN KEY (ReservationID) REFERENCES Reservations(ReservationID)
);

CREATE TABLE Customers(
	CustomerID INT PRIMARY KEY AUTO_INCREMENT,
    CustomerName VARCHAR(50) NOT NULL,
    CustomerPhone VARCHAR(10) NOT NULL,
    CustomerEmail VARCHAR(50) NOT NULL,
    CustomerAge INT NOT NULL,
    ReservationID INT NOT NULL,
    FOREIGN KEY (ReservationID) REFERENCES Reservations(ReservationID)
);

CREATE TABLE Billing(
	BillingID INT PRIMARY KEY AUTO_INCREMENT,
    Subtotal DECIMAL(8,2),
    Tax DECIMAL(8,2),
    Total DECIMAL(8,2),
    ReservationID INT NOT NULL,
    FOREIGN KEY (ReservationID) REFERENCES Reservations(ReservationID)
);

CREATE TABLE BillingDetails(
	BillingDetailsID INT PRIMARY KEY AUTO_INCREMENT,
    `Description` VARCHAR(50) NOT NULL,
    Amount DECIMAL(8,2) NOT NULL,
    BillingID INT NOT NULL,
    FOREIGN KEY (BillingID) REFERENCES Billing(BillingID)
);