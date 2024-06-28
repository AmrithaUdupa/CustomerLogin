CREATE database CustomerLogin;
use CustomerLogin;
SELECT * FROM customer;
ALTER TABLE Customer AUTO_INCREMENT = 1;
DELETE FROM customer WHERE id=52;
ALTER TABLE customer ADD UNIQUE (password);
