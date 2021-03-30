package robots;

import java.util.*;

class Details {

    // Добавление деталей ученным и удаление из списка фабрики
    static void addedDetailsProfessor(List<String> detailsProfessor, List<String> dumpDetails) {
        int[] numbersDetailsForNight = getNumbersDetailsForNight(
                getNumbersDetails(getDetailsForNight().length, dumpDetails.size()));
        for (int j = numbersDetailsForNight.length - 1; j >= 0; j--) {
            if (numbersDetailsForNight.length >= dumpDetails.size()) {
                break;
            }
            detailsProfessor.add(dumpDetails.get(numbersDetailsForNight[j]));
            dumpDetails.remove(numbersDetailsForNight[j]);
        }
    }

    // Подсчет деталей для каждой позиции
    static List<Integer> getCountsEveryoneDetail(List<String> haveDetails, List<String> needDetails) {
        List<Integer> countsDetail = new ArrayList<>();
        for (String detail : needDetails) {
            int count = 0;
            for (String first : haveDetails) {
                if (first.equals(detail)) {
                    count++;
                }
            }
            countsDetail.add(count);
        }
        return countsDetail;
    }

    // Находим минимальное значение в списке деталей, чтобы получить макс. возможное кол-во роботов
    static int getCountRobots(List<Integer> countsDetail) {
        int minCountDetails = countsDetail.get(0);
        for (Integer min : countsDetail) {
            if (min <= minCountDetails) {
                minCountDetails = min;
            }
        }
        return minCountDetails;
    }

    // Список необходимых деталей для роботов
    static Map<Integer, String> fabrigDetails() {
        Map<Integer, String> details = new TreeMap<>();
        details.put(1, "Голова");
        details.put(2, "Тело");
        details.put(3, "Левая рука");
        details.put(4, "Правая рука");
        details.put(5, "Левая нога");
        details.put(6, "Правая нога");
        details.put(7, "CPU");
        details.put(8, "RAM");
        details.put(9, "HDD");
        return details;
    }

    // Рандомные детали фабрики
    static int[] getDetailsForNight() {
        int countDetails = (int) (1 + Math.random() * 4);
        return getFirstCountDetails(countDetails);
    }

    // Рандомные детали фабрики для начального мусора
    static int[] getFirstCountDetails(int countDetails) {
        int[] numbersDetails = new int[countDetails];
        for (int i = 0; i < countDetails; i++) {
            int numberDetail = (int) (1 + Math.random() * 9);
            numbersDetails[i] = numberDetail;
        }
        return numbersDetails;
    }

    // Получение рандомных деталей для мусора
    static List<String> getDetails(int[] numbersDetails) {
        Map<Integer, String> details = fabrigDetails();
        List<String> listDetails = new ArrayList<>();
        for (int detail : numbersDetails) {
            listDetails.add(details.get(detail));
        }
        return listDetails;
    }


    // Кол-во деталей за ночь
    private static int[] getNumbersDetailsForNight(Set<Integer> numbersDetail) {
        int[] detailNumbers = numbersDetail.stream().mapToInt(Number::intValue).toArray();
        Arrays.sort(detailNumbers);
        return detailNumbers;
    }

    // Номера деталей из списка мусора
    private static Set<Integer> getNumbersDetails(int countDetails, int listLength) {
        Set<Integer> numbersDetails = new HashSet<>();
        for (int i = 0; i < listLength; i++) {
            int numberDetail = (int) (Math.random() * listLength / 2);
            numbersDetails.add(numberDetail);
            if (numbersDetails.size() == countDetails) {
                break;
            }
        }
        return numbersDetails;
    }
}
