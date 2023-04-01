package coba;

    public class Chickens01 {
        public static void main(String[] args) {
            int eggsPerChicken1, eggsPerChicken2, chickenCount1, chickenCount2;
            // MONDAY
            eggsPerChicken1 = 5;
            eggsPerChicken2 = 4;
            chickenCount1 = 3;
            chickenCount2 = 8;

            // TUESDAY
            chickenCount1++;
            chickenCount2++;

            // WEDNESDAY
            chickenCount1 /= 2;
            chickenCount2 /= 2;


            int totalEggs = eggsPerChicken1 * (chickenCount1 + chickenCount1 / 2);
            int totalEggs1 = eggsPerChicken2 * (chickenCount2 + chickenCount2 / 2);
            System.out.println("Total eggs collected between Monday and Wednesday with 3 chickens and 5 eggs/chicken: " + totalEggs);
            System.out.println("Total eggs collected between Monday and Wednesday with 8 chickens and 4 eggs/chicken: " + totalEggs1);
        }
    }
