package deals;

public class Sale extends Deal {
    public Sale(String nameOfProduct, int price) {
        comment = "Продажа " + nameOfProduct + " на " + price + " руб.";
        debitChange = price;
        creditChange = 0;
    }
}
