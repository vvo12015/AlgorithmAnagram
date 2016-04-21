package ua.com.anagram.write;

import java.util.List;
import java.util.Map;

public class ConsoleWriter implements Writer {

    private Map<String, List<String>> map;

    public ConsoleWriter(Map<String, List<String>> map) {
        this.map = map;
    }

    @Override
    public String write() {
        return getText(map);
    }

    private String getText(Map<String, List<String>> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String  key = entry.getKey();
            List<String> value = entry.getValue();

            sb.append("Word: ").append(key).append(" -> ");
            if (value.size() == 1) {
                sb.append(0);
            } else {
                sb.append("Anagrams: [ ");
                int counter = 0;
                for (String s : value) {
                    sb.append(s);
                    if (counter < value.size() - 1) {
                        sb.append(",");
                        counter++;
                    }
                    sb.append(" ");

                }
                sb.append("]");
            }
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }

}