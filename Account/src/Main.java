import accounts.CreditAccount;
import accounts.SimpleAccount;

public class Main {
    public static void main(String[] args) {
        SimpleAccount simpleAccount = new SimpleAccount();
        CreditAccount creditAccount = new CreditAccount(100_000);
        System.out.println(simpleAccount.add(1000));
        System.out.println(simpleAccount.getBalance());
        System.out.println(simpleAccount.pay(500));
        System.out.println(simpleAccount.getBalance());
        System.out.println(simpleAccount.pay(1000));
        System.out.println(simpleAccount.getBalance());
        System.out.println(simpleAccount.transfer(creditAccount, 500));
        System.out.println(simpleAccount.getBalance());
        System.out.println(creditAccount.getBalance());
        System.out.println(creditAccount.pay(10_000));
        System.out.println(creditAccount.getBalance());
        System.out.println(simpleAccount.transfer(creditAccount, 500));
        System.out.println(simpleAccount.getBalance());
        System.out.println(creditAccount.getBalance());
    }
}
