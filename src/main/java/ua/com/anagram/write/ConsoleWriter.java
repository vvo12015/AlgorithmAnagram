package ua.com.anagram.write;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConsoleWriter implements Writer {

    Map<String, List<String>> anagrams;

    public Map<String, List<String>> getAnagrams() {
        return anagrams;
    }

    public void setAnagrams(Map<String, List<String>> anagrams) {
        this.anagrams = anagrams;
    }

    public ConsoleWriter(Map<String, List<String>> anagrams) {

        this.anagrams = anagrams;
    }

    @Override
    public void write() {

        System.out.println("Word" + "\t" + "Anagrams");

        for (Map.Entry<String, List<String>> entry :
                anagrams.entrySet()) {
            System.out.print(entry.getKey() + "\t");
            for (int i = 0; i < entry.getValue().size(); i++) {
                    System.out.print(entry.getValue().get(i));
                    if (i < entry.getValue().size()){
                        System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}
