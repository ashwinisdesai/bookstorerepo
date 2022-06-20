DROP TABLE IF EXISTS book;


CREATE TABLE BOOK(
	id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY NOT NULL,
	NAME VARCHAR(50) NOT NULL,
	DESCRIPTION VARCHAR(300) NOT NULL,
	AUTHOR VARCHAR(50) NOT NULL,
	TYPE_OF_BOOK VARCHAR(10) NOT NULL,
	PRICE DECIMAL(20,2) NOT NULL,
	ISBN LONG NOT NULL
);