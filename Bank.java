import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private ArrayList<Account> accounts;
    private int accountCounter;
    
    public Bank() {
        accounts = new ArrayList<>();
        accountCounter = 1001;
    }
    
    public void createAccount(Scanner scanner) {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║        CREATE NEW ACCOUNT              ║");
        System.out.println("╚════════════════════════════════════════╝");
        
        System.out.print("Enter Account Holder Name: ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine().trim();
        
        if (name.isEmpty()) {
            System.out.println("Error: Name cannot be empty.");
            return;
        }
        
        System.out.println("\nSelect Account Type:");
        System.out.println("1. Savings");
        System.out.println("2. Current");
        System.out.print("Enter choice (1-2): ");
        
        int typeChoice = getValidIntInput(scanner, 1, 2);
        String accountType = (typeChoice == 1) ? "Savings" : "Current";
        
        System.out.print("\nEnter Initial Deposit Amount: $");
        double initialDeposit = getValidDoubleInput(scanner);
        
        if (initialDeposit < 0) {
            System.out.println("Error: Initial deposit cannot be negative.");
            return;
        }
        
        String accountNumber = "ACC" + accountCounter++;
        Account newAccount = new Account(accountNumber, name, accountType, initialDeposit);
        accounts.add(newAccount);
        
        System.out.println("\n✓ Account created successfully!");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + name);
        System.out.println("Account Type: " + accountType);
        System.out.println("Initial Balance: $" + String.format("%.2f", initialDeposit));
        System.out.println("══════════════════════════════════════════\n");
    }
    
    public void deposit(Scanner scanner) {
        Account account = findAccount(scanner);
        if (account == null) return;
        
        System.out.print("Enter deposit amount: $");
        double amount = getValidDoubleInput(scanner);
        
        account.deposit(amount);
    }
    
    public void withdraw(Scanner scanner) {
        Account account = findAccount(scanner);
        if (account == null) return;
        
        System.out.print("Enter withdrawal amount: $");
        double amount = getValidDoubleInput(scanner);
        
        account.withdraw(amount);
    }
    
    public void checkBalance(Scanner scanner) {
        Account account = findAccount(scanner);
        if (account == null) return;
        
        account.displayBalance();
    }
    
    public void viewTransactionHistory(Scanner scanner) {
        Account account = findAccount(scanner);
        if (account == null) return;
        
        account.displayTransactionHistory();
    }
    
    public void listAllAccounts() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                          ALL ACCOUNTS                                  ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════╝");
        
        if (accounts.isEmpty()) {
            System.out.println("No accounts found in the system.");
        } else {
            System.out.printf("%-15s %-25s %-15s %s%n", "Account No.", "Holder Name", "Type", "Balance");
            System.out.println("────────────────────────────────────────────────────────────────────────");
            
            for (Account account : accounts) {
                System.out.printf("%-15s %-25s %-15s $%.2f%n", 
                    account.getAccountNumber(), 
                    account.getAccountHolderName(), 
                    account.getAccountType(), 
                    account.getBalance());
            }
            System.out.println("════════════════════════════════════════════════════════════════════════");
            System.out.println("Total Accounts: " + accounts.size());
        }
        System.out.println();
    }
    
    private Account findAccount(Scanner scanner) {
        System.out.print("\nEnter Account Number: ");
        String accountNumber = scanner.next().trim();
        
        for (Account account : accounts) {
            if (account.getAccountNumber().equalsIgnoreCase(accountNumber)) {
                return account;
            }
        }
        
        System.out.println("Error: Account not found.");
        return null;
    }
    
    private int getValidIntInput(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int input = scanner.nextInt();
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.print("Please enter a number between " + min + " and " + max + ": ");
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next(); // Clear invalid input
            }
        }
    }
    
    private double getValidDoubleInput(Scanner scanner) {
        while (true) {
            try {
                double input = scanner.nextDouble();
                return input;
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a valid amount: $");
                scanner.next(); // Clear invalid input
            }
        }
    }
    
    public int getTotalAccounts() {
        return accounts.size();
    }
    
    public double getTotalBankBalance() {
        double total = 0;
        for (Account account : accounts) {
            total += account.getBalance();
        }
        return total;
    }
}