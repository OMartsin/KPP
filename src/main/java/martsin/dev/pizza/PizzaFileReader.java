package martsin.dev.pizza;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PizzaFileReader {
    public static List<Pizza> getPizzaList(String path){
        List<Pizza> pizzaList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new java.io.FileReader(path))){
            String line;
            while((line = reader.readLine()) != null){
                Scanner scanner = new Scanner(line);
                scanner.useDelimiter(";");
                String name = scanner.next();
                int weight = scanner.nextInt();
                int price = scanner.nextInt();
                List<String> toppings = List.of(scanner.next().split(","));
                boolean isSpicy = scanner.nextBoolean();
                Pizza pizza = new Pizza(name, weight, price, toppings, isSpicy);
                pizzaList.add(pizza);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pizzaList;
    }
}
