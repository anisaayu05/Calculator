public class ShoppingCart02 {
    public static void main(String [] args) {
        double price = 19.00;
        double tax = 0.030;
        int quantity = 2;
        double totalPrice = (price * quantity) * (1 + tax);
        String custName = "Anisa";
        String itemDesc = "Shirt";
        String message = custName + " wants to purchase " + quantity + " " + itemDesc;
        System.out.println(message);
        System.out.println("Total cost with tax is: $" + totalPrice);
    }
}
