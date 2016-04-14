package ua.com.anagram.read;

import java.io.*;
import java.util.ArrayList;

public class FileTxtReader implements Reader {

    public FileTxtReader(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {

        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private String fileName;

    public ArrayList<String> read(){

        ArrayList<String> wordsList = new ArrayList<String>();

        String s;
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                while ((s = reader.readLine()) != null) {
                    wordsList.add(s);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file");
        }
//
        return wordsList;

    }

}
