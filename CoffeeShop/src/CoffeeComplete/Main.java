package CoffeeComplete;

import java.util.Map;
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
                System.out.println("5. Memesan");
            }
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1, 2, 3, 4, 5, or 6): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Masukkan Detail Customers:");
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
                    System.out.print("Masukkan nomor telepon customers yang akan dihapus: ");
                    String phoneNumberToRemove = scanner.nextLine();
                    coffeeShop.removeCustomerByPhoneNumber(phoneNumberToRemove);
                    break;
                case 3:
                    coffeeShop.resetData();
                    hasData = false;
                    break;
                case 4:
                    coffeeShop.displayData();
                    break;
                case 5:
                    if (hasData) {
                        System.out.println("Masukkan nomor telepon Anda untuk melakukan pemesanan: ");
                        String phoneNumberForOrder = scanner.nextLine();
                        Customer customer = coffeeShop.findCustomerByPhoneNumber(phoneNumberForOrder);
                        if (customer != null) {
                            orderFoodAndDrinks(customer, scanner, coffeeShop);
                        } else {
                            System.out.println("Customers tidak ditemukan.");
                        }
                    } else {
                        System.out.println("Tidak ada data pelanggan yang tersedia. Harap tambahkan data pelanggan terlebih dahulu.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            coffeeShop.saveData();
        } while (choice != 6);
    }

    private static void orderFoodAndDrinks(Customer customer, Scanner scanner, CoffeeShop coffeeShop) {
        System.out.println("Selamat Datang, " + customer.getName() + "! Silahkan memesan");

        boolean isOrdering = true;
        int total = 0;
        Map<String, Integer> menu = coffeeShop.getMenu();

        while (isOrdering) {
            System.out.println("Menu:");
            displayMenu(menu);
            System.out.println("1. Order makanan");
            System.out.println("2. Order minuman");
            System.out.println("3. Finish ordering");
            System.out.print("Masukkan pilihan Anda (1, 2, or 3): ");
            int orderChoice = scanner.nextInt();
            scanner.nextLine();

            switch (orderChoice) {
                case 1:
                    System.out.print("Masukkan nama makanan: ");
                    String foodName = scanner.nextLine();
                    if (menu.containsKey(foodName)) {
                        int foodPrice = menu.get(foodName);
                        customer.addOrderedFood(foodName);
                        total += foodPrice;
                        System.out.println("Makanan berhasil dipesan: " + foodName);
                    } else {
                        System.out.println("Pilihan makanan tidak valid. Silakan coba lagi.");
                    }
                    break;
                case 2:
                    System.out.print("Masukkan nama minuman: ");
                    String drinkName = scanner.nextLine();
                    if (menu.containsKey(drinkName)) {
                        int drinkPrice = menu.get(drinkName);
                        customer.addOrderedDrink(drinkName);
                        total += drinkPrice;
                        System.out.println("Minuman berhasil dipesan: " + drinkName);
                    } else {
                        System.out.println("Pilihan minuman tidak valid. Silakan coba lagi.");
                    }
                    break;
                case 3:
                    isOrdering = false;
                    break;
                default:
                    System.out.println("Pilihan salah. Silakan coba lagi.");
                    break;
            }
        }

        System.out.println("Total: Rp" + total);
    }

    private static void displayMenu(Map<String, Integer> menu) {
        for (Map.Entry<String, Integer> entry : menu.entrySet()) {
            String item = entry.getKey();
            int price = entry.getValue();
            System.out.println(item + " : Rp" + price);
        }
    }
}
