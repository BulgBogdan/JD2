CREATE SCHEMA IF NOT EXISTS `People` DEFAULT CHARACTER SET utf8;

CREATE TABLE IF NOT EXISTS `People`.`Person`
(
  `id`            INT          NOT NULL AUTO_INCREMENT,
  `name`          VARCHAR(50)  NULL,
  `sur_name`      VARCHAR(50)  NULL,
  `age`           INT          NULL,
  `salary`        DECIMAL      NULL,
  `passport`      CHAR(10)     NULL,
  `address`       VARCHAR(200) NULL,
  `date_birthday` DATE         NULL,
  `date_time`     DATETIME     NULL,
  `time_lunch`    TIMESTAMP(4) NULL,
  `letter`        MEDIUMTEXT   NULL,
  PRIMARY KEY (`id`)
);

truncate table People.person;