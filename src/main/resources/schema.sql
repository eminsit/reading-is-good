

CREATE TABLE EMIN (
                       id LONG AUTO_INCREMENT  PRIMARY KEY,
                       title VARCHAR(250) NOT NULL,
                       author_name VARCHAR(250) NOT NULL,
                       count INTEGER DEFAULT NULL
);


DROP TABLE IF EXISTS BOOKS CASCADE;
DROP TABLE IF EXISTS CUSTOMERS CASCADE;
DROP TABLE IF EXISTS ORDERS CASCADE;
DROP TABLE IF EXISTS ORDER_ITEMS CASCADE;


CREATE TABLE BOOKS (
  id LONG AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  author_name VARCHAR(250) NOT NULL,
  price DECIMAL NOT NULL,
  count INTEGER DEFAULT NULL
);



CREATE TABLE CUSTOMERS (
                         id LONG AUTO_INCREMENT  PRIMARY KEY,
                         name VARCHAR(250) NOT NULL,
                         email VARCHAR(250) NOT NULL
);


CREATE TABLE ORDERS (
                         id LONG AUTO_INCREMENT  PRIMARY KEY,
                         status INTEGER NOT NULL,
                         customer_id LONG NOT NULL,
                         total_amount DOUBLE NOT NULL
);




CREATE TABLE ORDER_ITEMS (
                        id LONG AUTO_INCREMENT  PRIMARY KEY,
                        order_id LONG NOT NULL,
                        book_id LONG NOT NULL,
                        book_count DOUBLE NOT NULL
);

