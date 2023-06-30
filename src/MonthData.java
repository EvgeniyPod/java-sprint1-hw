// данные конкретного месяца и логика по подсчёту статистики
class MonthData {
    int[] days = new int[30];
    void printDaysAndStepsFromMonth() {

        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " день: " + days[i]);
        }
    }

    public int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps = sumSteps + days[i];
        }
        return sumSteps;
    }

    int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (maxSteps < days[i]) {
                maxSteps = days[i];
            }
        }
        System.out.println("Максимальное количество шагов за день: " + maxSteps);
        return maxSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int maxSeriesDays = 0;
        int currentSeries = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] < goalByStepsPerDay) {
                currentSeries = 0;
            } else {
                currentSeries++;
            }
            if (currentSeries > maxSeriesDays) {
                maxSeriesDays = currentSeries;
            }
        }
        System.out.println("Лучшая серия: " + maxSeriesDays);
        return maxSeriesDays;
    }

    int midleStepsMonth() {
        int midleSteps = sumStepsFromMonth() / 30;
        System.out.println("Среднее количество шагов за месяц: " + midleSteps);
        return midleSteps;
    }

}