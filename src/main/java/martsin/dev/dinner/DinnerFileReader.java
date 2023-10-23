package martsin.dev.dinner;

import martsin.dev.pizza.Pizza;

import java.io.BufferedReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DinnerFileReader {
    public static List<Dinner> getDinnerList(String path, List<Pizza> menu) {
        List<Dinner> dinnerList = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new java.io.FileReader(path))){
            String line;
            while((line = reader.readLine()) != null){
                Scanner scanner = new Scanner(line);
                scanner.useDelimiter(";");
                String name = scanner.next();
                List<Pizza> order = new ArrayList<>(){
                    {
                        String[] pizzas = scanner.next().split(",");
                        for (String pizzaName : pizzas) {
                            Pizza pizza = menu.stream().filter(p -> p.name().equals(pizzaName)).
                                    findFirst().orElseThrow();

                            add(pizza);
                        }
                    }
                };
                String address = scanner.next();
                LocalDateTime dateTime = LocalDateTime.parse(scanner.next());
                Dinner dinner = new Dinner(name, order, address, dateTime);
                dinnerList.add(dinner);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dinnerList;
    }
}
