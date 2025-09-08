import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductReader {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Use JFileChooser to pick the file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a product data file");

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            System.out.println("Selected file: " + filePath);

            // Confirm loading the file
            boolean confirm = SafeInput.getYNConfirm(scanner, "Do you want to load this file?");
            if (!confirm) {
                System.out.println("File loading cancelled.");
                scanner.close();
                return;
            }

            ArrayList<Product> products = new ArrayList<>();

            // Read file and create Product objects
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");

                    if (parts.length == 4) {
                        String id = parts[0].trim();
                        String name = parts[1].trim();
                        String description = parts[2].trim();
                        double cost = Double.parseDouble(parts[3].trim());

                        // Create a Product object
                        Product product = new Product(id, name, description, cost);
                        products.add(product);
                    } else {
                        System.out.println("Invalid line format: " + line);
                    }
                }

            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
                scanner.close();
                return;
            } catch (NumberFormatException e) {
                System.out.println("Invalid cost format: " + e.getMessage());
                scanner.close();
                return;
            }

            // Prints the column headers
            System.out.printf("\n%-8s %-12s %-30s %s\n", "ID", "Name", "Description", "Cost");
            System.out.println("======================================================");

            for (Product p : products) {
                // You can choose how to display - using toCSV or a formatted print
                System.out.printf("%-8s %-12s %-30s %.1f\n", p.getId(), p.getName(), p.getDescription(), p.getCost());
            }

        } else {
            System.out.println("No file was selected.");
        }

        scanner.close();
    }
}