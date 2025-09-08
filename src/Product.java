/**
 * Represents a product with an ID, name, description, and cost.
 */
public class Product {
    private final String id;
    private String name;
    private String description;
    private double cost;

    /**
     * Constructs a Product object.
     *
     * @param id The product ID (unchangeable).
     * @param name The name of the product.
     * @param description The description of the product.
     * @param cost The cost of the product.
     */
    public Product(String id, String name, String description, double cost) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    /**
     * Converts the product to a CSV format.
     *
     * @return CSV formatted string.
     */
    public String toCSV() {
        return String.format("%s, %s, %s, %.1f", id, name, description, cost);
    }

    /**
     * Converts the product to a JSON format.
     *
     * @return JSON formatted string.
     */
    public String toJSON() {
        return String.format("""
            {
                "id": "%s",
                "name": "%s",
                "description": "%s",
                "cost": %.1f
            }
            """, id, name, description, cost);
    }

    /**
     * Converts the product to an XML format.
     *
     * @return XML formatted string.
     */
    public String toXML() {
        return String.format("""
            <Product>
                <ID>%s</ID>
                <Name>%s</Name>
                <Description>%s</Description>
                <Cost>%.1f</Cost>
            </Product>
            """, id, name, description, cost);
    }

    /**
     * Returns a string representation of the product.
     *
     * @return Formatted string.
     */
    @Override
    public String toString() {
        return toCSV();
    }
}
