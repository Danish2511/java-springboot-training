package Day2;
class BankAccount {
    protected String accountHolderName;
    protected String accountNumber;
    protected double balance;

    // Constructor
    public BankAccount(String accountHolderName, String accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    // Method to withdraw money with balance validation
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }

    // Method to check the balance
    public void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }

    // Getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }
}

class SavingsAccount extends BankAccount {
    private static final double MIN_BALANCE = 500.0; // Minimum balance required for SavingsAccount

    // Constructor
    public SavingsAccount(String accountHolderName, String accountNumber, double initialBalance) {
        super(accountHolderName, accountNumber, initialBalance);
    }

    // Override withdraw method to include minimum balance validation
    @Override
    public void withdraw(double amount) {
        if (balance - amount >= MIN_BALANCE) {
            super.withdraw(amount);
        } else {
            System.out.println("Cannot withdraw. Minimum balance of $" + MIN_BALANCE + " must be maintained.");
        }
    }
}

class CurrentAccount extends BankAccount {
    private static final double OVERDRAFT_LIMIT = 1000.0;

    public CurrentAccount(String accountHolderName, String accountNumber, double initialBalance) {
        super(accountHolderName, accountNumber, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= -OVERDRAFT_LIMIT) {
            super.withdraw(amount);
        } else {
            System.out.println("Insufficient balance or overdraft limit exceeded.");
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        // Create a SavingsAccount and CurrentAccount
        SavingsAccount savingsAccount = new SavingsAccount("John Doe", "SA12345", 1000);
        CurrentAccount currentAccount = new CurrentAccount("Jane Smith", "CA98765", 1500);

        // Perform operations on SavingsAccount
        System.out.println("Operations on SavingsAccount:");
        savingsAccount.deposit(500); // Deposit money
        savingsAccount.checkBalance(); // Check balance
        savingsAccount.withdraw(200); // Withdraw money
        savingsAccount.checkBalance(); // Check balance after withdrawal
        savingsAccount.withdraw(1500); // Try withdrawing more than the available balance (with min balance check)

        // Perform operations on CurrentAccount
        System.out.println("\nOperations on CurrentAccount:");
        currentAccount.deposit(500); // Deposit money
        currentAccount.checkBalance(); // Check balance
        currentAccount.withdraw(1000); // Withdraw money within the limit
        currentAccount.checkBalance(); // Check balance after withdrawal
        currentAccount.withdraw(3000); // Try withdrawing more than available balance (overdraft check)
    }
}
