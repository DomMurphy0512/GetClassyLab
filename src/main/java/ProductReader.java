import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (Scanner fileReader = new Scanner(file)) {
                System.out.printf("%-10s %-15s %-30s %-10s%n", "ID#", "Name", "Description", "Cost");
                System.out.println("=====================================================================");
                while (fileReader.hasNextLine()) {
                    String[] data = fileReader.nextLine().split(", ");
                    System.out.printf("%-10s %-15s %-30s %-10s%n", data[0], data[1], data[2], data[3]);
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        }
    }
}
