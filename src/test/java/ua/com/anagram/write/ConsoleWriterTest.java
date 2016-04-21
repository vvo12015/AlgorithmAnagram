package ua.com.anagram.write;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import static org.junit.Assert.*;

public class ConsoleWriterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final StringBuilder stringBuilder = new StringBuilder();
    private ConsoleWriter consoleWriter;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        consoleWriter = new ConsoleWriter();

        stringBuilder.append("Word: test -> Anagrams: [ test, sett ]")
                .append(System.getProperty("line.separator"))
                .append("Word: cat -> Anagrams: [ cat, tac, act ]")
                .append(System.getProperty("line.separator"))
                .append("Word: dog -> 0")
                .append(System.getProperty("line.separator"));
    }

    @Test (timeout = 1000)
    public void write() throws Exception {
        consoleWriter.write(getValidMap());
        assertEquals(stringBuilder.toString(), outContent.toString());
    }

    @Test (timeout = 1000)
    public void writeEmptyMap() {
        consoleWriter.write(getEmptyMap());
        assertEquals("Word:  -> Anagrams: [ ]"
                + System.getProperty("line.separator"), outContent.toString());
    }

    private Map<String, List<String>> getValidMap() {
        final Map<String, List<String>> map = new HashMap<>();
        map.put("cat", Arrays.asList("cat", "tac", "act"));
        map.put("test", Arrays.asList("test", "sett"));
        map.put("dog", Collections.singletonList("dog"));
        return map;
    }

    private Map<String, List<String>> getEmptyMap() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("",new ArrayList<>());
        return map;
    }

    @After
    public void cleanUp() {
        System.setOut(null);
    }

}