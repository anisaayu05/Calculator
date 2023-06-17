import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SavingAccount {
    private String name;
    private double balance;
    private double interestRate;
    private double loanAmount;

    public SavingAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.interestRate = 0.05;
        this.loanAmount = 0.0;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void deposit(double cash) {
        double interest = balance * interestRate;
        balance += interest + cash;
        reduceLoanAmount(cash);
    }

    public void deposit(double cash, double additionalInterest) {
        double interest = (balance * interestRate) + (balance * additionalInterest);
        balance += interest + cash;
        reduceLoanAmount(cash);
    }

    public void deposit(double cash, double loanAmount, double additionalInterest) {
        double interest = (balance * interestRate) + (balance * additionalInterest);
        balance += interest + cash - loanAmount;
        this.loanAmount = loanAmount;
        reduceLoanAmount(cash);
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void takeLoan(double loanAmount) {
        if (loanAmount <= balance) {
            balance += loanAmount;
            this.loanAmount = loanAmount;
            System.out.println("Loan taken successfully. Remaining Balance: " + balance);
        } else {
            System.out.println("Insufficient balance. Loan cannot be taken.");
        }
    }

    public void reduceLoanAmount(double amount) {
        if (amount <= loanAmount) {
            loanAmount -= amount;
        } else {
            System.out.println("Cannot reduce loan amount by more than the existing loan.");
        }
        balance -= amount;
    }

    public void saveAccountToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(name + ".txt"))) {
            writer.write("Account Name: " + name);
            writer.newLine();
            writer.write("Account Balance: " + balance);
            writer.newLine();
            writer.write("Interest Rate: " + interestRate);
            writer.newLine();
            writer.write("Loan Amount: " + loanAmount);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.out.println("An error occurred while saving the account details to a file.");
        }
    }
}