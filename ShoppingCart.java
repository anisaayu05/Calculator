public class ShoppingCart {
    public static void main(String[] args) {
        // Declare and initialize String variables
        String customerName = "Anisa";
        String item = "sweater";
        String size = "M";
        int harga = 47000;
        int jumlah = 2;
        int totalHarga = jumlah * harga;
        double diskon = 0.1 * totalHarga;
        double totalBayar = totalHarga - diskon;
        String message;

        // Message variable
        message = customerName + " membeli " + jumlah + " " + item + " ukuran " + size + " " + "dengan total harga: Rp" + (totalHarga) + ".";
        message += " Dengan diskon Rp" + (diskon) + "," + " totalnya menjadi Rp" + (totalBayar);

        // Print and run the code
        System.out.println(message);
    }
}
