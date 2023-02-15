package accounts;

public abstract class Account {
    protected long balance = 0;

    public Account() {

    }

    protected abstract boolean add(long amount);

    protected abstract boolean pay(long amount);

    public boolean transfer(Account account, long amount) {
        boolean isPay = this.pay(amount);
        boolean isAdd = account.add(amount);
        // примитивная реализация транзакции, иначе происходит потеря средств между счетами если проходит платеж, но не проходит зачисление и наоборот.
        if (isPay && isAdd) {
            return true;
        } else if (isPay) {
            this.add(amount);
            return false;
        } else if (isAdd) {
            account.pay(amount);
            return false;
        } else {
            return false;
        }
    }

    public long getBalance() {
        return balance;
    }
}
