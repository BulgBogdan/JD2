package students;

public class Runner {
    public static void main(String[] args) {
        Student student = new Student();
        int countStudents = 9;
        int time = 198;
        int count = 0;
        for (int i = 0; i < countStudents; i++) {
            double skillStudent = (int) (1 + Math.random() * 10);
            count++;
            if ((count) % 3 == 0) {
                student.setStudyJava(new ThirdTypeStudent());
                student.doIt(skillStudent / 10, time);
                System.out.println("------------------------------");
            } else if ((count) % 2 == 0) {
                student.setStudyJava(new SecondTypeStudent());
                student.doIt(skillStudent / 10, time);
                System.out.println("------------------------------");
            } else {
                student.setStudyJava(new FirstTypeStudent());
                student.doIt(skillStudent / 10, time);
                System.out.println("------------------------------");
            }
        }
    }
}
