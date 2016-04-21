package ua.com.anagram.write;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FileWriter implements Writer {

    private Path path;

    private Map<String, List<String>> map;

    public FileWriter(Map<String, List<String>> map) {
        this.map = map;
        path = Paths.get(System.getProperty("user.home"), "\\AppData\\Local\\Temp", "anagrams.txt");
    }

    public FileWriter(Map<String, List<String>> map, String fileName) {
        this.map = map;
        path = Paths.get(System.getProperty("user.dir"), fileName);
    }

    @Override
    public String write() {
        return checkForExistenceOfFile(map);
    }

    public String checkForExistenceOfFile(Map<String, List<String>> map) {
        String textToFile = null;
        if (Files.isRegularFile(path) && Files.isReadable(path) && Files.isExecutable(path)) {
            textToFile = writeToFile(map);
            System.out.println("Text entry is complete");
        } else {
            try {
                Files.createFile(path);
                System.out.println("File created");
                textToFile = writeToFile(map);
                System.out.println("Text entry is complete");
            } catch (FileAlreadyExistsException x) {
                System.err.format("file named %s already exists%n", path);
            } catch (IOException x) {
                System.err.format("createFile error: %s%n", x);
            }
        }
        return textToFile;
    }

    private String writeToFile(Map<String, List<String>> map) {
        StringBuilder sb = new StringBuilder();
        Charset charset = Charset.forName("UTF-8");
        try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                writer.write("Word: ");
                writer.write(key);
                writer.write(" -> ");
                sb.append("Word: ").append(key).append(" -> ");

                if (value.size() == 1) {
                    writer.write("0");
                    sb.append(0);
                } else {
                    writer.write("Anagrams: [");
                    sb.append("Anagrams: [");
                    int counter = 0;
                    for (String s : value) {
                        writer.write(" " + s, 0, s.length() + 1);
                        sb.append(" ").append(s);
                        if (counter < value.size() - 1) {
                            writer.write(",");
                            sb.append(",");
                            counter++;
                        }
                    }
                    writer.write(" ]");
                    sb.append(" ]");
                }
                writer.newLine();
                sb.append(System.getProperty("line.separator"));
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        return sb.toString();
    }
}
