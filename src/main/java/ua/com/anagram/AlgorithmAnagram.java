package ua.com.anagram;

import java.util.*;

public class AlgorithmAnagram {

    public List<String> result = new ArrayList<>();

    public Map<String, List<String>> map = new HashMap<String, List<String>>();

    static List<String> listDemo = new ArrayList<>();
    static  {
        listDemo.add("кат");
        listDemo.add("мама");
        listDemo.add("акт");
        listDemo.add("рама");
        listDemo.add("шина");
        listDemo.add("амам");
        listDemo.add("ниша");
    }

    public static void main(String[] args) {
        for (String s : listDemo) {
            System.out.print(s + " ");
        }
        System.out.println();

        AlgorithmAnagram obj = new AlgorithmAnagram();
        List<String> listTest = obj.find(listDemo);
        System.out.println(listTest);
    }

    public List<String> find (List<String> list) {

        for (String index : list) {
            String sortedWord = sort(index);
            System.out.println("sortedWord   " + sortedWord);
            List<String> anagrams = map.get(sortedWord);
            if (anagrams == null) {
                List <String> anagramsNew = new ArrayList<>();
                anagramsNew.add(index);
                map.put(sortedWord, anagramsNew);
            } else {
                anagrams.add(index);
            }
        }

        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            System.out.println(entry.getKey() + ",,,,,,,,," + entry.getValue());
            result.addAll(entry.getValue());
            result.add("");
        }

        return result;
    }

    private static String sort (String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}

//  анаграммы (слова с одинаковым набором букв).
// Текст: кат мама акт рама шина амам ниша. Анаграммы: кат акт; мама амам; шина ниша;..)

