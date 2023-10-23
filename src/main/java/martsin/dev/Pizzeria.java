package martsin.dev;

import martsin.dev.dinner.Dinner;
import martsin.dev.dinner.DinnerFileReader;
import martsin.dev.pizza.Pizza;
import martsin.dev.pizza.PizzaFileReader;

import java.util.List;

public class Pizzeria {
    private final List<Dinner> dinnerList;
    private final List<Pizza> menu;

    public Pizzeria(String dinnerPath, String menuPath) {
        menu = PizzaFileReader.getPizzaList(menuPath);
        dinnerList = DinnerFileReader.getDinnerList(dinnerPath, menu);
    }

    public List<Dinner> getDinnerList() {
        return dinnerList;
    }

    public List<Pizza> getMenu() {
        return menu;
    }
}
