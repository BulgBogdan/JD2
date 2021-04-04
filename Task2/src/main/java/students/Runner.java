package students;

import students.factory.StudentFactory;
import students.factory.TypeStudent;

public class Runner {

    public static void main(String[] args) {
        int countStudents = 9;
        int time = 198;
        int count = 0;
        double timeForStudy;
        for (int i = 0; i < countStudents; i++) {
            double skillStudent = (int) (1 + Math.random() * 10);
            count++;
            if ((count) % 3 == 0) {
                timeForStudy = StudentFactory.typeStudent(TypeStudent.THREE).timeStudy(skillStudent / 10, time);
                StudentFactory.typeStudent(TypeStudent.THREE).showResult(timeForStudy, skillStudent / 10);
                System.out.println("------------------------------");
            } else if ((count) % 2 == 0) {
                timeForStudy = StudentFactory.typeStudent(TypeStudent.TWO).timeStudy(skillStudent / 10, time);
                StudentFactory.typeStudent(TypeStudent.TWO).showResult(timeForStudy, skillStudent / 10);
                System.out.println("------------------------------");
            } else {
                timeForStudy = StudentFactory.typeStudent(TypeStudent.ONE).timeStudy(skillStudent / 10, time);
                StudentFactory.typeStudent(TypeStudent.ONE).showResult(timeForStudy, skillStudent / 10);
                System.out.println("------------------------------");
            }
        }
    }
}
