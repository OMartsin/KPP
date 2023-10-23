package martsin.dev;

import martsin.dev.dinner.Dinner;
import martsin.dev.pizza.Pizza;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class PizzeriaConsolePrinter {

    public static void printMenu(List<Pizza> menu) {
        System.out.println("Menu:");
        menu.forEach(System.out::println);
    }

    public static void printDinners(List<Dinner> dinners) {
        System.out.println("Dinners:");
        dinners.forEach(System.out::println);
    }
    public static void printSortedDinnersByTime(List<Dinner> dinners) {
        System.out.println("Sorted Dinners by Delivery Time:");
        dinners.forEach(System.out::println);
    }

    public static void printSortedDinnersByPrice(List<Dinner> dinners) {
        System.out.println("Sorted Dinners by Price:");
        dinners.forEach(System.out::println);
    }

    public static void printDinnersByPizzaName(List<Dinner> dinners, String pizzaName){
        System.out.println("Dinners with " + pizzaName + ":");
        dinners.forEach(System.out::println);
    }

    public static void printDinnersWithMorePizzas(List<Dinner> dinners) {
        System.out.println("Dinners with More Pizzas:");
        dinners.forEach(System.out::println);
    }

    public static void printDinnerWithBiggestOrder(Dinner dinner) {
        System.out.println("Dinner with the Biggest Order:");
        System.out.println(dinner);
    }

    public static void printGroupedByPizza(Map<Pizza, List<Dinner>> pizzaMap) {
        System.out.println("Dinners Grouped by Pizza:");
        pizzaMap.forEach((pizza, dinnerList) -> {
            System.out.println(pizza.name() + " - ");
            printDinners(dinnerList);
        });
    }

    public static void printExpiresDinners(Map<Dinner, Duration> expiresDinnersMap) {
        System.out.println("Expired Dinners:");
        expiresDinnersMap.forEach((dinner, duration) -> {
            System.out.println(dinner + " - " + duration.toHours() + " hours ago");
        });
    }

    public static void printDinnersWithSpicyPizza(List<Dinner> dinners) {
        System.out.println("Dinners with Spicy Pizza:");
        dinners.forEach(System.out::println);
    }
}