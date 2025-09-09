import java.util.Scanner;

/**
 * A reusable console input helper object that wraps input validation
 * methods using an internal Scanner instance called `pipe`.
 */
public class SafeInputObj {

    private final Scanner pipe;

    /**
     * Default constructor using System.in as the input source.
     */
    public SafeInputObj() {
        this.pipe = new Scanner(System.in);
    }

    /**
     * Constructor that allows using a custom Scanner.
     *
     * @param scanner A Scanner instance to use.
     */
    public SafeInputObj(Scanner scanner) {
        this.pipe = scanner;
    }

    /**
     * Get a non-empty string from the user.
     *
     * @param prompt Prompt for the user.
     * @return A non-empty String.
     */
    public String getNonZeroLenString(String prompt) {
        String retString;
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.isEmpty());
        return retString;
    }

    /**
     * Get an int value within a specified range.
     *
     * @param prompt Prompt for the user.
     * @param low    Inclusive lower bound.
     * @param high   Inclusive upper bound.
     * @return An int within the range.
     */
    public int getRangedInt(String prompt, int low, int high) {
        int retVal = 0;
        String trash;
        boolean done = false;
        do {
            System.out.print("\n" + prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("Number is out of range: " + retVal);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter an int: " + trash);
            }
        } while (!done);
        return retVal;
    }

    /**
     * Get an int with no range constraints.
     *
     * @param prompt Prompt for the user.
     * @return Any valid int.
     */
    public int getInt(String prompt) {
        int retVal = 0;
        String trash;
        boolean done = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter an int: " + trash);
            }
        } while (!done);
        return retVal;
    }

    /**
     * Get a double within a specific inclusive range.
     *
     * @param prompt Prompt for the user.
     * @param low    Inclusive lower bound.
     * @param high   Inclusive upper bound.
     * @return A double in range.
     */
    public double getRangedDouble(String prompt, double low, double high) {
        double retVal = 0;
        String trash;
        boolean done = false;
        do {
            System.out.print("\n" + prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("Number is out of range: " + retVal);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }
        } while (!done);
        return retVal;
    }

    /**
     * Get a double with no constraints.
     *
     * @param prompt Prompt for the user.
     * @return Any valid double.
     */
    public double getDouble(String prompt) {
        double retVal = 0;
        String trash;
        boolean done = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter a double: " + trash);
            }
        } while (!done);
        return retVal;
    }

    /**
     * Get a yes/no confirmation.
     *
     * @param prompt Prompt for the user.
     * @return true if user enters 'Y', false if 'N'.
     */
    public boolean getYNConfirm(String prompt) {
        boolean retVal = false;
        String response;
        boolean gotAVal = false;
        do {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine();
            if (response.equalsIgnoreCase("Y")) {
                gotAVal = true;
                retVal = true;
            } else if (response.equalsIgnoreCase("N")) {
                gotAVal = true;
                retVal = false;
            } else {
                System.out.println("You must enter [Y/N]: " + response);
            }
        } while (!gotAVal);
        return retVal;
    }
}