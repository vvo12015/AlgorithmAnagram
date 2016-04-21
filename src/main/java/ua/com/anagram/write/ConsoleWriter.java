package ua.com.anagram.write;

import java.util.List;
import java.util.Map;

public class ConsoleWriter implements Writer {

    public void write(Map<String, List<String>> map) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String  key = entry.getKey();
            List<String> value = entry.getValue();

            System.out.printf("Word: %s -> ", key);
            if (value.size() == 1) {
                System.out.print(0);
            } else {
                System.out.print("Anagrams: [ ");
                int counter = 0;
                for (String s : value) {
                    System.out.print(s);
                    if (counter < value.size() - 1) {
                        System.out.print(",");
                        counter++;
                    }
                    System.out.print(" ");
                }
                System.out.print("]");
            }
            System.out.println();
        }
    }
}