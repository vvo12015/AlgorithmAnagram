package ua.com.anagram.read;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class FileReader implements Reader {

    public static final String SPACE = " ";
    private String fileName;

    public FileReader(String fileName) {
        this.fileName = fileName;
    }


    public ArrayList<String> read(){

        ArrayList<String> wordsList = new ArrayList<String>();

        String s;
        try {
            try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName))) {
                while ((s = reader.readLine()) != null) {
                    Collections.addAll(wordsList, s.split(SPACE));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file");
        }
//
        return wordsList;

    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(final String fileName) {
        this.fileName = fileName;
    }
}
