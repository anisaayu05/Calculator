import java.util.Scanner;

public class WatchMovie {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan harga film: ");
        double moviePrice = input.nextDouble();

        System.out.print("Masukkan rating film: ");
        int movieRating = input.nextInt();

        if (canWatchMovie(moviePrice, movieRating)) {
            System.out.println("I'm interested in watching the movie");
        } else {
            System.out.println("I am not interested in watching the movie");
        }
    }

    public static boolean canWatchMovie(double price, int rating) {
        return price >= 12 && rating==5;
    }

    public static String checkMovie(int price, int rating) {
        if (price >= 12 && rating==5) {
            return "Harga film tidak valid";
        } else if (rating < 1 || rating > 5) {
            return "Rating film tidak valid";
        } else if (canWatchMovie(price, rating)) {
            return "I'm interested in watching the movie";
        } else {
            return "I am not interested in watching the movie";
        }
    }
}