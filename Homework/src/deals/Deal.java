package deals;

public class Deal {
    protected String comment;
    protected int creditChange;
    protected int debitChange;

    public int getDebitChange() {
        return debitChange;
    }

    public int getCreditChange() {
        return creditChange;
    }

    public String getComment() {
        return comment;
    }

    public Deal(String comment, int creditChange, int debitChange) {
        this.comment = comment;
        this.creditChange = creditChange;
        this.debitChange = debitChange;
    }

}
