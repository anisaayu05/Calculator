import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountTest {
    private static final String FILE_PATH = "accounts.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<SavingAccount> accounts = loadAccountsFromFile();

        boolean isExit = false;

        while (!isExit) {
            System.out.println("----- Account Management System -----");
            System.out.println("1. Create New Account");
            System.out.println("2. Add Money");
            System.out.println("3. Add Cash as Deposit");
            System.out.println("4. Take Loan");
            System.out.println("5. Check Balance");
            System.out.println("6. List All Accounts");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    SavingAccount account = createNewAccount(scanner, true);
                    accounts.add(account);
                    break;
                case 2:
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts available. Please create an account first.");
                    } else {
                        addMoney(scanner, accounts);
                    }
                    break;
                case 3:
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts available. Please create an account first.");
                    } else {
                        addCashAsDeposit(scanner, accounts);
                    }
                    break;
                case 4:
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts available. Please create an account first.");
                    } else {
                        takeLoan(scanner, accounts);
                    }
                    break;
                case 5:
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts available. Please create an account first.");
                    } else {
                        checkBalance(accounts, scanner);
                    }
                    break;
                case 6:
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts available. Please create an account first.");
                    } else {
                        listAllAccounts(accounts);
                    }
                    break;
                case 7:
                    isExit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        saveAccountsToFile(accounts);
        System.out.println("Thank you for using the Account Management System.");
    }

    private static SavingAccount createNewAccount(Scanner scanner, boolean requireMinimumBalance) {
        System.out.print("Enter account name: ");
        String accountName = scanner.nextLine();

        double initialBalance = 0.0;

        if (requireMinimumBalance) {
            while (initialBalance < 500000.0) {
                System.out.print("Enter initial balance (minimum 500,000): ");
                initialBalance = scanner.nextDouble();
                scanner.nextLine();

                if (initialBalance < 500000.0) {
                    System.out.println("Initial balance must be at least 500,000.");
                }
            }
        } else {
            System.out.print("Enter initial balance: ");
            initialBalance = scanner.nextDouble();
            scanner.nextLine();
        }

        SavingAccount account = new SavingAccount(accountName, initialBalance);

        System.out.println("Account Name: " + account.getName());
        System.out.println("Initial Balance: " + account.getBalance());

        return account;
    }

    private static void addMoney(Scanner scanner, List<SavingAccount> accounts) {
        System.out.print("Enter account name: ");
        String accountName = scanner.nextLine();

        SavingAccount account = findAccountByName(accounts, accountName);
        if (account == null) {
            System.out.println("Account not found.");
        } else {
            System.out.print("Enter amount to add: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            account.deposit(amount);
            System.out.println("Money added successfully.");

            saveAccountsToFile(accounts);
        }
    }

    private static void addCashAsDeposit(Scanner scanner, List<SavingAccount> accounts) {
        System.out.print("Enter account name: ");
        String accountName = scanner.nextLine();

        SavingAccount account = findAccountByName(accounts, accountName);
        if (account == null) {
            System.out.println("Account not found.");
        } else {
            System.out.print("Enter cash amount: ");
            double cash = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Enter loan amount: ");
            double loanAmount = scanner.nextDouble();
            scanner.nextLine();

            if (cash > account.getLoanAmount()) {
                double excessCash = cash - account.getLoanAmount();
                account.deposit(excessCash);
                account.setLoanAmount(0.0);
            } else {
                account.deposit(cash);
                account.reduceLoanAmount(loanAmount);
            }

            System.out.println("Deposit added successfully.");

            saveAccountsToFile(accounts);
        }
    }

    private static void takeLoan(Scanner scanner, List<SavingAccount> accounts) {
        System.out.print("Enter account name: ");
        String accountName = scanner.nextLine();

        SavingAccount account = findAccountByName(accounts, accountName);
        if (account == null) {
            System.out.println("Account not found.");
        } else {
            System.out.print("Enter loan amount: ");
            double loanAmount = scanner.nextDouble();
            scanner.nextLine();

            account.takeLoan(loanAmount);

            saveAccountsToFile(accounts);
        }
    }

    private static void checkBalance(List<SavingAccount> accounts, Scanner scanner) {
        System.out.print("Enter account name: ");
        String accountName = scanner.nextLine();

        SavingAccount account = findAccountByName(accounts, accountName);
        if (account == null) {
            System.out.println("Account not found.");
        } else {
            System.out.println("Account Name: " + account.getName());
            System.out.println("Balance: " + account.getBalance());
            System.out.println("Loan Amount: " + account.getLoanAmount());
        }
    }

    private static void listAllAccounts(List<SavingAccount> accounts) {
        for (SavingAccount account : accounts) {
            System.out.println("Account Name: " + account.getName());
            System.out.println("Balance: " + account.getBalance());
            System.out.println("Loan Amount: " + account.getLoanAmount());
            System.out.println("-----------------------------");
        }
    }

    private static List<SavingAccount> loadAccountsFromFile() {
        List<SavingAccount> accounts = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] accountData = line.split(",");
                if (accountData.length == 3) {
                    String name = accountData[0];
                    double balance = Double.parseDouble(accountData[1]);
                    double loanAmount = Double.parseDouble(accountData[2]);
                    SavingAccount account = new SavingAccount(name, balance);
                    account.setLoanAmount(loanAmount);
                    accounts.add(account);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while loading accounts from file.");
        }

        return accounts;
    }

    private static void saveAccountsToFile(List<SavingAccount> accounts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (SavingAccount account : accounts) {
                String line = account.getName() + "," + account.getBalance() + "," + account.getLoanAmount();
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Accounts saved successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving accounts to file.");
        }
    }

    private static SavingAccount findAccountByName(List<SavingAccount> accounts, String accountName) {
        for (SavingAccount account : accounts) {
            if (account.getName().equals(accountName)) {
                return account;
            }
        }
        return null;
    }
}
