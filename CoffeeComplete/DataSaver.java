package CoffeeComplete;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataSaver {
    public static void main(String[] args) {
        String data = "Data yang ingin disimpan";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("customerdata.txt", true))) {
            writer.write(data);
            writer.newLine();
            System.out.println("Data berhasil disimpan ke customerdata.txt.");
        } catch (IOException e) {
            System.err.println("Terjadi kesalahan saat menyimpan data ke file: " + e.getMessage());
        }
    }
}
