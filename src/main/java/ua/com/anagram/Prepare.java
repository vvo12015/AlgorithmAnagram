package ua.com.anagram;

import java.util.ArrayList;
import java.util.List;

import ua.com.anagram.exceptions.UnknownAlphabetException;

class Prepare {

    private final List<String> preparedList = new ArrayList<>();

    public List<String> prepare (List<String> list) {

        for (String word: list) {
            if (isWord(word)) {
                preparedList.add(word.toLowerCase());
            }
        }

        char firsLetter = preparedList.get(0).toCharArray()[0];

        if (firsLetter >= 'a' && firsLetter <= 'z') {
            System.out.println("English text is identified for anagram searching");
        }
        else if (firsLetter >= 'а' && firsLetter <= 'я' || firsLetter  == 'і' || firsLetter  == 'ї' ||
                firsLetter  == 'ґ' || firsLetter  == 'є') {
            System.out.println("Russian or ukrainian text is identified for anagram searching");
        }
        else {
                try {
                    throw new UnknownAlphabetException();
                } catch (UnknownAlphabetException e) {
                    System.out.println("Program can't identify alphabet");
                }
            }
        return preparedList;
    }

    private boolean isWord(String name) {

        char[] chars = name.toCharArray();

        for (char c : chars) {
            if(!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

//    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("brother");
//        list.add("brother1");
//        list.add("brother.");
//        list.add("брат");
//        list.add("брат1");
//        list.add("брат.");
//        list.add("ґ");
//
//        Prepare p = new Prepare();
//        List<String> lNew  = p.prepare (list);
//        System.out.println(lNew);
//    }
}
