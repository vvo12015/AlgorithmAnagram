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
        final int FIRST_ENGLISH_SYMBOL = 97;
        final int LAST_ENGLISH_SYMBOL = 122;

        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if ((int)s[i] < FIRST_ENGLISH_SYMBOL || (int)s[i] > LAST_ENGLISH_SYMBOL) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkRussian(String s){
        final int FIRST_RUSSIAN_SYMBOL = 224;
        final int RUSSIAN_SYMBOL_YO = 184;

        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if ((int)s[i] < FIRST_RUSSIAN_SYMBOL && (int)s[i] != RUSSIAN_SYMBOL_YO) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkUkrainian(String s){
        final int FIRST_RUSSIAN_SYMBOL = 224;
        final int TVERDYI_ZNAK = 184;
        final int OPERACIA_bl = 251;
        final int REVERSE_E = 253;
        final int UKRAINIAN_G = 180;
        final int UKRAINIAN_E = 186;
        final int UKRAINIAN_YI = 191;

        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if ((int)s[i] < FIRST_RUSSIAN_SYMBOL
                    && (int)s[i] != UKRAINIAN_E
                    && (int)s[i] != UKRAINIAN_G
                    && (int)s[i] != UKRAINIAN_YI
                    || (int)s[i] == TVERDYI_ZNAK
                    || (int)s[i] == OPERACIA_bl
                    || (int)s[i] == REVERSE_E) {
                return false;
            }
        }
        return true;
    }

}
