package ua.com.anagram;

import java.util.ArrayList;
import java.util.List;

class Prepare {

    private final List<String> preparedList = new ArrayList<>();

    public List<String> prepare (List<String> list) {

        for (String word: list) {
            if (isWord(word)) {
                preparedList.add(word.toLowerCase());
            }
        }
        return preparedList;
    }

    private boolean isWord(String s) {

        char[] chars = s.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
}
