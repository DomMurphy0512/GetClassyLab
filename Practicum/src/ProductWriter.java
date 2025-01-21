import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> productRecords = new ArrayList<>();
        String fileName;

        System.out.println("Enter the name of the file to save (e.g., ProductTestData.txt): ");
        fileName = SafeInput.getNonZeroLenString(in, "File Name");

        boolean moreEntries = true;
        while (moreEntries) {
            String id = SafeInput.getNonZeroLenString(in, "Enter Product ID: ");
            String name = SafeInput.getNonZeroLenString(in, "Enter Product Name: ");
            String description = SafeInput.getNonZeroLenString(in, "Enter Product Description: ");
            double cost = SafeInput.getDouble(in, "Enter Product Cost (e.g., 100.0): ");

            productRecords.add(id + ", " + name + ", " + description + ", " + cost);

            moreEntries = SafeInput.getYNConfirm(in, "Do you want to add another product?");
        }

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (String record : productRecords) {
                fileWriter.write(record + "\n");
            }
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

