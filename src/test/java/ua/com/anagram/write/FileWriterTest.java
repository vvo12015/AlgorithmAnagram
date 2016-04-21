package ua.com.anagram.write;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ua.com.anagram.read.FileReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class FileWriterTest {

    private FileWriter fileWriter;
    private FileWriter fileWriterWithPath;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() throws IOException {
        fileWriter = new FileWriter();

        String fileName = "anagrams.txt";
        fileWriterWithPath = new FileWriter(fileName);
    }

    @Test (timeout = 1000)
    public void testReadEmptyFile() throws Exception {
        final String path = Paths.get(System.getProperty("user.home"), "\\AppData\\Local\\Temp", "anagrams.txt")
                .toString();

        FileReader fileReader = new FileReader(path);

        fileWriter.write(getEmptyMap());

        final List<String> result = fileReader.read();
        assertEquals(new ArrayList<String>().isEmpty(), result.isEmpty());
    }

    /*@Test
    public void testFileAlreadyExistsException() throws Exception {
        final String path = Paths.get(System.getProperty("user.home"), "\\AppData\\Local\\Temp", "anagrams.txt")
                .toString();
        final File testFile = new File(path);
//        testFile.createNewFile();

        exception.expect(FileAlreadyExistsException.class);

        fileWriter.write(getValidMap());

    }*/

    private Map<String, List<String>> getEmptyMap() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("",new ArrayList<>());
        return map;
    }

    private Map<String, List<String>> getValidMap() {
        final Map<String, List<String>> map = new HashMap<>();
        map.put("cat", Arrays.asList("cat", "tac", "act"));
        map.put("test", Arrays.asList("test", "sett"));
        map.put("dog", Collections.singletonList("dog"));
        return map;
    }
}
