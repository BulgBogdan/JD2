package students;

public class SecondTypeStudent implements Study {

    @Override
    public double timeStudy(double talent, int time) {
        return (time * 2) / talent;
    }

    @Override
    public void showResult(double timeForMaterial, double talent) {
        System.out.println("Студент 2 типа, с талантом равным " +
                talent + ", время на прохождение всего материала: " +
                timeForMaterial + ".");

        System.out.println("Время на разбор: " +
                (timeForMaterial / 2) + ", на практику: " +
                (timeForMaterial / 2) + ".");
    }
}
