import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        
        displayWelcomeBanner();
        
        boolean running = true;
        
        while (running) {
            displayMenu();
            System.out.print("Enter your choice (1-8): ");
            
            int choice = getValidChoice(scanner);
            
            switch (choice) {
                case 1:
                    bank.createAccount(scanner);
                    break;
                case 2:
                    bank.deposit(scanner);
                    break;
                case 3:
                    bank.withdraw(scanner);
                    break;
                case 4:
                    bank.checkBalance(scanner);
                    break;
                case 5:
                    bank.viewTransactionHistory(scanner);
                    break;
                case 6:
                    bank.listAllAccounts();
                    break;
                case 7:
                    displayBankStatistics(bank);
                    break;
                case 8:
                    displayExitMessage();
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
            if (running) {
                System.out.print("\nPress Enter to continue...");
                scanner.nextLine();
                scanner.nextLine();
                clearScreen();
            }
        }
        
        scanner.close();
    }
    
    private static void displayWelcomeBanner() {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                                ║");
        System.out.println("║          WELCOME TO DIGITAL BANKING SYSTEM                     ║");
        System.out.println("║                                                                ║");
        System.out.println("║          Your Trusted Banking Partner                          ║");
        System.out.println("║                                                                ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        System.out.println();
    }
    
    private static void displayMenu() {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                       MAIN MENU                                ║");
        System.out.println("╠════════════════════════════════════════════════════════════════╣");
        System.out.println("║  1. Create New Account                                         ║");
        System.out.println("║  2. Deposit Money                                              ║");
        System.out.println("║  3. Withdraw Money                                             ║");
        System.out.println("║  4. Check Balance                                              ║");
        System.out.println("║  5. View Transaction History                                   ║");
        System.out.println("║  6. List All Accounts                                          ║");
        System.out.println("║  7. Bank Statistics                                            ║");
        System.out.println("║  8. Exit                                                       ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        System.out.println();
    }
    
    private static void displayBankStatistics(Bank bank) {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         BANK STATISTICS                ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Total Accounts: " + bank.getTotalAccounts());
        System.out.println("Total Bank Balance: $" + String.format("%.2f", bank.getTotalBankBalance()));
        System.out.println("══════════════════════════════════════════\n");
    }
    
    private static void displayExitMessage() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                                ║");
        System.out.println("║          Thank you for using Digital Banking System!          ║");
        System.out.println("║                                                                ║");
        System.out.println("║          Have a great day!                                     ║");
        System.out.println("║                                                                ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
    }
    
    private static int getValidChoice(Scanner scanner) {
        while (true) {
            try {
                int choice = scanner.nextInt();
                return choice;
            } catch (Exception e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next(); // Clear invalid input
            }
        }
    }
    
    private static void clearScreen() {
        // For better user experience - prints blank lines
        for (int i = 0; i < 2; i++) {
            System.out.println();
        }
    }
}