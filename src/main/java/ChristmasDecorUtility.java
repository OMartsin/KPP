import ChristmasDecorType.ChristmasDecor;
import ChristmasDecorType.DecorationType;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ChristmasDecorUtility {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Christmas Decoration Utility!");
        int numberOfDecorations = 0;
        while (numberOfDecorations <= 0) {
            System.out.print("Enter the number of decorations (must be a positive integer): ");
            if (scanner.hasNextInt()) {
                numberOfDecorations = scanner.nextInt();
                if (numberOfDecorations <= 0) {
                    System.out.println("Please enter a positive integer.");
                }
            } else {
                System.out.println("Invalid input. Please enter a positive integer.");
                scanner.next(); // Consume the invalid input
            }
        }
        scanner.nextLine();
        ChristmasDecorManager decorManager = new ChristmasDecorManager(numberOfDecorations);

        chooseOperation(scanner,decorManager);

    }

    private static void chooseOperation(Scanner scanner, ChristmasDecorManager decorManager){
        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Sort Christmas Decorations");
            System.out.println("2. Find Christmas Decorations by Type");
            System.out.println("3. View All Decorations");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1/2/3/4): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> performSorting(scanner, decorManager);
                case 2 -> performFinding(scanner, decorManager);
                case 3 -> viewAllDecorations(decorManager.getDecorations());
                case 4 -> {
                    System.out.println("Goodbye!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please enter 1, 2, 3, or 4.");
            }
        }
    }

    private static void performSorting(Scanner scanner, ChristmasDecorManager decorManager) {
        System.out.println("\nSorting Options:");
        System.out.println("1. Sort by Name");
        System.out.println("2. Sort by Type");
        System.out.println("3. Sort by Location");
        System.out.println("4. Sort by Price");
        System.out.print("Enter your sorting choices (e.g., '1 2 4' for Name, Type, and Price): ");
        String sortingChoices = scanner.nextLine();

        System.out.print("Do you want to reverse the sorting order? (yes/no): ");
        boolean reverse = scanner.nextLine().equalsIgnoreCase("yes");

        String[] sortingChoiceArray = sortingChoices.split(" ");
        Arrays.sort(sortingChoiceArray);
        int[] chosenSortingChoices = new int[sortingChoiceArray.length];
        for (int i = 0; i < sortingChoiceArray.length; i++) {
            chosenSortingChoices[i] = Integer.parseInt(sortingChoiceArray[i]);
        }
        decorManager.sortDecorations(chosenSortingChoices,reverse);
        System.out.println("\nSorted Christmas Decorations:");
        viewAllDecorations(decorManager.getDecorations());
    }


    private static void performFinding(Scanner scanner, ChristmasDecorManager decorManager) {
        System.out.println("\nAvailable Types of Decorations:");
        String[] availableTypes = Arrays.stream(ChristmasDecorGenerator.decorTypes)
                .map(DecorationType::getTypeName)
                .toArray(String[]::new);
        for (int i = 0; i < availableTypes.length; i++) {
            System.out.println((i + 1) + ". " + availableTypes[i]);
        }

        System.out.print("Enter the type(s) of Christmas decorations to find (' ' separated): ");
        String typeInput = scanner.nextLine();
        String[] typeIndices = typeInput.split(" ");
        Set<Integer> selectedIndices = Arrays.stream(typeIndices)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        System.out.println("\nMatching Christmas Decorations by Type:");
        viewAllDecorations(decorManager.findDecorationsByType(selectedIndices));
    }

    private static void viewAllDecorations(ChristmasDecor[] decors) {
        System.out.println("\nAll Christmas Decorations:");
        System.out.println("ID    | Name                           | Type                 | Price      | Location");
        System.out.println("-------------------------------------------------------------------------------------------------");
        for (ChristmasDecor decor : decors) {
            System.out.println(decor);
        }
    }
}
