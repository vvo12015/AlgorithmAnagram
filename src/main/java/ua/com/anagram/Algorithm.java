package ua.com.anagram;

import java.util.List;
import java.util.Map;

public interface Algorithm {

    Map<String, List<String>> execute(List<String> listToWorkWith);
}