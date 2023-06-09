public class Calculator {

    double findTotal(double harga, int jumlah, double pajak, double tip, boolean isPromoApplied, double promoDiscount) {
        if (isPromoApplied) {
            double total = harga * (1 + pajak + tip) - promoDiscount;
            return total;
        } else {
            double total = harga * (1 + pajak + tip);
            return total;
        }
    }

    double findTax(double harga, double pajak) {
        return (harga * (1 + pajak) - harga);
    }

    double findTip(double harga, double tip) {
        return (harga * (1 + tip) - harga);
    }
}