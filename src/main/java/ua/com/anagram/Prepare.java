package ua.com.anagram;

import java.net.FileNameMap;
import java.util.*;

class Prepare {

    private final List<String> preparedList = new ArrayList<>();

    public List<String> prepare (List<String> list) {

        for (String word: list) {
            if (isWord(word) && !word.equals("")) {
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

    public static boolean checkEnglish(String s){
        final static int A = 97;
        final static int Z = 122;

        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if ((int)s[i] < A && (int)s[i] > Z) {
                return false;
            }
        }
        return true;
    }
}
