package deals;

public class Sale extends Deal {
    public Sale(String nameOfProduct, int price) {
        super("Продажа " + nameOfProduct + " на " + price + " руб.", 0, price);
    }
}
