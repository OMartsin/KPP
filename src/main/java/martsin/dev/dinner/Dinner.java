package martsin.dev.dinner;

import martsin.dev.pizza.Pizza;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public record Dinner(String name, List<Pizza> order, String address, LocalDateTime deliveryDateTime)
        implements Serializable {
    public Dinner {
        if(order == null || order.isEmpty()) {
            throw new IllegalArgumentException("Order cannot be null or empty");
        }
    }

    public int getPrice() {
        return order.stream().mapToInt(Pizza::price).sum();
    }

    public int getWeight() {
        return order.stream().mapToInt(Pizza::weight).sum();
    }

    public boolean isSpicy() {
        return order.stream().anyMatch(Pizza::isSpicy);
    }

    @Override
    public String toString() {
        String orderString = order.stream().map(Pizza::name).reduce((a, b) -> a + ", " + b).orElse("");
        return String.format("%-10s | %-40s | %-5d UAH | %-20s | %s", name, orderString, getPrice(), address,
                deliveryDateTime.format(DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy"))
        );
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Dinner other) {
            return name.equals(other.name) && order.equals(other.order) &&
                    address.equals(other.address) && deliveryDateTime.equals(other.deliveryDateTime);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + order.hashCode() + address.hashCode() + deliveryDateTime.hashCode();
    }
}
