package ua.com.anagram;

import java.util.*;

public class AlgorithmAnagram {

    private final List<String> result = new ArrayList<>();

    private final Map<String, List<String>> map = new HashMap<>();

    private List<String> find(List<String> list) {

        for (String index : list) {
            String sortedWord = sortWord(index);
            List<String> anagrams = map.get(sortedWord);
            if (anagrams == null) {
                List<String> anagramsNew = new ArrayList<>();
                anagramsNew.add(index);
                map.put(sortedWord, anagramsNew);
            } else {
                anagrams.add(index);
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.addAll(entry.getValue());
            result.add("\n");
        }
            return result;
        }

    private static String sortWord(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }

//    public static void main(String[] args) {
//
//        List<String> list = new ArrayList<>();
//        list.add("кат");
//        list.add("мама");
//        list.add("акт");
//        list.add("рама");
//        list.add("шина");
//        list.add("амам");
//        list.add("ниша");
//
//        System.out.print("Text/ list of words: ");
//        for (String s : list) {
//            System.out.print(s + " ");
//        }
//        System.out.println();
//
//        AlgorithmAnagram obj = new AlgorithmAnagram();
//        List<String> listTest = obj.find(list);
//        System.out.println("\nAnagrams: ");
//        for (String s : listTest) {
//            System.out.print(s + " ");
//        }
//    }
}

