package ua.com.anagram;

import java.util.*;

public class AlgorithmAnagram implements Algorithm {

    private final Map<String, List<String>> map;

    public AlgorithmAnagram() {
        this.map = Collections.emptyMap();
    }

    @Override
    public Map<String, List<String>> execute(List<String> listToWorkWith) {
        if (listToWorkWith == null || listToWorkWith.isEmpty()) {
            return map;
        }
        for (String index : listToWorkWith) {
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

        return map;
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
    //        List<String> listTest = obj.execute(list);
    //        System.out.println("\nAnagrams: ");
    //        for (String s : listTest) {
    //            System.out.print(s + " ");
    //        }
    //    }
}

