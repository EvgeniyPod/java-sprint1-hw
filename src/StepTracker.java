
import java.util.Scanner;

/**
 * Класс ввода пользователем переменных (шагов за конкретный день, новая цель шагов), вывод статистики
 */
class StepTracker {
    
    MonthData[] monthToData = new MonthData[12];
    Converter converter = new Converter();
    Scanner scanner;
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    /** Ввод пользователем шагов за конкретный день */
    void addNewNumberStepsPerDay() {

        System.out.println("Введите номер месяца:");
        int month = scanner.nextInt();
        if (month <= 0 || month > 12) {
            System.out.println("В году 12 месяцев, заданное вами число не соответсвуют.");
            return;
        }


        System.out.println("Введите номер дня:");
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("В месяце 30 дней, заданное вами число не соответсвует.");
            return;
        }

        System.out.println("Введите количество шагов:");
        int steps = scanner.nextInt();
        if (steps < 0) {
            System.out.println("Количество шагов может быть исключительно положительным значением.");
            return;
        }

        MonthData monthData = monthToData[month-1];

        monthData.days[day-1] = steps;

    }

    /** Ввод пользователем новой цели по количеству шагов за день */
    void changeStepGlobal() {
        System.out.println("Введите новую цель по количеству шагов в день:");
        while (true) {
            int stepsTarget = scanner.nextInt();
            if (stepsTarget > 0) {
                goalByStepsPerDay = stepsTarget;
                System.out.println("Новая цель " + goalByStepsPerDay + " шагов в день.");
                break;
            } else {
                System.out.println("Введите положительное число.");
            }
        }

    }

    /** Вывод статистики за конкретный месяц */
    void printStatistic() {
        System.out.println("Введите номер месяца:");
        int month = scanner.nextInt();
        if (month <= 0 || month > 12) {
            System.out.println("В году 12 месяцев, заданное вами число не соответсвуют.");
            return;
        }

        MonthData monthData = monthToData[month-1];
        int stepsPerMonth = monthData.sumStepsFromMonth();
        int maxSteps = monthData.maxSteps();
        int midleSteps = monthData.midleStepsMonth();
        int distans = converter.convertToKm(monthData.sumStepsFromMonth());
        int kilocalories = converter.convertStepsToKilocalories(monthData.sumStepsFromMonth());
        int maxSeriesDays = monthData.bestSeries(goalByStepsPerDay);

        monthData.printDaysAndStepsFromMonth();
        System.out.println("Количество шагов за месяц: " + stepsPerMonth);
        System.out.println("Максимальное количество шагов за день: " + maxSteps);
        System.out.println("Среднее количество шагов за месяц: " + midleSteps);
        System.out.println("Пройдено " + distans + " км.");
        System.out.println("Сожжено " + kilocalories + " килокалорий");
        System.out.println("Лучшая серия: " + maxSeriesDays);


    }


}

