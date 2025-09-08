import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        System.out.println("Product Generator - Enter product data");

        boolean addMore = true;

        while (addMore) {

            // Gets inputs with validation
            String id = SafeInput.getNonZeroLenString(scanner, "Enter Product ID");
            String name = SafeInput.getNonZeroLenString(scanner, "Enter Product Name");
            String description = SafeInput.getNonZeroLenString(scanner, "Enter Product Description");
            double cost = SafeInput.getDouble(scanner, "Enter Product Cost");

            // Uses product class
            Product p = new Product(id, name, description, cost);
            products.add(p);

            addMore = SafeInput.getYNConfirm(scanner, "Do you want to add another product?");
        }

        // Asks for filename to save
        String fileName = SafeInput.getNonZeroLenString(scanner, "Enter file name to save");

        // Saves to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Product p : products) {
                writer.write(p.toCSV());
                writer.newLine();
            }
            System.out.println("Products saved successfully to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        scanner.close();
    }
}
