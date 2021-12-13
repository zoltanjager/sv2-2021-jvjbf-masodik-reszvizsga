package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {
    List<String> words = new ArrayList<>();

    public List<String> getWords() {
        return words;
    }

    public void addWord(String word) {
        checkWord(word);
        words.add(word);
    }

    public boolean isThereAWordTwice() {
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            for (int j = 0; j < words.size(); j++) {
                if (word.equals(words.get(j)) && i != j) {
                    return true;
                }
            }
        }
        return false;
    }

    private void checkWord(String word) {
        char[] temp = word.toCharArray();
        for (char actual : temp) {
            if (Character.isUpperCase(actual)) {
                throw new IllegalArgumentException("Word should be lower case!");
            }
            if (Character.isWhitespace(actual)) {
                throw new IllegalArgumentException("It should be one word!");
            }
        }
    }
}
