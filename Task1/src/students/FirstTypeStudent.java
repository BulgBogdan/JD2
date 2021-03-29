package students;

public class FirstTypeStudent implements StudyJava {

    @Override
    public void timeStudy(double talent, int time) {
        double timeForMaterial = time / talent;

        System.out.println("Студент 1 типа, с талантом равным " +
                talent + ", время на прохождение всего материала: " +
                timeForMaterial + ".");

        System.out.println("Время на разбор: " +
                (timeForMaterial / 3) + ", на практику: " +
                (timeForMaterial / 3) + ", на поток: " +
                (timeForMaterial / 3) + ".");

    }
}
