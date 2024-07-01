CREATE database CustomerLogin;
use CustomerLogin;
SELECT * FROM customer;
ALTER TABLE Customer AUTO_INCREMENT = 1;
DELETE FROM customer WHERE id=152;
ALTER TABLE customer ADD UNIQUE (password);
ALTER TABLE customer DROP COLUMN role_id;

ALTER TABLE customer DROP FOREIGN KEY FKo2oh87rk6lunf0lic1svc9y75;

ALTER TABLE customer ADD COLUMN role varchar(30) NOT NULL;
