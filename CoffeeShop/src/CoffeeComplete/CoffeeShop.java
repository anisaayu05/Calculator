package CoffeeComplete;

import java.io.*;
import java.util.*;

public class CoffeeShop {
    private List<Customer> customers;
    private String filename;
    private Map<String, Integer> menu;

    public CoffeeShop(String filename) {
        this.filename = filename;
        customers = new ArrayList<>();
        menu = new HashMap<>();
        initializeMenu();
    }

    private void initializeMenu() {
        menu.put("Kopi", 10000);
        menu.put("Americano", 8000);
        menu.put("Banana Milk", 8000);
        menu.put("Chocolate Milk", 11000);
        menu.put("Teh", 8000);
        menu.put("Roti", 5000);
        menu.put("Kue", 4000);
        menu.put("Pancong", 7000);
        menu.put("Waffle", 8000);
        menu.put("Brownies", 6000);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void removeCustomerByPhoneNumber(String phoneNumber) {
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                iterator.remove();
                System.out.println("Customer removed successfully.");
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    public Customer findCustomerByPhoneNumber(String phoneNumber) {
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phoneNumber)) {
                return customer;
            }
        }
        return null;
    }

    public void resetData() {
        customers.clear();
        System.out.println("All customer data has been reset.");
    }

    public void saveData() {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (Customer customer : customers) {
                StringBuilder customerData = new StringBuilder();
                customerData.append(customer.getName()).append(",")
                        .append(customer.getEmail()).append(",")
                        .append(customer.getPhoneNumber()).append(",");
                for (String food : customer.getOrderedFood()) {
                    customerData.append(food).append(",");
                }
                for (String drink : customer.getOrderedDrinks()) {
                    customerData.append(drink).append(",");
                }
                writer.println(customerData.toString());
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
                if (data.length >= 3) {
                    String name = data[0];
                    String email = data[1];
                    String phoneNumber = data[2];
                    if (!phoneNumber.startsWith("+62")) {
                        phoneNumber = "+62" + phoneNumber;
                    }
                    Customer customer = new Customer(name, email, phoneNumber);
                    for (int i = 3; i < data.length; i++) {
                        String order = data[i];
                        if (menu.containsKey(order)) {
                            if (i % 2 == 1) {
                                customer.addOrderedFood(order);
                            } else {
                                customer.addOrderedDrink(order);
                            }
                        }
                    }
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
            System.out.println("Ordered Food: ");
            for (String food : customer.getOrderedFood()) {
                System.out.println("- " + food);
            }
            System.out.println("Ordered Drinks: ");
            for (String drink : customer.getOrderedDrinks()) {
                System.out.println("- " + drink);
            }
            System.out.println("----------------------");
            index++;
        }
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public Map<String, Integer> getMenu() {
        return menu;
    }
}
