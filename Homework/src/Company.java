import deals.Deal;
import taxes.TaxSystem;

public class Company {
    private final String title;
    private int debit = 0;
    private int credit = 0;
    private TaxSystem taxSystem;

    public Company(String title, TaxSystem taxSystem) {
        this.title = title;
        this.taxSystem = taxSystem;
    }

    public void shiftMoney(int amount) {
        if (amount > 0) {
            debit += amount;
        } else if (amount < 0) {
            credit += Math.abs(amount);
        }
    }

    public void setTaxSystem(TaxSystem taxSystem) {
        this.taxSystem = taxSystem;
    }

    public void payTaxes() {
        int tax = taxSystem.calcTaxFor(debit, credit);
        System.out.println("Компания " + "\"" + title + "\"" + " уплатила налог в размере: " + tax + " руб.");
        debit = 0;
        credit = 0;
    }

    public int applyDeals(Deal[] deals) {
        for (Deal d : deals) {
            debit += d.getDebitChange();
            credit += d.getCreditChange();
        }
        int balance = debit - credit;
        payTaxes();
        return balance;
    }
}
