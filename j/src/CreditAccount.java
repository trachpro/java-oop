import java.time.LocalDateTime;

public class CreditAccount extends Account {

    private double limit;
    private double debitInterest;
    private double creditInterest;
    private LocalDateTime dateCreated;

    CreditAccount() {

        dateCreated = LocalDateTime.now();
    }

    public void setLimit(double lm) {

        limit = lm;
    }

    public void setDebitInterest( double interest) {

        debitInterest = interest;
    }

    public void setCreditInterest( double interest ) {

        creditInterest = interest;
    }

    @Override
    public boolean deposit(double amount) {

        double balance = getBalance();

        if(amount < 0) return false;

        balance += amount;

        setBalance(amount);

        return true;
    }

    @Override
    public void getDetails() {

        String owner = getOwner();
        double balance = getBalance();

        System.out.println("owner: " + owner);
        System.out.println("balance: " + balance);
    }

    @Override
    public boolean debit(double amount) {

        double balance = getBalance();

        if(amount > balance + limit) return false;

        else{

            balance -= amount;

            setBalance(balance);

            return true;
        }
    }

    public void updateBalance() {

        double balance = getBalance();

        if(balance > 0) {

            balance += debitInterest;
        } else {

            balance -= creditInterest;
        }

        setBalance(balance);
    }
}
