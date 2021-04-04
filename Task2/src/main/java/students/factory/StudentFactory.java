package students.factory;


import students.FirstTypeStudent;
import students.SecondTypeStudent;
import students.Study;
import students.ThirdTypeStudent;

public class StudentFactory {

    public static Study typeStudent(TypeStudent typeStudent) {
        Study study = null;
        switch (typeStudent) {
            case ONE:
                study = new FirstTypeStudent();
                break;
            case TWO:
                study = new SecondTypeStudent();
                break;
            case THREE:
                study = new ThirdTypeStudent();
                break;
        }
        return study;
    }
}