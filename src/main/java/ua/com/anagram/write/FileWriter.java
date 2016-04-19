package ua.com.anagram.write;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileWriter implements Writer {

    private Map<String, List<String>> anagrams;
    private String filename;

    private Map<String, List<String>> getAnagrams() {
        return anagrams;
    }

    private void setAnagrams(Map<String, List<String>> anagrams) {
        this.anagrams = anagrams;
    }

    private String getFilename() {
        return filename;
    }

    private void setFilename(String filename) {
        this.filename = filename;
    }

    public FileWriter(Map<String, List<String>> anagrams, String filename) {

        this.anagrams = anagrams;
        this.filename = filename;
    }

    @Override
    public void write() {

        try {
            java.io.FileWriter fileWriter = new java.io.FileWriter(filename);

            fileWriter.write("Word" + "\t" + "Anagrams");

            for (Map.Entry<String, List<String>> entry :
                    anagrams.entrySet()) {
                fileWriter.write(entry.getKey() + "\t");
                for (int i = 0; i < entry.getValue().size(); i++) {
                    fileWriter.write(entry.getValue().get(i));
                    if (i < entry.getValue().size()){
                        fileWriter.write(", ");
                    }
                }
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
