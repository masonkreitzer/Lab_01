import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import java.io.StringReader;

/**
 * Unit tests for the SafeInputObj class.
 * These tests use a StringReader to simulate user input without manual typing.
 */
public class SafeInputObjTest {

    @Test
    public void testGetNonZeroLenString() {

        // simulate user entering empty line, then "Hello"
        Scanner sc = new Scanner(new StringReader("\nHello\n"));
        SafeInputObj sio = new SafeInputObj(sc);
        String result = sio.getNonZeroLenString("Enter a string");
        assertEquals("Hello", result);
    }

    @Test
    public void testGetIntValid() {

        // Simulate user entering a valid integer "42"
        Scanner sc = new Scanner(new StringReader("42\n"));
        SafeInputObj sio = new SafeInputObj(sc);
        int val = sio.getInt("Enter an int");
        assertEquals(42, val);
    }

    @Test
    public void testGetIntInvalidThenValid() {

        // Simulate user entering "abc" (invalid), then "100" (valid)
        Scanner sc = new Scanner(new StringReader("abc\n100\n"));
        SafeInputObj sio = new SafeInputObj(sc);
        int val = sio.getInt("Enter an int");
        assertEquals(100, val);
    }

    @Test
    public void testGetRangedInt() {

        // Simulate user entering "5", which is within the range 1-10
        Scanner sc = new Scanner(new StringReader("5\n"));
        SafeInputObj sio = new SafeInputObj(sc);
        int val = sio.getRangedInt("Enter number 1-10", 1, 10);
        assertEquals(5, val);
    }

    @Test
    public void testGetRangedIntOutOfRangeThenValid() {

        // Simulate user entering "15" (out of range), then "7" (valid)
        Scanner sc = new Scanner(new StringReader("15\n7\n"));
        SafeInputObj sio = new SafeInputObj(sc);
        int val = sio.getRangedInt("Enter number 1-10", 1, 10);
        assertEquals(7, val);
    }

    @Test
    public void testGetDoubleValid() {

        // Simulate user entering a valid double "3.14"
        Scanner sc = new Scanner(new StringReader("3.14\n"));
        SafeInputObj sio = new SafeInputObj(sc);
        double val = sio.getDouble("Enter a double");
        assertEquals(3.14, val, 0.0001);
    }

    @Test
    public void testGetYNConfirmYes() {

        // Simulate user entering "Y"
        Scanner sc = new Scanner(new StringReader("Y\n"));
        SafeInputObj sio = new SafeInputObj(sc);
        assertTrue(sio.getYNConfirm("Continue?"));
    }

    @Test
    public void testGetYNConfirmNo() {

        // Simulate user entering "N"
        Scanner sc = new Scanner(new StringReader("N\n"));
        SafeInputObj sio = new SafeInputObj(sc);
        assertFalse(sio.getYNConfirm("Continue?"));
    }
}
