package accounts;

public class SimpleAccount extends Account {
    public SimpleAccount() {
    }

    @Override
    public boolean add(long amount) {
        balance += amount;
        return true;
    }

    @Override
    public boolean pay(long amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else
            return false;
    }
}
