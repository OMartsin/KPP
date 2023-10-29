package martsin.dev;

import martsin.dev.pizza.Pizza;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class PizzeriaSerializer {
    public static void serializeCollection(List<Pizza> pizzaList){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Alex\\IdeaProjects\\KPP" +
                    "\\src\\main\\resources\\testPizzas.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(pizzaList);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Serialized data is saved in testPizzas.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
