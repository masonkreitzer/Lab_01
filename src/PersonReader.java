import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * PersonReader reads a CSV file of Person data,
 * creates Person objects from each line,
 * stores them in an ArrayList, and displays them in a formatted table.
 * Uses JFileChooser for file selection and SafeInput for confirmation.
 */
public class PersonReader {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a person data file");

        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            System.out.println("Selected file: " + filePath);

            boolean confirm = SafeInput.getYNConfirm(scanner, "Do you want to load this file");

            if (!confirm) {
                System.out.println("File loading cancelled.");
                scanner.close();
                return;
            }

            // Creates an ArrayList to hold Person objects
            ArrayList<Person> people = new ArrayList<>();

            //Reads and populates the list
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");

                    if (parts.length == 5) {
                        String id = parts[0].trim();
                        String firstName = parts[1].trim();
                        String lastName = parts[2].trim();
                        String title = parts[3].trim();
                        int yearOfBirth = Integer.parseInt(parts[4].trim());

                        // Creates Person object and add to list
                        Person person = new Person(id, firstName, lastName, title, yearOfBirth);
                        people.add(person);
                    } else {
                        System.out.println("Invalid line format: " + line);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid year format in file: " + e.getMessage());
            }

            // Displays the data from the ArrayList<Person>
            System.out.println();
            System.out.printf("%-7s %-12s %-12s %-8s %-4s\n", "ID#", "First Name", "Last Name", "Title", "YOB");
            System.out.println("======================================================");
            for (Person p : people) {
                System.out.printf("%-7s %-12s %-12s %-8s %-4d\n",
                        p.getId(),
                        p.getFirstName(),
                        p.getLastName(),
                        p.getTitle(),
                        p.getYearOfBirth());
            }

        } else {
            System.out.println("No file was selected.");
        }

        scanner.close();
    }
}
