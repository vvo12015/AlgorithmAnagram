package ua.com.anagram.read;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileReader implements Reader {

    private static final String SPACE = " ";
    private final String fileName;

    public FileReader(String fileName) {
        this.fileName = fileName;
    }

    public List<String> read(){

        List<String> wordsList = new ArrayList<>();

        File file = new File(fileName);

        String s;
            try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
                while ((s = reader.readLine()) != null) {
                    Collections.addAll(wordsList, s.split(SPACE));
                }
        } catch (FileNotFoundException e) {
            System.err.format("File not found: %s%n", e);
            }
        catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

        return wordsList;
    }
}