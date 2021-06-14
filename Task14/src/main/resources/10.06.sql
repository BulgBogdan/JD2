DROP SCHEMA IF EXISTS `StudyCentre`;
CREATE SCHEMA IF NOT EXISTS `StudyCentre` DEFAULT CHARACTER SET utf8;

DROP TABLE IF EXISTS `StudyCentre`.`Administrator`;
CREATE TABLE IF NOT EXISTS `StudyCentre`.`Administrator`
(
  `admin_id`   INT         NOT NULL AUTO_INCREMENT,
  `admin_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`admin_id`)
);

DROP TABLE IF EXISTS `StudyCentre`.`Course`;
CREATE TABLE IF NOT EXISTS `StudyCentre`.`Course`
(
  `course_id`   INT         NOT NULL AUTO_INCREMENT,
  `course_name` VARCHAR(30) NOT NULL,
  `admin_id`    INT         NOT NULL,
  PRIMARY KEY (`course_id`),
  INDEX `fk_Course_Administrator_idx` (`admin_id` ASC) VISIBLE,
  CONSTRAINT `Course_Administrator`
    FOREIGN KEY (`admin_id`)
      REFERENCES `StudyCentre`.`Administrator` (`admin_id`)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);


DROP TABLE IF EXISTS `StudyCentre`.`Student`;
CREATE TABLE IF NOT EXISTS `StudyCentre`.`Student`
(
  `student_id` INT         NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name`  VARCHAR(45) NOT NULL,
  PRIMARY KEY (`student_id`)
);


DROP TABLE IF EXISTS `StudyCentre`.`Teacher`;
CREATE TABLE IF NOT EXISTS `StudyCentre`.`Teacher`
(
  `teacher_id`   INT         NOT NULL AUTO_INCREMENT,
  `teacher_name` VARCHAR(45) NOT NULL,
  `admin_id`     INT         NOT NULL,
  PRIMARY KEY (`teacher_id`),
  INDEX `fk_Teacher_Administrator1_idx` (`admin_id` ASC) VISIBLE,
  CONSTRAINT `Teacher_Administrator`
    FOREIGN KEY (`admin_id`)
      REFERENCES `StudyCentre`.`Administrator` (`admin_id`)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);


DROP TABLE IF EXISTS `StudyCentre`.`Task`;
CREATE TABLE IF NOT EXISTS `StudyCentre`.`Task`
(
  `task_id`    INT         NOT NULL AUTO_INCREMENT,
  `task_name`  VARCHAR(45) NOT NULL,
  `course_id`  INT         NOT NULL,
  `student_id` INT         NOT NULL,
  PRIMARY KEY (`task_id`),
  INDEX `fk_Task_Course1_idx` (`course_id` ASC) VISIBLE,
  INDEX `fk_Task_Student1_idx` (`student_id` ASC) VISIBLE,
  CONSTRAINT `Task_Course`
    FOREIGN KEY (`course_id`)
      REFERENCES `StudyCentre`.`Course` (`course_id`)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  CONSTRAINT `Task_Student`
    FOREIGN KEY (`student_id`)
      REFERENCES `StudyCentre`.`Student` (`student_id`)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);


DROP TABLE IF EXISTS `StudyCentre`.`Result`;
CREATE TABLE IF NOT EXISTS `StudyCentre`.`Result`
(
  `result_id`  INT          NOT NULL AUTO_INCREMENT,
  `mark`       INT          NOT NULL,
  `review`     VARCHAR(100) NOT NULL,
  `student_id` INT          NOT NULL,
  `teacher_id` INT          NOT NULL,
  `task_id`    INT          NOT NULL,
  PRIMARY KEY (`result_id`),
  INDEX `fk_Result_Student1_idx` (`student_id` ASC) VISIBLE,
  INDEX `fk_Result_Teacher1_idx` (`teacher_id` ASC) VISIBLE,
  INDEX `fk_Result_Task1_idx` (`task_id` ASC) VISIBLE,
  CONSTRAINT `Result_Student`
    FOREIGN KEY (`student_id`)
      REFERENCES `StudyCentre`.`Student` (`student_id`)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  CONSTRAINT `Result_Teacher`
    FOREIGN KEY (`teacher_id`)
      REFERENCES `StudyCentre`.`Teacher` (`teacher_id`)
      ON DELETE CASCADE
      ON UPDATE CASCADE,
  CONSTRAINT `Result_Task`
    FOREIGN KEY (`task_id`)
      REFERENCES `StudyCentre`.`Task` (`task_id`)
      ON DELETE CASCADE
      ON UPDATE CASCADE
);


DROP TABLE IF EXISTS `StudyCentre`.`Course_Student`;
CREATE TABLE IF NOT EXISTS `StudyCentre`.`Course_Student`
(
  `course_id`  INT NOT NULL,
  `student_id` INT NOT NULL,
  PRIMARY KEY (`course_id`, `student_id`),
  INDEX `fk_Course_has_Student_Student1_idx` (`student_id` ASC) VISIBLE,
  INDEX `fk_Course_has_Student_Course1_idx` (`course_id` ASC) VISIBLE,
  CONSTRAINT `fk_Course_has_Student_Course1`
    FOREIGN KEY (`course_id`)
      REFERENCES `StudyCentre`.`Course` (`course_id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  CONSTRAINT `fk_Course_has_Student_Student1`
    FOREIGN KEY (`student_id`)
      REFERENCES `StudyCentre`.`Student` (`student_id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);


DROP TABLE IF EXISTS `StudyCentre`.`Teacher_Course`;
CREATE TABLE IF NOT EXISTS `StudyCentre`.`Teacher_Course`
(
  `teacher_id` INT NOT NULL,
  `course_id`  INT NOT NULL,
  PRIMARY KEY (`teacher_id`, `course_id`),
  INDEX `fk_Teacher_has_Course_Course1_idx` (`course_id` ASC) VISIBLE,
  INDEX `fk_Teacher_has_Course_Teacher1_idx` (`teacher_id` ASC) VISIBLE,
  CONSTRAINT `fk_Teacher_has_Course_Teacher1`
    FOREIGN KEY (`teacher_id`)
      REFERENCES `StudyCentre`.`Teacher` (`teacher_id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  CONSTRAINT `fk_Teacher_has_Course_Course1`
    FOREIGN KEY (`course_id`)
      REFERENCES `StudyCentre`.`Course` (`course_id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION
);