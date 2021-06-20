DROP SCHEMA IF EXISTS `tomcat_tasks`;

CREATE SCHEMA IF NOT EXISTS `tomcat_tasks` DEFAULT CHARACTER SET utf8;
USE `tomcat_tasks`;

DROP TABLE IF EXISTS `tomcat_tasks`.`teacher`;

CREATE TABLE IF NOT EXISTS `tomcat_tasks`.`teacher`
(
  `id_teacher`   INT         NOT NULL AUTO_INCREMENT,
  `teacher_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_teacher`)
);

DROP TABLE IF EXISTS `tomcat_tasks`.`student`;

CREATE TABLE IF NOT EXISTS `tomcat_tasks`.`student`
(
  `id_student` INT         NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name`  VARCHAR(45) NOT NULL,
  `teacher_id` INT         NOT NULL,
  PRIMARY KEY (`id_student`),
  INDEX `fk_student_teacher_idx` (`teacher_id` ASC) VISIBLE,
  CONSTRAINT `fk_teacher`
    FOREIGN KEY (`teacher_id`)
      REFERENCES `tomcat_tasks`.`teacher` (`id_teacher`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);

DROP TABLE IF EXISTS `tomcat_tasks`.`task`;

CREATE TABLE IF NOT EXISTS `tomcat_tasks`.`task`
(
  `id_task`    INT         NOT NULL AUTO_INCREMENT,
  `task_name`  VARCHAR(45) NOT NULL,
  `student_id` INT         NOT NULL,
  PRIMARY KEY (`id_task`),
  INDEX `fk_task_student1_idx` (`student_id` ASC) VISIBLE,
  CONSTRAINT `fk_student`
    FOREIGN KEY (`student_id`)
      REFERENCES `tomcat_tasks`.`student` (`id_student`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);