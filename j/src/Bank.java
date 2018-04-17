public class Bank {

    private Account[] listUser;
    private int amount;

    Bank(int numberOfUser) {

        Account[] listUser = new Account[numberOfUser];
        amount = 0;
    }

    private void add(Account ob) {

        listUser[amount] = ob;
    }

    private void printAllAccount() {

        for (int i = listUser.length - 1; i >= 0; i--) {

            listUser[i].checkBalance();
        }
    }

    private double calculateTotalBalance() {

        double sum = 0;
        for (int i = 0; i < listUser.length; i++) {

            sum += listUser[i].getInterest();
        }

        return sum;
    }
}
