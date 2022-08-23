DROP DATABASE IF EXISTS TestLibraryDB;
CREATE DATABASE TestLibraryDB;
USE TestLibraryDB;
SET foreign_key_checks = 0;

CREATE TABLE Book(
	id INT(5) NOT NULL AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    author VARCHAR(50) NOT NULL,
    price FLOAT(10, 2) NOT NULL,
    publicationDate DATE NOT NULL,
    _description VARCHAR(100),
	PRIMARY KEY(id)
);

CREATE TABLE Member(
	id INT(5) NOT NULL AUTO_INCREMENT,
    _name VARCHAR(50) NOT NULL,
    birthDate DATE NOT NULL,
    registrationDate DATE NOT NULL,
    bio VARCHAR(100),
	PRIMARY KEY(id)
);

CREATE TABLE Ownership(
	bookId INT(5) NOT NULL,
    memberId INT(5) NOT NULL,
    acquirementDate DATE NOT NULL,
	PRIMARY KEY(bookId, memberId),
    FOREIGN KEY(bookId)
        REFERENCES Book(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    FOREIGN KEY(memberId)
        REFERENCES Member(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

SET foreign_key_checks = 1;