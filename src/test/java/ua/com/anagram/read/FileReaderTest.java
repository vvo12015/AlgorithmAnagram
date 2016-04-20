package ua.com.anagram.read;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileReaderTest {

    private List<String> validList;
    private String validFileName;
    private String emptyFileName;

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setUp() throws IOException{
        validFileName = createAndFillFile();
        validList = getValidList();
        emptyFileName = createEmptyFile();
    }

    @Test
    public void testRead() throws Exception {
        FileReader fileReader = new FileReader(validFileName);
        final List<String> result = fileReader.read();
        assertEquals(validList, result);
    }

    @Test
    public void testReadEmptyFile() throws Exception {
        FileReader fileReader = new FileReader(emptyFileName);
        final List<String> result = fileReader.read();
        assertEquals(new ArrayList<String>().isEmpty(), result.isEmpty());
    }

    private List<String> getValidList() {
        List<String> list = new ArrayList<>();
        list.add("loveFile");
        list.add("catFile");
        list.add("tacFile");
        list.add("actFile");
        list.add("ovelFile");
        list.add("readFile");
        return list;
    }

    private String createAndFillFile() throws IOException {
        File file = folder.newFile("tempFle.txt");
        FileWriter writer = new FileWriter(file);
        writer.write("loveFile catFile tacFile actFile ovelFile readFile");
        writer.close();
        return file.getAbsolutePath();
    }

    private String createEmptyFile() throws IOException {
        File file = folder.newFile("tempEmptyFile.txt");
        return file.getAbsolutePath();
    }
}