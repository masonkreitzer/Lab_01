import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Product class.
 */
public class ProductTest {

    private Product product;

    /**
     * Initializes a Product before each test.
     */
    @BeforeEach
    void setUp() {
        product = new Product("P001", "Widget", "A useful widget", 19.9);
    }

    /**
     * Tests the constructor for proper field initialization.
     */
    @Test
    void testConstructor() {
        assertEquals("P001", product.getId());
        assertEquals("Widget", product.getName());
        assertEquals("A useful widget", product.getDescription());
        assertEquals(19.9, product.getCost(), 0.001);
    }

    /**
     * Updates the product name using setName.
     */
    @Test
    void testSetName() {
        product.setName("Gadget");
        assertEquals("Gadget", product.getName());
    }

    /**
     * Updates the product description using setDescription.
     */
    @Test
    void testSetDescription() {
        product.setDescription("A cool new gadget");
        assertEquals("A cool new gadget", product.getDescription());
    }

    /**
     * Updates the product cost using setCost.
     */
    @Test
    void testSetCost() {
        product.setCost(29.9);
        assertEquals(29.9, product.getCost(), 0.001);
    }

    /**
     * Tests the toCSV method for correct formatting.
     */
    @Test
    void testToCSV() {
        String expected = "P001, Widget, A useful widget, 19.9";
        assertEquals(expected, product.toCSV());
    }

    /**
     * Tests the toJSON method for correct formatting.
     */
    @Test
    void testToJSON() {
        String expected = """
            {
                "id": "P001",
                "name": "Widget",
                "description": "A useful widget",
                "cost": 19.9
            }
            """;

        assertEquals(expected.trim(), product.toJSON().trim());
    }

    /**
     * Tests the toXML method for correct formatting.
     */
    @Test
    void testToXML() {
        String expected = """
            <Product>
                <ID>P001</ID>
                <Name>Widget</Name>
                <Description>A useful widget</Description>
                <Cost>19.9</Cost>
            </Product>
            """;

        assertEquals(expected.trim(), product.toXML().trim());
    }
}
