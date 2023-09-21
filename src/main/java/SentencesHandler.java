import java.util.*;

public class SentencesHandler {
    List<List<String>> sentences;

    public SentencesHandler(List<List<String>> sentences) {
        this.sentences = sentences;
    }

    public List<List<String>> getSentences() {
        return sentences;
    }

    public void setSentences(List<List<String>> sentences) {
        this.sentences = sentences;
    }

    public Map<String,String> getEmailList(){
        Map<String,String> emailAndCandidates = new HashMap<>();
        for (List<String> sentence : sentences
             ) {
            for (String word:sentence
                 ) {
                if(word.contains("@")){
                    if(EmailValidator.isValidEmail(word)){
                        emailAndCandidates.put(word,"Valid");
                    }
                    else{
                        emailAndCandidates.put(word, "Candidate");
                    }
                }
            }
        }
        return emailAndCandidates;
    }

    public List<List<String>> getTextWithEmailSentences() {
        List<List<String>> text = new LinkedList<>(sentences);
        int lastIndex = text.size() - 1;
        for (int i = 0; i <= lastIndex; i++) {
            List<String> sentence = text.get(i);
            for (String word : sentence) {
                if (word.contains("@") && EmailValidator.isValidEmail(word)) {
                    List<String> lastSentence = text.get(lastIndex);
                    text.set(i, lastSentence);
                    text.remove(lastIndex);
                    lastIndex = text.size() - 1;
                    i--;
                    break;
                }
            }
        }
        return text;
    }

}
