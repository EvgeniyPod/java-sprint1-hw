public class Converter {

    /** Метод определения пройденого растояния за месяц в КМ */
    int convertToKm(int sumSteps) {

        int distans = sumSteps * 75 / 100000;
        return distans;
    }

    /** Метод определения сожженого количества калорий за месяц */
    int convertStepsToKilocalories(int sumSteps) {
        int kilocalories =  sumSteps * 50 / 1000;
        return kilocalories;
    }

}
