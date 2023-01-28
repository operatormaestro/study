import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        String[] products = {"Хлеб", "Яблоки", "Молоко"};
        int[] prices = {100, 200, 300};
        int[] count = new int[3];
        int sumProducts = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printList(products, prices);
            String input = scanner.nextLine();
            if (input.equals("end")) {
                printEnd(products, prices, count, sumProducts);
                break;
            } else {
                String[] tmp = input.split(" ");
                int productNumber = parseInt(tmp[0]);
                int productCount = parseInt(tmp[1]);
                sumProducts += productCount * prices[productNumber - 1];
                count[productNumber - 1] += productCount;
            }
        }

    }

    public static void printList(String[] products, int[] prices) {
        System.out.println("Список возможных товаров для покупки");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " " + prices[i] + " руб/шт");
        }
        System.out.println("Выберите товар и количество или введите \"end\"");
    }

    public static void printEnd(String[] products, int[] prices, int[] count, int sumProducts) {
        System.out.println("Ваша корзина:");
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i] + " " + prices[i] + " руб/шт " + prices[i] * count[i] + "руб в сумме");
        }
        System.out.println("Итого " + sumProducts + " руб");
    }
}
