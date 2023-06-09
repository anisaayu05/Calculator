import javax.swing.*;

class InputUser {
    private String nama;
    private String menu;
    private int jumlah;
    public double harga;
    public double hargaMakanan;
    public double hargaMinuman;

    public void inputDataGUI() {
        this.nama = JOptionPane.showInputDialog("Masukkan Nama Pelanggan:");
        this.menu = "";
        String inputJumlah = JOptionPane.showInputDialog("Masukkan Jumlah Makanan dan Minuman:");
        String selectedMenu = getFoodMenu() + ", " + getDrinkMenu();
        this.menu = selectedMenu;
        int inputFoodQuantity = 0;
        int inputDrinkQuantity = 0;
        try {
            this.jumlah = Integer.parseInt(inputJumlah);
            String[] quantityInputs = JOptionPane.showInputDialog("Masukkan Jumlah Makanan dan Minuman (pisahkan dengan spasi):").split(" ");
            inputFoodQuantity = Integer.parseInt(quantityInputs[0]);
            inputDrinkQuantity = Integer.parseInt(quantityInputs[1]);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Input Jumlah Pesanan atau Jumlah Makanan/Minuman Salah!");
        }

        double foodPrice = 0;
        double drinkPrice = 0;
        String selectedFood = "";
        String selectedDrink = "";
        int foodQuantity = 0;
        int drinkQuantity = 0;
        double foodTotalPrice = 0;
        double drinkTotalPrice = 0;


        String inputFoodPrice = JOptionPane.showInputDialog("Masukkan Harga Makanan per item:");
        try {
            foodPrice = Double.parseDouble(inputFoodPrice);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Input Harga Makanan Salah!");
        }
        try {
            foodQuantity = inputFoodQuantity;
            foodTotalPrice = foodPrice * foodQuantity;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Input Jumlah Makanan Salah!");
        }


        String inputDrinkPrice = JOptionPane.showInputDialog("Masukkan Harga Minuman per item:");
        try {
            drinkPrice = Double.parseDouble(inputDrinkPrice);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Input Harga Minuman Salah!");
        }
        try {
            drinkQuantity = inputDrinkQuantity;
            drinkTotalPrice = drinkPrice * drinkQuantity;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Input Jumlah Minuman Salah!");
        }

        this.hargaMakanan = foodTotalPrice;
        this.hargaMinuman = drinkTotalPrice;
        this.harga = foodTotalPrice + drinkTotalPrice;
    }

    public String getFoodMenu() {
        String[] foodMenu = {"Nasi Goreng", "Mie Goreng", "Brownies", "Waffle", "Pancong", "Cookies"};
        String selectedFood = (String) JOptionPane.showInputDialog(null, "Pilih menu makanan:",
                "Menu Makanan", JOptionPane.QUESTION_MESSAGE, null, foodMenu, foodMenu[0]);
        return selectedFood;
    }

    public String getDrinkMenu() {
        String[] drinkMenu = {"Kopi Susu Creamy", "Kopi Susu Strong", "Milk Tea", "Chocolate Milk", "Jus Alpukat", "STMJ"};
        String selectedDrink = (String) JOptionPane.showInputDialog(null, "Pilih menu minuman:",
                "Menu Minuman", JOptionPane.QUESTION_MESSAGE, null, drinkMenu, drinkMenu[0]);
        return selectedDrink;
    }

    public String getDeliveryMethod() {
        String[] deliveryMethods = {"Diantar ke Tempat", "Ambil Sendiri"};
        String selectedDelivery = (String) JOptionPane.showInputDialog(null, "Pilih metode pengiriman:",
                "Metode Pengiriman", JOptionPane.QUESTION_MESSAGE, null, deliveryMethods, deliveryMethods[0]);
        return selectedDelivery;
    }

    public String getPaymentMethod() {
    String[] paymentMethods = {"GoPay", "OVO", "Dana", "LinkAja"};
    String selectedPaymentMethod = (String) JOptionPane.showInputDialog(null, "Pilih metode pembayaran:",
            "Metode Pembayaran", JOptionPane.QUESTION_MESSAGE, null, paymentMethods, paymentMethods[0]);
        return selectedPaymentMethod;
    }

    public String getNama() {
        return nama;
    }

    public String getMenu() {
        return menu;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double getHarga() {
        return harga;
    }

    public double getHargaMakanan() {
        return hargaMakanan;
    }

    public double getHargaMinuman() {
        return hargaMinuman;
    }
}
