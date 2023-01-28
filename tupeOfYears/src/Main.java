import java.util.Scanner;

class Main {

    public static int DAYS_IN_USUALLY_YEAR = 365;
    public static int DAYS_IN_LEAP_YEAR = 366;

    // поскольку количество дней в году, как в обычном так и в високосном это константы, считаю правильным их в таком ввиде вписать в программу.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        while (true) {
            System.out.println("Введите год:");
            int year = scanner.nextInt();
            System.out.println("Введите количество дней:");
            int days = scanner.nextInt();

            // метод typeOfYear возвращает 1 если год является високосным и 0 если год не является.
            // метод printError печатает в консоли сообщение об ошибке с указанием верного количества дней в году, с параметром toy = 1 для високосного года и toy = 0 для невисокосного.

            if (typeOfYear(year) == 1) {
                if (days == DAYS_IN_LEAP_YEAR) {
                    score++;
                } else {
                    printError(1);
                    System.out.println("Набрано очков: " + score);
                    break;
                }
            } else {
                if (days == DAYS_IN_USUALLY_YEAR) {
                    score++;
                } else {
                    printError(0);
                    System.out.println("Набрано очков: " + score);
                    break;
                }
            }
        }
    }

    public static int typeOfYear(int year) {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void printError(int toy) {
        if (toy == 1) {
            System.out.println("Неправильно! В этом году " + DAYS_IN_LEAP_YEAR + " дней!");
        } else {
            System.out.println("Неправильно! В этом году " + DAYS_IN_USUALLY_YEAR + " дней!");
        }
    }
}