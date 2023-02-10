package deals;

public class Expenditure extends Deal {
    public Expenditure(String nameOfProduct, int price) {
        comment = "Покупка " + nameOfProduct + " на " + price + " руб.";
        debitChange = 0;
        creditChange = price;
    }
}
