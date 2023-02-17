import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            PasswordChecker passwordChecker = new PasswordChecker();
            //passwordChecker.verify("password"); проверка выброса исключения IllegalStateException.
            try {
                System.out.print("Введите мин. длину пароля: ");
                passwordChecker.setMinLength(Integer.parseInt(scanner.nextLine()));
                System.out.print("Введите макс. допустимое количество повторений символа подряд: ");
                passwordChecker.setMaxRepeats(Integer.parseInt(scanner.nextLine()));
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели некорректные настройки.");
                System.exit(0);
            }
            while (true) {
                System.out.print("Введите пароль или end: ");

                String password = scanner.nextLine();
                if (password.equals("end")) {
                    System.out.println("Программа завершена");
                    System.exit(0);
                } else {
                    if (passwordChecker.verify(password)) {
                        System.out.println("Подходит!");
                    } else {
                        System.out.println("Не подходит!");
                    }
                }
            }
        }
    }
}