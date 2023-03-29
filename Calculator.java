public class Calculator {
    public static void main(String[] args){
        System.out.println("hasil penjumlahan ="+penjumlahan(2,3));
        System.out.println("hasil pengurangan ="+pengurangan(2,3));
        System.out.println("hasil perkalian ="+perkalian(2,3));
        System.out.println("hasil pembagian ="+pembagian(2,3));
    }
    static int penjumlahan(int var1, int var2){
        return (var1 + var2);
    }
    static int pengurangan(int var1, int var2){
        return (var1 - var2);
    }
    static int perkalian(int var1, int var2){
        return (var1 * var2);
    }
    static double pembagian(double var1, double var2){
        return (var1 / var2);
    }
}
