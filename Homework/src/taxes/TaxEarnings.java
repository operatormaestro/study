package taxes;

public class TaxEarnings extends TaxSystem {
    @Override
    public int calcTaxFor(int debit, int credit) {
        if (debit > 0) {
            return (int) (debit * 0.06);
        } else return 0;
    }
}
