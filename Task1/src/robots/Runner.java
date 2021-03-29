package robots;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Runner{

    public static void main(String[] args) {
        List<String> dumpDetails = Details.getDetails(Details.getFirstCountDetails(20));

        List<String> detailsForFirstProfessor = new ArrayList<>();
        List<String> detailsForSecondProfessor = new ArrayList<>();
        Runner runner = new Runner();

        Thread thread = new Thread(() -> runner.getDumpDetails(dumpDetails));
        Thread threadTwo = new Thread(() -> runner.getDetailsForProfessor(detailsForFirstProfessor, dumpDetails));
        Thread threadThree = new Thread(() -> runner.getDetailsForProfessor(detailsForSecondProfessor, dumpDetails));

        thread.start();
        threadTwo.start();
        threadThree.start();

        try {
            Thread.sleep(10500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Список деталей фабрики
        Map<Integer, String> details = Details.fabrigDetails();
        List<String> listDetails = new ArrayList<>(details.values());

        // Количество деталей для каждого профессора
        List<Integer> countFirstDetails = Details.getCountsEveryoneDetail(detailsForFirstProfessor, listDetails);
        List<Integer> countSecondDetails = Details.getCountsEveryoneDetail(detailsForSecondProfessor, listDetails);

        if (Details.getCountRobots(countFirstDetails) >  Details.getCountRobots(countSecondDetails)){
            System.out.println("Победил 1 профессор (роботов = " +
                    Details.getCountRobots(countFirstDetails) + "), в отличие от 2 профессора (роботов = " +
                    Details.getCountRobots(countSecondDetails) + ")");
        }else if (Details.getCountRobots(countFirstDetails) ==  Details.getCountRobots(countSecondDetails)){
            System.out.println("Победила дружба 2 профессор (роботов = " +
                    Details.getCountRobots(countSecondDetails) + ") и 1 профессора (роботов = " +
                    Details.getCountRobots(countFirstDetails) + ")");
        }else {
            System.out.println("Победил 2 профессор (роботов = " +
                    Details.getCountRobots(countSecondDetails) + "), в отличие от 1 профессора (роботов = " +
                    Details.getCountRobots(countFirstDetails) + ")");
        }

    }

    private void getDumpDetails(List<String> dumpDetails){
        for (int i = 0; i < 100; i++) {
            dumpDetails.addAll(Details.getDetails(Details.getDetailsForNight()));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void getDetailsForProfessor(List<String> detailsForProfessor, List<String> dumpDetails){
        for (int i = 0; i < 100; i++) {
            try {
                Details.addedDetailsProfessor(detailsForProfessor, dumpDetails);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}