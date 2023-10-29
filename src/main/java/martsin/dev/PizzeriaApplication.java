package martsin.dev;

import java.util.Scanner;

public class PizzeriaApplication {
    private static final String DINNER_PATH = "C:\\Users\\Alex\\IdeaProjects\\KPP\\src\\main\\resources\\testDinners.txt";
    private static final String MENU_PATH = "C:\\Users\\Alex\\IdeaProjects\\KPP\\src\\main\\resources\\testMenu.txt";
    public static void run(){
        PizzeriaProcessor processor = new PizzeriaProcessor(DINNER_PATH, MENU_PATH);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Pizzeria Menu:");
            System.out.println("1. View Dinners and Menu");
            System.out.println("2. View Dinners Sorted by Delivery Time");
            System.out.println("3. View Dinners Sorted by Price");
            System.out.println("4. View Dinners with More Pizzas Than");
            System.out.println("5. View Dinner with the Biggest Order");
            System.out.println("6. View Dinners Grouped by Pizza");
            System.out.println("7. View Expired Dinners");
            System.out.println("8. View Dinners with Pizza");
            System.out.println("9. View Dinners with Spicy Pizza");
            System.out.println("11. Serialize pizzas collection");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // to consume the \n character

            switch (choice) {
                case 1 -> {
                    PizzeriaConsolePrinter.printMenu(processor.getMenu());
                    PizzeriaConsolePrinter.printDinners(processor.getDinnerList());
                }
                case 2 -> PizzeriaConsolePrinter.printSortedDinnersByTime(processor.getSortedByTimeDinnerList());
                case 3 -> PizzeriaConsolePrinter.printSortedDinnersByPrice(processor.getSortedByPriceDinnerList());
                case 4 -> {
                    System.out.print("Enter the number of pizzas: ");
                    int numPizzas = scanner.nextInt();
                    while (numPizzas < 1){
                        System.out.println("Number of pizzas cannot be less than 1");
                        System.out.print("Enter the number of pizzas: ");
                        numPizzas = scanner.nextInt();
                    }
                    PizzeriaConsolePrinter.printDinnersWithMorePizzas(processor.getDinnersHavingMorePizzasThat(numPizzas));
                }
                case 5 -> PizzeriaConsolePrinter.printDinnerWithBiggestOrder(processor.getDinnerWithBiggestOrder());
                case 6 -> PizzeriaConsolePrinter.printGroupedByPizza(processor.getGroupByPizzaMap());
                case 7 -> PizzeriaConsolePrinter.printExpiresDinners(processor.getExpiresDinnersMap());
                case 8 -> {
                    System.out.print("Enter the name of pizza: ");
                    String pizzaName = scanner.nextLine();
                    if(processor.getDinnersByPizzaName(pizzaName).isEmpty()){
                        System.out.println("There is no pizza with such name");
                        break;
                    }
                    PizzeriaConsolePrinter.printDinnersByPizzaName(processor.getDinnersByPizzaName(pizzaName), pizzaName);
                }
                case 9 -> PizzeriaConsolePrinter.printDinnersWithSpicyPizza(processor.getDinnersWithSpicyPizza());
                case 11 -> processor.serializeCollection();
                case 0 -> {
                    System.out.println("Exiting the Pizzeria Menu. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
