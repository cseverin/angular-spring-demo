CREATE TABLE IF NOT EXISTS BOOK (
   ID INT NOT NULL,
   TITLE VARCHAR(100) NOT NULL,
   AUTHOR INT NOT NULL,
   PRIMARY KEY (id) 
);

CREATE TABLE IF NOT EXISTS AUTHOR (
   ID INT NOT NULL,
   PRENAME VARCHAR(100) NOT NULL,
   SURNAME VARCHAR(100) NOT NULL,
   PRIMARY KEY (id) 
);