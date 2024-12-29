public class BankAccount {
    private int dollars;

    public BankAccount(int dollars) {
        this.dollars = dollars;
    }
    public void deposit(int dollars) {
        this.dollars += dollars * 100;
    }

    public void deposit(int dollars, int cents) {
        this.dollars += dollars * cents;
    }
}