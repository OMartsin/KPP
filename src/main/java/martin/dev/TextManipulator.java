package martin.dev;

import java.util.ArrayList;
import java.util.List;

public class TextManipulator {
    public String removeWorldsByLengthWithConsonant(String text, int maxWordLength) {
        if(text == null){
            throw new IllegalArgumentException("Text cannot be null");
        }
        String[] words = text.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.matches("\\b[aeiouAEIOU]\\w*")) {
                sb.append(word).append(" ");
                continue;
            }
            if(word.length() <= maxWordLength){
                sb.append(word).append(" ");
            }
        }
        return sb.toString().trim();
    }

    public List<String> getCapitalWordGroups(String text){
        if(text == null){
            throw new IllegalArgumentException("Text cannot be null");
        }
        if(text.isEmpty()){
            return new ArrayList<>();
        }
        String[] words = text.split("\\s+");
        List<String> capitalWordGroups = new ArrayList<>();
        StringBuilder currentGroup = new StringBuilder();
        int count = 0;

        for (String word : words) {
            if (Character.isUpperCase(word.charAt(0))) {
                currentGroup.append(word).append(" ");
                count++;
                if (count == 3) {
                    capitalWordGroups.add(currentGroup.toString().trim());
                    currentGroup = new StringBuilder();
                    count = 0;
                }
            }
        }

        if (currentGroup.length() > 0) {
            capitalWordGroups.add(currentGroup.toString().trim());
        }

        return capitalWordGroups;
    }

    public void PrintWorldsGroups(List<String> groups) {
        for (String group : groups) {
            System.out.print("Group : \"");
            System.out.println(group + "\"");
        }
    }


}
