package ua.com.anagram;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class AlgorithmAnagramTest {

    private static AlgorithmAnagram algorithmObject;
    private static final List<String> list = new ArrayList<>();
    static {
        list.add("кат");
        list.add("мама");
        list.add("мама");
        list.add("мама");
        list.add("акт");
        list.add("рама");
        list.add("шина");
        list.add("амам");
        list.add("ниша");
    }

    @BeforeClass
    public static void setUpClass() {
        algorithmObject = new AlgorithmAnagram();
    }

    @Test (timeout = 1000)
    public void testExecute() throws Exception {
        final Map<String, List<String>> mapToBe = new HashMap<>();
        mapToBe.put("кат", Arrays.asList("кат", "акт"));
        mapToBe.put("мама", Arrays.asList("мама", "амам"));
        mapToBe.put("рама", Arrays.asList("рама"));
        mapToBe.put("шина", Arrays.asList("шина", "ниша"));

        final   Map<String, List<String>>  result = algorithmObject.execute(list);

        assertEquals(mapToBe, result);
    }
}