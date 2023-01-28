import java.util.Scanner;

public class taxConsultant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;    // доходы
        int spendings = 0;   // расходы
        while (true) {
            System.out.println("Выберите операцию и введ1ите её номер:\n" +
                    "1. Добавить новый доход\n" +
                    "2. Добавить новый расход\n" +
                    "3. Выбрать ситему налогооблажения");
            String input = scanner.nextLine();
            if (input.equals("end")) break;
            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine(); // Не используйте тут nextInt (!)
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    moneyStr = scanner.nextLine(); // Не используйте тут nextInt (!)
                    money = Integer.parseInt(moneyStr);
                    spendings += money;
                    break;
                case 3:
                    int taxEMS = taxEarningsMinusSpendings(earnings, spendings);
                    int taxE = taxEarnings(earnings);
                    if (taxEMS > taxE) {
                        System.out.println("Мы советуем вам УСН доходы\n" +
                                "Ваш налог составит: " + taxE + "\n" +
                                "Налог на другой системе: " + taxEMS + "\n" +
                                "Экономия: " + (taxEMS - taxE));
                    } else if (taxE > taxEMS) {
                        System.out.println("Мы советуем вам УСН доходы минус расходы\n" +
                                "Ваш налог составит: " + taxEMS + "\n" +
                                "Налог на другой системе: " + taxE + "\n" +
                                "Экономия: " + (taxE - taxEMS));
                    } else {
                        System.out.println("Можете выбрать любую систему налогооблажения");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
        System.out.println("Программа завершена!");
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarnings(int earnings) {
        int tax = (earnings) * 6 / 100;
        return tax;

    }
}
