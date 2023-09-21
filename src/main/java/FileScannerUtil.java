import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileScannerUtil {
    public static List<List<String>> getStringArrayFromFile(String filename) {
        File file = new File(filename);
        List<List<String>> sentences = new LinkedList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                Scanner innerScanner = new Scanner(scanner.nextLine());
                List<String> words = new LinkedList<>();
                while (innerScanner.hasNext()) {
                    words.add(innerScanner.next());
                }
                sentences.add(words);
                innerScanner.close();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return sentences;
    }

}
