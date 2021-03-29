package students;

public class ThirdTypeStudent implements StudyJava {

    @Override
    public void timeStudy(double talent, int time) {
        double timeForMaterial = (time * 3) / talent;
        System.out.println("Студент 3 типа, с талантом: " + talent
                + ", время на прохождение всего материала: " + timeForMaterial + ".");
        System.out.println("Время на практику: " + timeForMaterial + ".");
    }
}