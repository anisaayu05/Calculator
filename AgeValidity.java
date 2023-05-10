import java.util.Scanner;

public class AgeValidity {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = input.nextInt();

        boolean checkDrivingUnderAge = false;
        if (age <= 18) {
            checkDrivingUnderAge = true;
        }

        System.out.println("Driving under age: " + checkDrivingUnderAge);
        validateAge(age);
    }

    public static void validateAge(int age) {
        if (age >= 18) {
            System.out.println("Umur anda cukup untuk mengemudi");
        } else {
            System.out.println("Umur anda tidak cukup untuk mengemudi");
        }
    }
}

