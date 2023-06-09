import javax.swing.*;

public class OutputUser {
    private InputUser input;

    public OutputUser(InputUser input) {
        this.input = input;
    }

    public void output(double hargaTotal, double totalPajak, double totalTip, boolean isPromoApplied, String selectedDelivery, String selectedPaymentMethod) {
        String output = "Terima kasih atas pesanan Anda.\n\n" +
                "Detail Pesanan:\n" +
                "Nama Pelanggan            : " + input.getNama() + "\n"
                + "Menu                                 : " + input.getMenu() + "\n"
                + "Jumlah Pesanan            : " + input.getJumlah() + "\n"
                + "Harga Item Makanan     : " + input.getHargaMakanan() + "\n"
                + "Harga Item Minuman     : " + input.getHargaMinuman() + "\n"
                + "Harga Total Item             : " + input.getHarga() + "\n"
                + "Pajak                                 : " + totalPajak + "\n"
                + "Tip                                      : " + totalTip + "\n"
                + "Total Harga                      : " + hargaTotal + "\n"
                + "Delivery                             : " + selectedDelivery + "\n"
                + "Metode Pembayaran     : " + selectedPaymentMethod + "\n\n" +
                "Pesanan Anda akan segera diproses.";

        if (isPromoApplied) {
            output += ("\n\nSelamat! Anda mendapatkan promo diskon sebesar 10%");
        }

        JOptionPane.showMessageDialog(null, output);
    }
}
