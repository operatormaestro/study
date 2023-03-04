import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ToDoList toDoList = new ToDoList();
            try {
                while (true) {
                    printMenu();
                    int change = Integer.parseInt(scanner.nextLine());
                    switch (change) {
                        case (0):
                            return;
                        case (1):
                            System.out.print("Введите название задачи: ");
                            String newCase = scanner.nextLine();
                            toDoList.addCase(newCase);
                            System.out.println("Ваш список дел:");
                            toDoList.printAllCase();
                            break;
                        case (2):
                            toDoList.printAllCase();
                            break;
                        case (3):
                            System.out.print("Введите номер для удаления: ");
                            int num = Integer.parseInt(scanner.nextLine());
                            toDoList.deleteByNum(num);
                            toDoList.printAllCase();
                            break;
                        case (4):
                            System.out.println("Введите задачу для удаления: ");
                            String Case = scanner.nextLine();
                            toDoList.deleteByText(Case);
                            toDoList.printAllCase();
                            break;
                        case (5):
                            System.out.println("Введите ключевое слово с учетом регистра: ");
                            String word = scanner.nextLine();
                            toDoList.deleteByWord(word);
                            toDoList.printAllCase();
                            break;
                        default:
                            System.out.println("Введен некорректный номер пункта меню.");
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Для навигации по меню необходимо вводить число.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите операцию:");
        System.out.println("-----------------------------");
        System.out.println("0. Выход из программы");
        System.out.println("1. Добавить дело");
        System.out.println("2. Показать дела");
        System.out.println("3. Удалить дело по номеру");
        System.out.println("4. Удалить дело по названию");
        System.out.println("5. Удалить дело по ключевому слову");
        System.out.println("-----------------------------");
        System.out.print("Ваш выбор: ");
    }
}
