package ua.com.anagram.write;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ConsoleWriterTest {

    private final Map<String, List<String>> listResult = new HashMap<>();
    private final StringBuilder st = new StringBuilder();

    @Before
    public void setUpWrite(){

        st.append("Word: love -> Anagrams: [ love, ovel, velo ]")
                .append(System.getProperty("line.separator"))
                .append("Word: sleep -> 0")
                .append(System.getProperty("line.separator"))
                .append("Word: read -> Anagrams: [ read, dear ]")
                .append(System.getProperty("line.separator"))
                .append("Word: cat -> Anagrams: [ cat, tac, act ]")
                .append(System.getProperty("line.separator"));
    }

    @Test (timeout = 1000)
    public void write() throws Exception {
        final ConsoleWriter cw = new ConsoleWriter(getValidMap());

        assertEquals(st.toString(), cw.write());
    }

    @Test (timeout = 1000)
    public void testEmptyText() throws Exception {
        final ConsoleWriter cw = new ConsoleWriter(getEmptyMap());
        final String emptyText = "Word:  -> Anagrams: [ ]" +
                System.getProperty("line.separator");

        assertEquals(emptyText, cw.write());
    }

    private Map<String, List<String>> getValidMap() {
        listResult.put("love", Arrays.asList("love", "ovel", "velo"));
        listResult.put("cat", Arrays.asList("cat", "tac", "act"));
        listResult.put("read", Arrays.asList("read", "dear"));
        listResult.put("sleep", Collections.singletonList("sleep"));
        return listResult;
    }

    private Map<String, List<String>> getEmptyMap() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("",new ArrayList<>());
        return map;
    }

}