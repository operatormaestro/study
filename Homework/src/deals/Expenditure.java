package deals;

public class Expenditure extends Deal {
    public Expenditure(String nameOfProduct, int price) {
        super("Покупка " + nameOfProduct + " на " + price + " руб.", price, 0);
    }
}
