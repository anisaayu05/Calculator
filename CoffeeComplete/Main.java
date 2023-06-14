package CoffeeComplete;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CoffeeShop coffeeShop = new CoffeeShop("customer_data.txt");
        coffeeShop.loadData();
        Scanner scanner = new Scanner(System.in);

        int choice;
        boolean hasData = !coffeeShop.getCustomers().isEmpty();

        do {
            System.out.println("1. Add customer data");
            System.out.println("2. Remove customer data");
            System.out.println("3. Reset all data");
            if (hasData) {
                System.out.println("4. Display customer data");
            }
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1, 2, 3, 4, or 5): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter customer details:");
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Phone Number: ");
                    String phoneNumber = scanner.nextLine();

                    coffeeShop.addCustomer(new Customer(name, email, phoneNumber));
                    hasData = true;
                    break;
                case 2:
                    System.out.print("Enter the phone number of the customer to remove: ");
                    String nameToRemove = scanner.nextLine();
                    coffeeShop.removeCustomerByphoneNumber(nameToRemove);
                    break;
                case 3:
                    coffeeShop.resetData();
                    hasData = false;
                    break;
                case 4:
                    coffeeShop.displayData();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            coffeeShop.saveData();
        } while (choice != 5);
    }
}