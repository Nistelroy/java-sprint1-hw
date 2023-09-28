import java.util.Scanner;

public class StepTracker {

    private int goalByStepsPerDay = 10_000;

    MonthData[] monthToData = new MonthData[12];
    Scanner scanner;

    StepTracker(Scanner scanner) {

        this.scanner = scanner;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {   // выкидывать юзера в начальное меню из-за ошибки в шаге и заставлять набирать с начала ну такое ¯\_(ツ)_/¯
                                        // Но раз тз...
        int monthNumber = 0;
        int dayNumber = 0;

        System.out.println("Введите номер месяца от 1 до 12");
        int userInput = scanner.nextInt();
            if (userInput <= 0 || userInput > 12) {
                System.out.println("Ошибка ввода месяца. ' " + userInput + " ' не подходит");
                return;
            }
            else monthNumber = userInput;


        System.out.println("Введите номер дня от 1 до 30");
        userInput = scanner.nextInt();
            if (userInput <= 0 || userInput > 30) {
                System.out.println("Ошибка ввода дня. ' " + userInput + " ' не подходит");
                return;
            }
            else dayNumber = userInput;


        System.out.println("Введите количество шагов");
        userInput = scanner.nextInt();
            if (userInput <= 0) {
                System.out.println("Колличество шагов должно быть больше чем '0'.  ' " + userInput + " ' не подходит");
            }
            else {
                monthToData[monthNumber - 1].days[dayNumber - 1] = userInput;
                System.out.println("Успешно. Месяц: " + monthNumber + " День: " + dayNumber + "  Шагов: " + userInput);
        }
    }

    void changeStepGoal(){

        System.out.println("Чтобы установить новую цель введите колличество шагов: ");
        int userInput = scanner.nextInt();

            if (userInput > 0) {
            goalByStepsPerDay = userInput;
            System.out.println("Сохранено! Новая цель "+ goalByStepsPerDay);
            }
            else {
                System.out.println("Число должно быть больше нуля");
            }
    }

    void printStatistic(){

        System.out.println("Введите номер месяца от 1 до 12");
        int userInput = scanner.nextInt();

            if (userInput > 0 && userInput <= 12) {

                int sumSteps = monthToData[userInput-1].sumStepsFromMonth();

                Converter converter = new Converter();

                monthToData[userInput-1].printDaysAndStepsFromMonth();
                System.out.println("Общее количество шагов за месяц: "+ sumSteps);
                System.out.println("Наибольшее колличество шагов в течении дня: "+ monthToData[userInput-1].maxSteps());
                System.out.println("Среднее колличестов шагов выбранном месяце: " + (sumSteps / 30));
                System.out.println("Пройдено километров за месяц: " + (converter.convertToKm(sumSteps)));
                System.out.println("За месяц сожжено ккалорий: " + (converter.convertStepsToKilocalories(sumSteps)));
                System.out.println("Дней подряд выполнялась цель шагов: "+ monthToData[userInput-1].bestSeries(goalByStepsPerDay));
                System.out.println();

            } else
                System.out.println("Ошибка ввода месяца " + userInput + ". Не подходит");
    }
}
