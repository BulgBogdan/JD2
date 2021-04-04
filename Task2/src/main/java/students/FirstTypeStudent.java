package students;

public class FirstTypeStudent implements Study {

    @Override
    public double timeStudy(double talent, int time) {
        return time / talent;
    }

    @Override
    public void showResult(double timeForMaterial, double talent) {
        System.out.println("Студент 1 типа, с талантом равным " +
                talent + ", время на прохождение всего материала: " +
                timeForMaterial + ".");

        System.out.println("Время на разбор: " +
                (timeForMaterial / 3) + ", на практику: " +
                (timeForMaterial / 3) + ", на поток: " +
                (timeForMaterial / 3) + ".");
    }
}