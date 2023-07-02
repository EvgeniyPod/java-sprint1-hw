import java.util.Scanner;

/**
 * Класс вывода консольного меню и ввода пользователем переменных.
 * @author Евгений Подолский
 * @version 1.2
 */
class  Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            if (command == 1) {
                System.out.println("Выполняется команда 1:");
                stepTracker.addNewNumberStepsPerDay();

            } else if (command == 2) {
                System.out.println("Выполняется команда 2:");
                stepTracker.changeStepGlobal();

            } else if (command == 3) {
                System.out.println("Выполняется команда 3:");
                stepTracker.printStatistic();
                //System.out.println("Количество шагов за месяц: " + stepTracker.stepsPerMonth);

            } else if (command == 0) {
                System.out.println("Досвидания!");
                return;

            } else {
                System.out.println("Извините, такой команды нет.");
            }
        }

    }

    /** Метод вызова консольного меню */
    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день.");
        System.out.println("2 - Изменить цель по количеству шагов в день.");
        System.out.println("3 - Напечатать статистику за определённый месяц.");
        System.out.println("0 - Выйти из приложения.");
    }
}

