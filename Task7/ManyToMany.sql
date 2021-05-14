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

DROP TABLE IF EXISTS `People`.`person_address`;
CREATE TABLE IF NOT EXISTS `People`.`person_address`
(
  `id`         INT NOT NULL AUTO_INCREMENT,
  `person_id`  INT NOT NULL,
  `address_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_person_address_idx` (`address_id` ASC) VISIBLE,
  INDEX `fk_address_person_idx` (`person_id` ASC) VISIBLE,
  CONSTRAINT `fk_person_address`
    FOREIGN KEY (`person_id`)
      REFERENCES `People`.`person` (`id`)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  CONSTRAINT `fk_address_person`
    FOREIGN KEY (`address_id`)
      REFERENCES `People`.`address` (`id`)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);