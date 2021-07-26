import lombok.Data;

import java.util.List;

@Data
public class Student implements Comparable<Student> {

    private String firstName;
    private String lastName;
    private Double avgMark;
    private List<String> subjects;

    @Override
    public int compareTo(Student student) {
        return avgMark.compareTo(student.avgMark);
    }
}
