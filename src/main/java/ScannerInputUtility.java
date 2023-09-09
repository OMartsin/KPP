import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerInputUtility {
    public int getNumOfIterations(){
        System.out.print("Enter the number of iterations: ");
        Scanner scanner = new Scanner(System.in);
        int count;

        while(true){
            try {
                count = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("You entered an incorrect character, please try again:");
                scanner.next();
            }
        }
        return count;
    }
}
