package students;

public class ThirdTypeStudent implements Study {

    @Override
    public double timeStudy(double talent, int time) {
        return (time * 3) / talent;
    }

    @Override
    public void showResult(double timeForMaterial, double talent) {
        System.out.println("Студент 3 типа, с талантом: " + talent
                + ", время на прохождение всего материала: " + timeForMaterial + ".");
        System.out.println("Время на практику: " + timeForMaterial + ".");
    }
}