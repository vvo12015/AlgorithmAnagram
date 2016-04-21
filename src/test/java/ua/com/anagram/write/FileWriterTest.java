package ua.com.anagram.write;

import org.junit.Before;
import org.junit.Test;
import ua.com.anagram.read.FileReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class FileWriterTest {

    private FileWriter fileWriter;
    private StringBuilder stringBuilder;
    private StringBuilder readBuilder;
    private Map<String, List<String>> map = new HashMap<>();

    @Before
    public void setUp() throws IOException {
        fileWriter = new FileWriter();
        stringBuilder = new StringBuilder();
        readBuilder = new StringBuilder();

        map.put("cat", Arrays.asList("cat", "tac", "act"));
        map.put("test", Arrays.asList("test", "sett"));
        map.put("dog", Collections.singletonList("dog"));
    }

    @Test (timeout = 1000)
    public void write() throws Exception {
        fileWriter.write(map);

        final Path path = Paths.get(System.getProperty("user.home"), "\\AppData\\Local\\Temp", "anagrams.txt");

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                readBuilder.append(line)
                        .append(System.getProperty("line.separator"));
            }
        }

        stringBuilder.append("Word: test -> Anagrams: [ test, sett ]")
                .append(System.getProperty("line.separator"))
                .append("Word: cat -> Anagrams: [ cat, tac, act ]")
                .append(System.getProperty("line.separator"))
                .append("Word: dog -> 0")
                .append(System.getProperty("line.separator"));

        assertEquals(stringBuilder, readBuilder);
    }

    @Test (timeout = 1000)
    public void testReadEmptyFile() throws Exception {
        fileWriter.write(getEmptyMap());

        final String path = Paths.get(System.getProperty("user.home"), "\\AppData\\Local\\Temp", "anagrams.txt")
                .toString();
        FileReader fileReader = new FileReader(path);

        final List<String> result = fileReader.read();
        assertEquals(new ArrayList<String>().isEmpty(), result.isEmpty());
    }

    private Map<String, List<String>> getEmptyMap() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("",new ArrayList<>());
        return map;
    }

}
