package ua.com.anagram;

import java.util.*;

class Prepare {

    public static List<String> prepare (List<String> list) {

        List<String> preparedList = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            list.set(i, list.get(i).replaceAll("[\\p{Punct} ]", ""));

            if (isWord(list.get(i)) && !list.get(i).equals("")) {
                preparedList.add(list.get(i).toLowerCase());
            }
        }
        return preparedList;
    }

    private static boolean isWord(String s) {

        char[] chars = s.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
}