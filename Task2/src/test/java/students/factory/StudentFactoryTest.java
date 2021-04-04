package students.factory;

import org.junit.Test;
import students.FirstTypeStudent;
import students.SecondTypeStudent;
import students.ThirdTypeStudent;

import static org.junit.Assert.assertTrue;

public class StudentFactoryTest {

    @Test
    public void firstTypeStudent() {
        assertTrue(StudentFactory.typeStudent(TypeStudent.ONE) instanceof FirstTypeStudent);
    }

    @Test
    public void secondTypeStudent() {
        assertTrue(StudentFactory.typeStudent(TypeStudent.TWO) instanceof SecondTypeStudent);
    }

    @Test
    public void thirdTypeStudent() {
        assertTrue(StudentFactory.typeStudent(TypeStudent.THREE) instanceof ThirdTypeStudent);
    }
}