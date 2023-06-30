
import java.util.Scanner;
class StepTracker {

    MonthData monthData = new MonthData();
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

    void printStatistic() {
        System.out.println("Введите номер месяца:");
        int month = scanner.nextInt();
        if (month <= 0 || month > 12) {
            System.out.println("В году 12 месяцев, заданное вами число не соответсвуют.");
            return;
        }
        MonthData monthData = monthToData[month-1];
        monthData.printDaysAndStepsFromMonth();
        System.out.println("Количество шагов за месяц: " + monthData.sumStepsFromMonth());
        monthData.maxSteps();
        monthData.midleStepsMonth();
        converter.convertToKm(monthData.sumStepsFromMonth());
        converter.convertStepsToKilocalories(monthData.sumStepsFromMonth());
        monthData.bestSeries(goalByStepsPerDay);

    }


}

