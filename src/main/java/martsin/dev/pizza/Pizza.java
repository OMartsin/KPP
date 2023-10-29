package martsin.dev.pizza;

import java.io.Serializable;
import java.util.List;

public record Pizza (String name, int weight, int price, List<String> toppings, boolean isSpicy)
implements Serializable {
    public Pizza {
        if (weight < 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if(toppings == null || toppings.isEmpty()) {
            throw new IllegalArgumentException("Toppings cannot be null or empty");
        }
    }

    @Override
    public String toString() {
        String toppingsString = String.join(", ", toppings);
        String spiciness = isSpicy ? "spicy" : "not spicy";
        return String.format("%-20s | %-5d g | %-5d UAH | %-30s | %s",
                name, weight, price, toppingsString, spiciness);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pizza other) {
            return name.equals(other.name) && weight == other.weight &&
                    price == other.price && toppings.equals(other.toppings) && isSpicy == other.isSpicy;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + weight + price + toppings.hashCode() + (isSpicy ? 1 : 0);
    }
}
