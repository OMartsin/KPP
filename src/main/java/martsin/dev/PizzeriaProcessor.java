package martsin.dev;

import martsin.dev.dinner.Dinner;
import martsin.dev.pizza.Pizza;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PizzeriaProcessor {
    private final Pizzeria pizzeria;

    public PizzeriaProcessor(String dinnerPath, String menuPath) {
        pizzeria = new Pizzeria(dinnerPath, menuPath);
    }

    public List<Pizza> getMenu() {
        return pizzeria.getMenu();
    }

    public List<Dinner> getDinnerList() {
        return pizzeria.getDinnerList();
    }

    public List<Dinner> getSortedByTimeDinnerList() {
        return pizzeria.getDinnerList().stream().sorted(Comparator.comparing(Dinner::deliveryDateTime)).toList();
    }

    public List<Dinner> getSortedByPriceDinnerList() {
        return pizzeria.getDinnerList().stream().sorted(Comparator.comparing(Dinner::getPrice)).toList();
    }

    public List<Dinner> getDinnersByPizzaName(String pizzaName) {
        return pizzeria.getDinnerList().stream().filter
                (dinner -> dinner.order().stream().anyMatch(pizza -> pizza.name().equals(pizzaName))).toList();
    }

    public List<Dinner> getDinnersHavingMorePizzasThat(int num){
        return pizzeria.getDinnerList().stream().filter(dinner -> dinner.order().size() > num).toList();
    }

    public Dinner getDinnerWithBiggestOrder() {
        return pizzeria.getDinnerList().stream().max(Comparator.comparing(Dinner::getPrice)).get();
    }

    public Map<Pizza,List<Dinner>> getGroupByPizzaMap(){
        return pizzeria.getDinnerList().stream().flatMap(dinner -> dinner.order().stream().
                map(pizza -> Map.entry(pizza, dinner))).collect(
                        java.util.stream.Collectors.groupingBy(Map.Entry::getKey,
                                java.util.stream.Collectors.mapping(Map.Entry::getValue,
                                        java.util.stream.Collectors.toList())));
    }

    public Map<Dinner, Duration> getExpiresDinnersMap(){
        return pizzeria.getDinnerList().stream().filter(dinner ->
                dinner.deliveryDateTime().isBefore(LocalDateTime.now())).collect(Collectors.toMap(
                dinner -> dinner,
                dinner -> Duration.between(dinner.deliveryDateTime(), LocalDateTime.now())));
    }

    public List<Dinner> getDinnersWithSpicyPizza(){
        return pizzeria.getDinnerList().stream().filter(Dinner::isSpicy).toList();
    }
}
