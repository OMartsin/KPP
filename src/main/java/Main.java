import java.util.List;

public class Main {
    public static void main(String[] args){
        List<List<String>> sentences;
        try{
            sentences = FileScannerUtil.getStringArrayFromFile(
                    "C:\\Users\\Alex\\IdeaProjects\\KPP\\src\\main\\resources\\test4.txt");
        }
        catch (RuntimeException e){
            e.printStackTrace();
            return;
        }
        SentencesHandler handler = new SentencesHandler(sentences);
        ConsolePrintUtil.PrintText(sentences);
        ConsolePrintUtil.PrintEmailMap(handler.getEmailList());
        ConsolePrintUtil.PrintText(handler.getTextWithEmailSentences());
        System.out.println(EmailValidator.isValidEmail("example@email.com"));  // true
        System.out.println(EmailValidator.isValidEmail("not_an_email@df"));

    }
}
