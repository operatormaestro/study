import java.util.*;

public class Main {
    public static void main(String[] args) {
        Address RM = new Address("Россия", "Москва");
        Address GL = new Address("Великобритания", "Лондон");
        Address GB = new Address("Германия", "Берлин");
        Address CP = new Address("Китай", "Пекин");
        Address JT = new Address("Япония", "Токио");
        Address IT = new Address("Иран", "Тегеран");
        Address AB = new Address("Аргентина", "Буэнос-Айрес");
        Map<Address, Integer> costPerAddress = new HashMap<>();
        Set<String> setCountry = new HashSet<>();
        costPerAddress.put(RM, 150);
        costPerAddress.put(GL, 300);
        costPerAddress.put(GB, 330);
        costPerAddress.put(CP, 285);
        costPerAddress.put(JT, 670);
        costPerAddress.put(IT, 220);
        costPerAddress.put(AB, 490);
        int total = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.println("Заполнение нового заказа.");
                    System.out.print("Введите страну: ");
                    String country = scanner.nextLine();
                    if (country.equals("end")) return;
                    System.out.print("Введите город: ");
                    String city = scanner.nextLine();
                    System.out.print("Введите вес (кг): ");
                    Integer weight = Integer.parseInt(scanner.nextLine());
                    Address current = new Address(country, city);
                    if (costPerAddress.containsKey(current)) {
                        int price = costPerAddress.get(current) * weight;
                        System.out.println("Стоимость доставки составит: " + price + " руб.");
                        total += price;
                        System.out.println("Общая стоимость всех доставок: " + total + " руб.");
                        setCountry.add(current.getCountry());
                        System.out.println("Количество уникальных стран в которые Вами были оформлены доставки за текущую сессию: " + setCountry.size());
                        System.out.println("==========================================================================================");
                    } else {
                        System.out.println("Доставки по этому адресу нет");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Для корректной работы программы, необходимо вводить вес в формате числа.");
                }
            }
        }
    }
}
