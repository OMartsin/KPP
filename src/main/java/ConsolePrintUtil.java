import java.util.List;
import java.util.Map;

public class ConsolePrintUtil {
    public static void PrintText(List<List<String>> text) {
        for (List<String> sentence: text
             ) {
            for (String word: sentence){
                System.out.print(word+" ");
            }
            System.out.println();
        }
    }
    public static void PrintEmailMap(Map<String,String> emails){
        for(Map.Entry<String, String> entry : emails.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
