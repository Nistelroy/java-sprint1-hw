import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
                                                     // Доброго времени суток! Приятно познакомиться  :)
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {

            printMenu();

            int userInput = scanner.nextInt();
            if (userInput == 1) {
                stepTracker.addNewNumberStepsPerDay();
            }
            else if (userInput == 2) {
                stepTracker.changeStepGoal();
            }
            else if (userInput == 3) {
                stepTracker.printStatistic();
            }
            else if (userInput == 4) {
                System.out.println("Спасибо, что выбираете наши носки и всего хорошего!");
                scanner.close();
                return;
            }
            else {
                System.out.println("Нет такого пункта: ' "+ userInput + " '. Введите номер подходящего пункта меню");
            }
        }
    }

    static void printMenu() {
        System.out.println();
        System.out.println("====___Введите номер подходящего пункта меню___====");
        System.out.println(" ' 1 ' Ввести количество шагов за определённый день.");
        System.out.println(" ' 2 ' Изменить цель по количеству шагов за день.");
        System.out.println(" ' 3 ' Напечатать статистику за определённый месяц.");
        System.out.println(" ' 4 ' Выйти из приложения.");
        System.out.println();

    }
}
