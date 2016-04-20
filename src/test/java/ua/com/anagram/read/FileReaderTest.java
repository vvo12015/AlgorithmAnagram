package ua.com.anagram.read;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FileReaderTest {

    private List<String> validList;
//    private List<String> emptyList;
    private String validFileNme;
    private String invalidFileNme = " ";

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Before
    public void setUp() throws IOException{
        validFileNme = createAndFillFile();
        validList = getValidList();
//        emptyList = getEmptyList();
    }

    @Test (timeout = 1000)
    public void testRead() throws Exception {
        FileReader fileReader = new FileReader(validFileNme);
        final List<String> result = fileReader.read();

        assertEquals(validList, result);
    }

    @Test(expected = FileNotFoundException.class)
    public void testReadFileNotFoundException() throws Exception {
        FileReader fileReader = new FileReader(invalidFileNme);
        final List<String> result = fileReader.read();
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

    private List<String> getEmptyList() {
        List<String> list = new ArrayList<>();
        list.add("");
        return list;
    }

    private String createAndFillFile() throws IOException {
        File file = folder.newFile("tempfile.txt");
        FileWriter writer = new FileWriter(file);
        writer.write("loveFile catFile tacFile actFile ovelFile readFile");
        writer.close();
        return file.getName();
    }
}