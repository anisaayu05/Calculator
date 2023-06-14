package CoffeeComplete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CoffeeShop {
    private List<Customer> customers;
    private String filename;

    public CoffeeShop(String filename) {
        this.filename = filename;
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomerByphoneNumber(String phonenumber) {
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getPhoneNumber().equals(phonenumber)) {
                iterator.remove();
                System.out.println("Customer removed successfully.");
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    public void resetData() {
        customers.clear();
        System.out.println("All customer data has been reset.");
    }

    public void saveData() {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (Customer customer : customers) {
                writer.println(customer.getName() + "," + customer.getEmail() + "," + customer.getPhoneNumber());
            }
            System.out.println("Data saved successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred while saving the data.");
        }
    }

    public void loadData() {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                if (data.length == 3) {
                    String name = data[0];
                    String email = data[1];
                    String phoneNumber = data[2];
                    if (!phoneNumber.startsWith("+62")) {
                        phoneNumber = "+62" + phoneNumber;
                    }
                    Customer customer = new Customer(name, email, phoneNumber);
                    customers.add(customer);
                }
            }
            System.out.println("Data loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Error occurred while loading the data.");
        }
    }

    public void displayData() {
        int index = 1;
        for (Customer customer : customers) {
            System.out.println("Data " + index + ":");
            System.out.println("Name: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Phone Number: " + customer.getPhoneNumber());
            System.out.println("----------------------");
            index++;
        }
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
