-- db_ltjava ----
-- DROP TABLE db_ltjava.authorISBN;
-- DROP TABLE db_ltjava.titles;
-- DROP TABLE db_ltjava.authors;

CREATE TABLE db_ltjava.authors (
    authorID INT NOT NULL AUTO_INCREMENT,
    firstName varchar (20) NOT NULL,
    lastName varchar (30) NOT NULL,
    PRIMARY KEY (authorID)
);

CREATE TABLE db_ltjava.titles (
    isbn varchar (20) NOT NULL,
    title varchar (100) NOT NULL,
    editionNumber INT NOT NULL,
    copyright varchar (4) NOT NULL,
    PRIMARY KEY (isbn)
);

CREATE TABLE db_ltjava.authorISBN (
    authorID INT NOT NULL,
    isbn varchar (20) NOT NULL,
    FOREIGN KEY (authorID) REFERENCES db_ltjava.authors (authorID),
    FOREIGN KEY (isbn) REFERENCES db_ltjava.titles (isbn)
);