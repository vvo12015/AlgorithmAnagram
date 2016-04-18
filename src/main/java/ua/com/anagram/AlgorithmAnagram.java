package ua.com.anagram;

import java.util.*;

public class AlgorithmAnagram implements Algorithm {

    private final Map<String, List<String>> map;

    public AlgorithmAnagram() {
        this.map = new HashMap<>();
    }

    @Override
    public Map<String, List<String>> execute(List<String> listToWorkWith) {

        final Map<String, List<String>> mapTemp = new HashMap<>();

        if (listToWorkWith == null || listToWorkWith.isEmpty()) {
            return map;
        }

        for (String index : listToWorkWith) {
            String sortedWord = sortWord(index);
            List<String> anagrams = mapTemp.get(sortedWord);
            if (anagrams == null) {
                List<String> anagramsNew = new ArrayList<>();
                anagramsNew.add(index);
                mapTemp.put(sortedWord, anagramsNew);
            } else {
                if (!anagrams.contains(index)) {
                    anagrams.add(index);
                }
            }
        }

        for (Map.Entry<String, List<String>> entry : mapTemp.entrySet()) {
            map.put(entry.getValue().get(0), entry.getValue());
        }

        return map;
    }

    private static String sortWord(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}