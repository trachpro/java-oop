public abstract class Account {
    private String owner;
    private double balance;

    public boolean credit(double amount) {

        if(amount < 0) {
            return false;
        }

        balance += amount;
        return true;
    }

    public  boolean debit(double amount, String currency) {

        switch (currency) {

            case "VND": return debit(amount);
            case "USD": return debit(amount*22000);
            case "GBP": return debit(amount*32000);
            default: return false;
        }
    }


    public  boolean deposit(double amount, String currency) {

        switch (currency) {

            case "VND": return debit(amount);
            case "USD": return debit(amount*22000);
            case "GBP": return debit(amount*32000);
            default: return false;
        }
    }

    void setOwner(String owner) {

        this.owner = owner;
    }

    void setBalance(double balance) {

        this.balance = balance;
    }

    public void setData(String owner, double balance) {

        setOwner(owner);
        setBalance(balance);
    }

    public double getBalance() {

        return balance;
    }

    public void checkBalance() {

        System.out.println(owner + ": balance = " + balance);
    }

    public String getOwner() {

        return owner;
    }

    public abstract boolean deposit(double amount);

    public abstract void getDetails();

    public abstract boolean debit(double amount);
}
