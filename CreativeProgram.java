import java.util.*;

public class CreativeProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat datang di program Kreatif!");
        System.out.println("Silakan masukkan nama Anda: ");
        String name = scanner.nextLine();

        System.out.println("Halo, " + name + "! Silakan pilih salah satu opsi:");
        System.out.println("1. Kalkulator");
        System.out.println("2. Permainan Tebak Angka");
        System.out.println("3. Pencetak Pola");
        System.out.println("4. Permainan Batu, Gunting, Kertas");
        System.out.println("5. Permainan Hangman");
        System.out.println("Pilihan: ");

        int option = scanner.nextInt();

        switch (option) {
            case 1:
                calculator();
                break;
            case 2:
                guessNumberGame();
                break;
            case 3:
                printPattern();
                break;
            case 4:
                rockPaperScissors();
                break;
            case 5:
                hangman();
                break;
            default:
                System.out.println("Opsi yang Anda pilih tidak valid.");
                break;
        }

        System.out.println("Terima kasih telah menggunakan program Kreatif!");
    }

    public static void calculator() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Kalkulator Sederhana");
        System.out.println("Silakan masukkan dua angka: ");
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();

        System.out.println("Silakan pilih operasi:");
        System.out.println("1. Penjumlahan");
        System.out.println("2. Pengurangan");
        System.out.println("3. Perkalian");
        System.out.println("4. Pembagian");
        System.out.println("Pilihan: ");

        int operation = scanner.nextInt();
        double result = 0;

        switch (operation) {
            case 1:
                result = num1 + num2;
                break;
            case 2:
                result = num1 - num2;
                break;
            case 3:
                result = num1 * num2;
                break;
            case 4:
                result = num1 / num2;
                break;
            default:
                System.out.println("Operasi yang Anda pilih tidak valid.");
                break;
        }

        System.out.println("Hasil: " + result);
    }

    public static void guessNumberGame() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Permainan Tebak Angka");
        int randomNumber = random.nextInt(100) + 1;
        int attempts = 0;
        boolean hasWon = false;

        System.out.println("Saya telah memilih angka antara 1 hingga 100. Coba tebak!");

        while (!hasWon) {
            int guess = scanner.nextInt();
            attempts++;

            if (guess == randomNumber) {
                hasWon = true;
                System.out.println("Selamat! Anda berhasil menebak angka tersebut dalam " + attempts + " percobaan.");
            } else if (guess < randomNumber) {
                System.out.println("Angka terlalu kecil. Coba lagi!");
            } else {
                System.out.println("Angka terlalu besar. Coba lagi!");
            }
        }
    }

    public static void printPattern() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Pencetak Pola");
        System.out.println("Masukkan jumlah baris pola: ");
        int rows = scanner.nextInt();

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void rockPaperScissors() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Permainan Batu, Gunting, Kertas");
        System.out.println("Silakan pilih:\n1. Batu\n2. Gunting\n3. Kertas");
        System.out.println("Pilihan: ");
        int playerChoice = scanner.nextInt();

        if (playerChoice < 1 || playerChoice > 3) {
            System.out.println("Pilihan yang Anda masukkan tidak valid.");
            return;
        }

        int computerChoice = random.nextInt(3) + 1;

        System.out.println("Pilihan Anda: " + getChoiceName(playerChoice));
        System.out.println("Pilihan Komputer: " + getChoiceName(computerChoice));

        if (playerChoice == computerChoice) {
            System.out.println("Hasil: Seri!");
        } else if ((playerChoice == 1 && computerChoice == 2) ||
                (playerChoice == 2 && computerChoice == 3) ||
                (playerChoice == 3 && computerChoice == 1)) {
            System.out.println("Hasil: Anda Menang!");
        } else {
            System.out.println("Hasil: Anda Kalah!");
        }
    }

    public static void hangman() {
        Scanner scanner = new Scanner(System.in);
        String[] words = {"apple", "banana", "chocolate", "dolphin", "elephant"};
        Random random = new Random();
        String word = words[random.nextInt(words.length)];
        int maxAttempts = 6;
        int attempts = 0;
        boolean[] guessedLetters = new boolean[word.length()];

        while (true) {
            System.out.print("Kata: ");
            for (int i = 0; i < word.length(); i++) {
                if (guessedLetters[i]) {
                    System.out.print(word.charAt(i) + " ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();

            System.out.println("Tebak huruf: ");
            char guess = scanner.next().charAt(0);

            boolean correctGuess = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    guessedLetters[i] = true;
                    correctGuess = true;
                }
            }

            if (!correctGuess) {
                attempts++;
                System.out.println("Salah! Anda memiliki " + (maxAttempts - attempts) + " kesempatan lagi.");
                if (attempts == maxAttempts) {
                    System.out.println("Anda kalah! Kata yang benar adalah: " + word);
                    break;
                }
            }

            boolean allGuessed = true;
            for (boolean guessed : guessedLetters) {
                if (!guessed) {
                    allGuessed = false;
                    break;
                }
            }

            if (allGuessed) {
                System.out.println("Selamat! Anda menang!");
                break;
            }
        }
    }

    public static String getChoiceName(int choice) {
        switch (choice) {
            case 1:
                return "Batu";
            case 2:
                return "Gunting";
            case 3:
                return "Kertas";
            default:
                return "";
        }
    }
}