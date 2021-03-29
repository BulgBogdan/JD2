package students;

public class SecondTypeStudent implements StudyJava {

    @Override
    public void timeStudy(double talent, int time) {
        double timeForMaterial = (time * 2) / talent;

        System.out.println("Студент 2 типа, с талантом равным " +
                talent + ", время на прохождение всего материала: " +
                timeForMaterial + ".");

        System.out.println("Время на разбор: " +
                (timeForMaterial / 2) + ", на практику: " +
                (timeForMaterial / 2) + ".");
    }
}
