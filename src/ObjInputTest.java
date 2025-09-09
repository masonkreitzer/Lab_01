/**
 * Manual test class for the SafeInputObj class.
 * This program prompts the user via the console and uses SafeInputObj
 * methods to demonstrate validated input for various data types.
 */
public class ObjInputTest {
    public static void main(String[] args) {
        SafeInputObj input = new SafeInputObj();

        // Test getNonZeroLenString
        String name = input.getNonZeroLenString("Enter your name");
        System.out.println("You entered: " + name);

        // Test getInt
        int age = input.getInt("Enter your age");
        System.out.println("You entered: " + age);

        // Test getRangedInt
        int choice = input.getRangedInt("Choose a number between 1 and 5", 1, 5);
        System.out.println("You chose: " + choice);

        // Test getDouble
        double price = input.getDouble("Enter the price of an item");
        System.out.println("Price entered: " + price);

        // Test getYNConfirm
        boolean confirm = input.getYNConfirm("Do you want to continue?");
        System.out.println("Your response: " + (confirm ? "Yes" : "No"));

        // Test getRangedDouble
        double rating = input.getRangedDouble("Enter a rating from 0.0 to 10.0", 0, 10);
        System.out.println("Rating entered: " + rating);

    }
}
