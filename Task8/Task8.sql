DROP SCHEMA IF EXISTS `academy_test`;
CREATE SCHEMA IF NOT EXISTS `academy_test` DEFAULT CHARACTER SET utf8;
USE `academy_test`;

DROP TABLE IF EXISTS `academy_test`.`customers`;
CREATE TABLE IF NOT EXISTS `academy_test`.`customers`
(
  `id`       INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`     VARCHAR(50) NOT NULL,
  `email`    VARCHAR(50) NULL,
  `birthday` DATE        NULL
);

INSERT INTO `academy_test`.`customers` (name, email, birthday) VALUE ('ivan', 'ivan@mail.com', '2000-01-01');
INSERT INTO `academy_test`.`customers` (name, email, birthday) VALUE ('ivan2', 'ivan@mail.com', '2001-01-01');
INSERT INTO `academy_test`.`customers` (name, email, birthday) VALUE ('stepan', 'stepan@mail.com', '2001-02-02');
INSERT INTO `academy_test`.`customers` (name, email, birthday) VALUE ('alex', 'alex@mail.com', '2002-03-03');

-- Task 18
SELECT *
FROM customers
where id % 2 != 0;

-- Task 19
SELECT email, count(email)
from customers
GROUP BY email
HAVING COUNT(email) > 1;

-- Task 20
SELECT DATE_ADD(birthday, interval 1 DAY)
FROM customers
WHERE id % 2 = 0;

-- Task 21
DROP TABLE IF EXISTS `academy_test`.`users`;
CREATE TABLE IF NOT EXISTS `academy_test`.`users`
(
  `id`      INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name`    VARCHAR(50) NOT NULL,
  `surname` VARCHAR(50) NULL
);
INSERT INTO `academy_test`.`users` (name, surname) VALUE ('ivan', 'ivanov');
INSERT INTO `academy_test`.`users` (name, surname) VALUE ('ivan', 'ivanov');
INSERT INTO `academy_test`.`users` (name, surname) VALUE ('alex', 'alexandrov');
INSERT INTO `academy_test`.`users` (name, surname) VALUE ('stepan', 'stepanov');
SELECT DISTINCT name
FROM users;

-- Task 22
DROP TABLE IF EXISTS `academy_test`.`workers`;
CREATE TABLE IF NOT EXISTS `academy_test`.`workers`
(
  `id`       INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `position` VARCHAR(50) NOT NULL,
  `salary`   INT         NOT NULL
);
INSERT INTO `academy_test`.`workers` (position, salary) VALUE ('director', '1000');
INSERT INTO `academy_test`.`workers` (position, salary) VALUE ('engineer', '800');
INSERT INTO `academy_test`.`workers` (position, salary) VALUE ('worker', '400');
INSERT INTO `academy_test`.`workers` (position, salary) VALUE ('worker', '400');
SELECT AVG(salary)
FROM workers;

-- Task 23
SELECT *
FROM workers
WHERE salary > (SELECT AVG(salary) FROM workers);

-- Task 24
DROP TABLE IF EXISTS `academy_test`.`departments`;
CREATE TABLE IF NOT EXISTS `academy_test`.`departments`
(
  `id`              INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `name_department` VARCHAR(50) NOT NULL
);
DROP TABLE IF EXISTS `academy_test`.`workers`;
CREATE TABLE IF NOT EXISTS `academy_test`.`workers`
(
  `id`             INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `position`       VARCHAR(50) NOT NULL,
  `salary`         INT         NOT NULL,
  `id_departments` INT         NOT NULL,
  CONSTRAINT workers_departments
    FOREIGN KEY (id_departments) REFERENCES departments (id)
);
INSERT INTO `academy_test`.`departments` (name_department) VALUE ('lead');
INSERT INTO `academy_test`.`departments` (name_department) VALUE ('personal');
INSERT INTO `academy_test`.`departments` (name_department) VALUE ('sell');
INSERT INTO `academy_test`.`workers` (position, salary, id_departments) VALUE ('director', '1000', 1);
INSERT INTO `academy_test`.`workers` (position, salary, id_departments) VALUE ('engineer', '800', 1);
INSERT INTO `academy_test`.`workers` (position, salary, id_departments) VALUE ('worker', '400', 2);
INSERT INTO `academy_test`.`workers` (position, salary, id_departments) VALUE ('worker', '400', 2);
SELECT name_department
FROM workers w
       RIGHT JOIN departments d ON (w.id_departments = d.id)
WHERE w.id_departments IS NULL;

-- Task 25
UPDATE workers w
SET w.salary = CASE WHEN w.salary = 400 THEN 1000 WHEN w.salary = 800 THEN 1500 ELSE 2000 END;

-- Task 26
SELECT CONCAT(position, salary) AS pos_salary
FROM academy_test.workers;

-- Task 27
ALTER TABLE users RENAME users_correct;
