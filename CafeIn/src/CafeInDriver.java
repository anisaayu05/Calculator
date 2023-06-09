import java.util.Random;

public class CafeInDriver {
    public static void main(String[] args) {
        double pajak = 0.05;
        double tip = 0.15;
        boolean isPromoApplied = false;
        double promo = 0.1;

        InputUser input = new InputUser();
        Calculator calc = new Calculator();
        OutputUser output = new OutputUser(input);
        Random rand = new Random();

        input.inputDataGUI();

        double promoDiscount = 0;
        double hargaTotal = calc.findTotal(input.getHarga(), input.getJumlah(), pajak, tip, isPromoApplied, promoDiscount);
        double totalPajak = calc.findTax(input.getHarga(), pajak);
        double totalTip = calc.findTip(input.getHarga(), tip);


        int promoChance = rand.nextInt(100) + 1;
        if (promoChance <= 50) { // 50% chance of getting promo
            promoDiscount = promo;
            promoDiscount = hargaTotal * 0.1;
            hargaTotal -= promoDiscount;
            isPromoApplied = true;
        }

        String selectedPaymentMethod = input.getPaymentMethod();
        String selectedDelivery = input.getDeliveryMethod();
        output.output(hargaTotal, totalPajak, totalTip, isPromoApplied, selectedDelivery, selectedPaymentMethod);
    }
}