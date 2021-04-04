package students;

import org.junit.Test;
import students.factory.StudentFactory;
import students.factory.TypeStudent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ThirdTypeStudentTest {

    Study study = StudentFactory.typeStudent(TypeStudent.THREE);

    @Test
    public void timeStudy() {
        assertEquals(22, study.timeStudy(3, 22), 0.0);
    }

    @Test
    public void showResult() {
        assertTrue(study instanceof ThirdTypeStudent);
    }
}