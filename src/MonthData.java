/**
 * Класс хранения данных конкретного месяца и логика по подсчёту статистики.
 */
class MonthData {
    int[] days = new int[30];

    /** Метод вывода переменных одного месяца по дням */
    void printDaysAndStepsFromMonth() {

        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " день: " + days[i]);
        }
    }

    /** Метод подсчёта общего числа шагов за один месяц */
    public int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps = sumSteps + days[i];
        }
        return sumSteps;
    }

    /** Метод определения наибольшего количества шагов за один день в месяце */
    int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (maxSteps < days[i]) {
                maxSteps = days[i];
            }
        }
        return maxSteps;
    }

    /** Метод определения лучшей серии по выполнению цели подряд идущих дней */
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
        return maxSeriesDays;
    }

    /** Метод определения среднего количества шагов пройденных за месяц */
    int midleStepsMonth() {
        int midleSteps = sumStepsFromMonth() / 30;
        return midleSteps;
    }

}