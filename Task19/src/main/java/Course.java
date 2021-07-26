import lombok.Data;

import java.util.List;

@Data
public class Course {
    private String nameCourse;
    private List<Student> students;
}