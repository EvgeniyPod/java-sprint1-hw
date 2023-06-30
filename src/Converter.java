import java.util.Scanner;

public class Converter {
    int convertToKm(int sumSteps) {

        int distans = sumSteps * 75 / 100000;
        System.out.println("Пройдено " + distans + " км.");
        return distans;
    }

    int convertStepsToKilocalories(int sumSteps) {
        int kilocalories =  sumSteps * 50 / 1000;
        System.out.println("Сожжено " + kilocalories + " килокалорий");
        return kilocalories;
    }

}
