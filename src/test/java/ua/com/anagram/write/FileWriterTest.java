package ua.com.anagram.write;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import ua.com.anagram.read.FileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class FileWriterTest {

    private FileWriter fileWriter;

    private Map<String, List<String>> map = new HashMap<>();

    private String tempFilePath;
    private String tempEmptyFilePath;

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setUp() throws IOException {
        tempFilePath = createAndFillFile();
        tempEmptyFilePath = createEmptyFile();

        fileWriter = new FileWriter(tempFilePath);

        map.put("cat", Arrays.asList("cat", "tac", "act"));
        map.put("test", Arrays.asList("test", "sett"));
        map.put("dog", Collections.singletonList("dog"));
    }

    @Test (timeout = 1000)
    public void write() throws Exception {
        fileWriter.write(map);

        final Path path = Paths.get(tempFilePath);
        final Charset charset = Charset.forName("UTF-8");
        final StringBuilder readBuilder = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            String line;
            while ((line = reader.readLine()) != null) {
                readBuilder.append(line);
            }
        }
        String text = "Word: test -> Anagrams: [ test, sett ]" +
                "Word: cat -> Anagrams: [ cat, tac, act ]" +
                "Word: dog -> 0";

        assertEquals(text, readBuilder.toString());
    }

    @Test (timeout = 1000)
    public void testReadEmptyFile() throws Exception {

        fileWriter.write(getEmptyMap());

        final String path = Paths.get(tempEmptyFilePath)
                .toString();
        FileReader fileReader = new FileReader(path);

        final List<String> result = fileReader.read();
        assertEquals(new ArrayList<String>().isEmpty(), result.isEmpty());
    }

    private String createAndFillFile() throws IOException {
        File file = folder.newFile("tempFile.txt");
        java.io.FileWriter writer = new java.io.FileWriter(file);
        writer.write("Word: test -> Anagrams:[ test, sett ]");
        writer.write("Word: cat -> Anagrams: [ cat, tac, act ]");
        writer.write("Word: dog -> 0");
        writer.close();
        return file.getAbsolutePath();
    }

    private String createEmptyFile() throws IOException {
        File file = folder.newFile("tempEmptyFile.txt");
        return file.getAbsolutePath();
    }

    private Map<String, List<String>> getEmptyMap() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("",new ArrayList<>());
        return map;
    }

}
