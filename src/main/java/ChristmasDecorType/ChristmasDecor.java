package ChristmasDecorType;

public class ChristmasDecor {
    private final int id;
    private String name;
    private DecorationType type;
    private float price;
    private Location location;

    public ChristmasDecor(int id, String name, DecorationType type, float price, Location location) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DecorationType getType() {
        return type;
    }

    public void setType(DecorationType type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    @Override
    public String toString() {
        String idStr = String.format("%-5d", id); // Left-align, 5 characters wide
        String nameStr = String.format("%-30s", name); // Left-align, 15 characters wide
        String typeStr = String.format("%-20s", type.getTypeName()); // Left-align, 20 characters wide
        String priceStr = String.format("%-10.2f", price); // Left-align, 10 characters wide, 2 decimal places
        String locationStr = String.format("%-15s", location.getLocationName()); // Left-align, 15 characters wide

        return String.format("%s | %s | %s | %s | %s", idStr, nameStr, typeStr, priceStr, locationStr);
    }
}
