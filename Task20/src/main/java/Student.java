import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Comparable<Student> {

    private String firstName;
    private String lastName;
    private Double avgMark;
    private List<String> subjects;
    private Course course;

    @Autowired
    public Student(Course course) {
        this.course = course;
    }

    @Override
    public int compareTo(Student student) {
        return avgMark.compareTo(student.avgMark);
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", avgMark=" + avgMark +
                ", subjects=" + subjects +
                '}';
    }
}
