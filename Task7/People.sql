DROP SCHEMA IF EXISTS `People`;
CREATE SCHEMA IF NOT EXISTS `People` DEFAULT CHARACTER SET utf8;
DROP TABLE IF EXISTS `People`.`Person`;
CREATE TABLE IF NOT EXISTS `People`.`Person`
(
  `id`       INT         NOT NULL AUTO_INCREMENT,
  `name`     VARCHAR(50) NULL,
  `sur_name` VARCHAR(50) NULL,
  `age`      INT         NULL,
  PRIMARY KEY (`id`)
);
DROP TABLE IF EXISTS `People`.`Address`;
CREATE TABLE IF NOT EXISTS `People`.`Address`
(
  `id`     INT         NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(50) NULL,
  `house`  INT         NULL,
  PRIMARY KEY (`id`)
);

truncate table People.Person;
truncate table People.Address;