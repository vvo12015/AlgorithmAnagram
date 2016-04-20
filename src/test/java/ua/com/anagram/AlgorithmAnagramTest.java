package ua.com.anagram;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class AlgorithmAnagramTest {

    private AlgorithmAnagram algorithmObject;
    private List<String> validSourceText;
    private Map<String, List<String>> validFoundAnagrams;
    private Map<String, List<String>> emptyMap;

    @Before
    public void setUp() throws Exception {
        algorithmObject = new AlgorithmAnagram();
        validSourceText = getPopulatedSourceText();
        validFoundAnagrams = getValidAnagrams();
        emptyMap = getEmptyMap();
    }

    @Test (timeout = 1000)
    public void testExecute() throws Exception {
        final Map<String, List<String>>  result = algorithmObject.execute(validSourceText);

        assertEquals(validFoundAnagrams, result);
    }

    @Test (timeout = 1000)
    public void testExecuteEmptySourceText() throws Exception {
        final Map<String, List<String>>  result = algorithmObject.execute(getEmptySourceText());

        assertEquals(emptyMap.size(), result.size());
    }

    private Map<String, List<String>> getValidAnagrams() {
        final Map<String, List<String>> mapToBe = new HashMap<>();
        mapToBe.put("кат", Arrays.asList("кат", "акт"));
        mapToBe.put("мама", Arrays.asList("мама", "амам"));
        mapToBe.put("rama", Collections.singletonList("rama"));
        mapToBe.put("mary", Arrays.asList("mary", "army"));
        return mapToBe;
    }

    private List<String> getPopulatedSourceText() {
        List<String> list = new ArrayList<>();
        list.add("кат");
        list.add("мама");
        list.add("мама");
        list.add("мама");
        list.add("акт");
        list.add("rama");
        list.add("mary");
        list.add("амам");
        list.add("army");
        return list;
    }

    private List<String> getEmptySourceText() {
        List<String> list = new ArrayList<>();
        list.add("");
        return list;
    }

    private Map<String, List<String>> getEmptyMap() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("",new ArrayList<>());
        return map;
    }
}
