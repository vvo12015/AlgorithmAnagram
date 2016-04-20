package ua.com.anagram;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class AlgorithmAnagramTest {

    private AlgorithmAnagram algorithmObject;
    private List<String> validSourceText;
    private  Map<String, List<String>> validFindedAnagrams;
    private List<String> inValidSourceText;
    private List<String> inValidFindedAnograms;


    @Before
    public void setUp() throws Exception {
        algorithmObject = new AlgorithmAnagram();
        validSourceText = getPopulatedSourceText();
        validFindedAnagrams = getValidAnagrams();

    }

    @Test (timeout = 1000)
    public void testExecute() throws Exception {
        final Map<String, List<String>>  actualResult = algorithmObject.execute(validSourceText);

        assertEquals(validFindedAnagrams, actualResult);
    }

    private Map<String, List<String>> getValidAnagrams() {
        final Map<String, List<String>> mapToBe = new HashMap<>();
        mapToBe.put("кат", Arrays.asList("кат", "акт"));
        mapToBe.put("мама", Arrays.asList("мама", "амам"));
        mapToBe.put("рама", Collections.singletonList("рама"));
        mapToBe.put("шина", Arrays.asList("шина", "ниша"));
        return mapToBe;
    }

    private List<String> getPopulatedSourceText() {
        List<String> list = new ArrayList<>();
        list.add("кат");
        list.add("мама");
        list.add("мама");
        list.add("мама");
        list.add("акт");
        list.add("рама");
        list.add("шина");
        list.add("амам");
        list.add("ниша");
        return list;
    }
}
// кат мама мама мама акт рама шина амам ниша
