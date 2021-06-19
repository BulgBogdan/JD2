package jd.tomcat.repository;

import jd.tomcat.entity.Student;

public interface StudentDAO {

    Student getByID(int id);
}
