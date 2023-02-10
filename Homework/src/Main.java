import deals.Deal;
import deals.Expenditure;
import deals.Sale;
import taxes.TaxEarnings;
import taxes.TaxEarningsMinusSpending;

public class Main {
    public static void main(String[] args) {
        Company company = new Company("Рога и копыта", new TaxEarningsMinusSpending());
        company.shiftMoney(-1_000_000);
        company.payTaxes();
        company.shiftMoney(10_000_000);
        company.setTaxSystem(new TaxEarnings());
        company.payTaxes();
        company.setTaxSystem(new TaxEarningsMinusSpending());
        Expenditure expenditure = new Expenditure("Копыта", 1000);
        Expenditure expenditure1 = new Expenditure("iFone made in China", 2000);
        Sale sale = new Sale("Рога", 10000);
        Sale sale1 = new Sale("iPhone", 200000);
        System.out.println(sale.getComment());
        Deal[] deals = {expenditure, expenditure1, sale, sale1};
        System.out.println("Сальдо баланса по проведенным сделкам до уплаты налогов: " + company.applyDeals(deals) + " руб.");

    }
}
