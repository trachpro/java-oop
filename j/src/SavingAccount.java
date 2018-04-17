import java.util.Date;
import java.time.LocalDateTime;

public class SavingAccount extends Account {

    private float interest;
    private LocalDateTime dateCreated;

    SavingAccount(float itr) {

        this.setInterest(itr);

        dateCreated = LocalDateTime.now();
    }

    public void setInterest(float interest) {

        this.interest = interest;
    }

    public float getInterest() {

        return interest;
    }

    public boolean updateBalance() {

        if(!compareDate()) return false;

        double balance = this.getBalance();

        this.setBalance(balance + balance*interest/100);

        return true;
    }

    private boolean compareDate() {

        LocalDateTime now = LocalDateTime.now();

        if(now.getDayOfMonth() == dateCreated.getDayOfMonth() && now.getMonthValue() == dateCreated.getMonthValue()) {

            return true;
        } else {

            return false;
        }
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

        if(!compareDate()) return false;

        double balance = getBalance();

        if(amount > balance) {

            return false;
        } else {

            balance -= amount;

            setBalance(balance);

            return true;
        }
    }

    @Override
    public boolean deposit(double amount) {

        if(!compareDate()) return false;

        double balance = getBalance();

        if(amount < 0) {

            return false;
        } else {

            balance += amount;

            setBalance(balance);

            return true;
        }
    }
}
