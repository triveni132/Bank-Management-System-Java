import java.util.ArrayList;

public class Account {
    private String accountNumber;
    private String accountHolderName;
    private String accountType;
    private double balance;
    private ArrayList<Transaction> transactionHistory;
    
    public Account(String accountNumber, String accountHolderName, String accountType, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.balance = initialDeposit;
        this.transactionHistory = new ArrayList<>();
        
        if (initialDeposit > 0) {
            transactionHistory.add(new Transaction("DEPOSIT", initialDeposit, balance));
        }
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolderName() {
        return accountHolderName;
    }
    
    public String getAccountType() {
        return accountType;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Deposit amount must be positive.");
            return false;
        }
        
        balance += amount;
        transactionHistory.add(new Transaction("DEPOSIT", amount, balance));
        System.out.println("Successfully deposited $" + String.format("%.2f", amount));
        System.out.println("New balance: $" + String.format("%.2f", balance));
        return true;
    }
    
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be positive.");
            return false;
        }
        
        if (amount > balance) {
            System.out.println("Error: Insufficient funds. Available balance: $" + String.format("%.2f", balance));
            return false;
        }
        
        balance -= amount;
        transactionHistory.add(new Transaction("WITHDRAWAL", amount, balance));
        System.out.println("Successfully withdrawn $" + String.format("%.2f", amount));
        System.out.println("New balance: $" + String.format("%.2f", balance));
        return true;
    }
    
    public void displayBalance() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         BALANCE INQUIRY                ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Type: " + accountType);
        System.out.println("Current Balance: $" + String.format("%.2f", balance));
        System.out.println("══════════════════════════════════════════\n");
    }
    
    public void displayTransactionHistory() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                          TRANSACTION HISTORY                               ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════╝");
        System.out.println("Account: " + accountNumber + " | Holder: " + accountHolderName);
        System.out.println("════════════════════════════════════════════════════════════════════════════");
        
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            System.out.println("Type         | Amount       | Date & Time          | Balance After");
            System.out.println("────────────────────────────────────────────────────────────────────────────");
            for (Transaction transaction : transactionHistory) {
                System.out.println(transaction);
            }
            System.out.println("════════════════════════════════════════════════════════════════════════════");
            System.out.println("Total Transactions: " + transactionHistory.size());
        }
        System.out.println();
    }
    
    public void displayAccountInfo() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         ACCOUNT INFORMATION            ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Type: " + accountType);
        System.out.println("Current Balance: $" + String.format("%.2f", balance));
        System.out.println("Total Transactions: " + transactionHistory.size());
        System.out.println("══════════════════════════════════════════\n");
    }
}