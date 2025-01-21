import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> personRecords = new ArrayList<>();
        String fileName;

        System.out.println("Enter the name of the file to save (e.g., PersonTestData.txt): ");
        fileName = SafeInput.getNonZeroLenString(in, "File Name");

        boolean moreEntries = true;
        while (moreEntries) {
            String id = SafeInput.getNonZeroLenString(in, "Enter ID (String): ");
            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name: ");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name: ");
            String title = SafeInput.getNonZeroLenString(in, "Enter Title (e.g., Mr., Mrs.): ");
            int yearOfBirth = SafeInput.getInt(in, "Enter Year of Birth (e.g., 1980): ");

            personRecords.add(id + ", " + firstName + ", " + lastName + ", " + title + ", " + yearOfBirth);

            moreEntries = SafeInput.getYNConfirm(in, "Do you want to add another person?");
        }

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (String record : personRecords) {
                fileWriter.write(record + "\n");
            }
            System.out.println("Data saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
