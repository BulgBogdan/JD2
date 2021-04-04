package students;

import org.junit.Test;
import students.factory.StudentFactory;
import students.factory.TypeStudent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FirstTypeStudentTest {

    Study study = StudentFactory.typeStudent(TypeStudent.ONE);

    @Test
    public void timeStudy() {
        assertEquals(22, study.timeStudy(0.5, 11), 0.0);
    }

    @Test
    public void showResult() {
        assertTrue(study instanceof FirstTypeStudent);
    }
}