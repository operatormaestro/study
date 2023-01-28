import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static String[] products = {"Хлеб", "Яблоки", "Молоко"};
    public static int[] prices = {100, 200, 300};
    public static int[] count = new int[3];

    public static void main(String[] args) {

        int sumProducts = 0;
        Scanner scanner = new Scanner(System.in);
        label:
        while (true) {
            printList(products, prices);
            String input = scanner.nextLine();
            switch (input) {
                case "+":
                    System.out.println("Добавьте в список продукт в формате: Название цена");
                    String newPair = scanner.nextLine();
                    String[] tmp2 = newPair.split(" ");
                    addProduct(tmp2[0], parseInt(tmp2[1]));
                    break;
                case "-":
                    System.out.println("Для удаления продукта из списка покупок введите его номер:");
                    String numberForDelete = scanner.nextLine();
                    deleteProduct(parseInt(numberForDelete));
                    break;
                case "end":
                    printEnd(products, prices, count, sumProducts);
                    break label;
                default:
                    String[] tmp = input.split(" ");
                    int productNumber = parseInt(tmp[0]);
                    int productCount = parseInt(tmp[1]);
                    sumProducts += productCount * prices[productNumber - 1];
                    count[productNumber - 1] += productCount;
                    break;
            }
        }

    }

    public static void printList(String[] products, int[] prices) {
        System.out.println("Список возможных товаров для покупки");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " " + prices[i] + " руб/шт");
        }
        System.out.println("Выберите товар и количество или введите \"end\"");
        System.out.println("Для добавления продукта в список введите +, для удаления продукта введите -");
    }

    public static void printEnd(String[] products, int[] prices, int[] count, int sumProducts) {
        System.out.println("Ваша корзина:");
        for (int i = 0; i < products.length; i++) {
            if (count[i] != 0) {
                System.out.println(products[i] + " " + prices[i] + " руб/шт " + prices[i] * count[i] + "руб в сумме");
            }
        }
        System.out.println("Итого " + sumProducts + " руб");
    }

    public static void addProduct(String newProduct, int newPrice) {
        String[] newProducts = new String[products.length + 1];
        int[] newPrices = new int[prices.length + 1];
        int[] newCount = new int[count.length + 1];
        for (int i = 0; i < products.length; i++) {
            newProducts[i] = products[i];
            newPrices[i] = prices[i];
            newCount[i] = count[i];
        }
        newProducts[products.length] = newProduct;
        products = newProducts;
        newPrices[prices.length] = newPrice;
        prices = newPrices;
        count = newCount;
    }

    public static void deleteProduct(int ProductNumber) {
        String[] newProducts = new String[products.length - 1];
        int[] newPrices = new int[prices.length - 1];
        int[] newCount = new int[count.length - 1];
        for (int i = 0; i < products.length; i++) {
            if (i < ProductNumber - 1) {
                newProducts[i] = products[i];
                newPrices[i] = prices[i];
                newCount[i] = count[i];
            } else if (i > ProductNumber - 1) {
                newProducts[i - 1] = products[i];
                newPrices[i - 1] = prices[i];
                newCount[i - 1] = count[i];
            }
        }
        products = newProducts;
        prices = newPrices;
        count = newCount;
    }
}
