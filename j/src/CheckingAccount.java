public class CheckingAccount extends Account {

    public void getDetails() {

        String owner = getOwner();
        double balance = getBalance();

        System.out.println("owner: " + owner);
        System.out.println("balance: " + balance);
    }

    @Override
    public boolean debit(double amount) {
        return false;
    }

    @Override
    public boolean deposit(double amount) {
        return false;
    }
}
