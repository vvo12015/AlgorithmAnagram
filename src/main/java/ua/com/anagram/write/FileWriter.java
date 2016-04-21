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

    public FileWriter() {
        path = Paths.get(System.getProperty("user.home"), "\\AppData\\Local\\Temp", "anagrams.txt");
    }

    public FileWriter(String fileName) {
        path = Paths.get(System.getProperty("user.dir"), fileName);
    }

    public void write(Map<String, List<String>> map) {
        if (Files.isRegularFile(path) && Files.isReadable(path) && Files.isExecutable(path)) {
            writeToFile(map);
        } else {
            try {
                Files.createFile(path);
                writeToFile(map);
            } catch (FileAlreadyExistsException x) {
                System.err.format("file named %s already exists%n", path);
            } catch (IOException x) {
                System.err.format("createFile error: %s%n", x);
            }
        }
    }

    public Path getPath() {
        return path;
    }

    private void writeToFile(Map<String, List<String>> map) {
        Charset charset = Charset.forName("UTF-8");
        try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                List<String> value = entry.getValue();
                writer.write("Word: ");
                writer.write(key);
                writer.write(" -> ");

                if (value.size() == 1) {
                    writer.write("0");
                } else {
                    writer.write("Anagrams: [");
                    int counter = 0;
                    for (String s : value) {
                        writer.write(" " + s, 0, s.length() + 1);
                        if (counter < value.size() - 1) {
                            writer.write(",");
                            counter++;
                        }
                    }
                    writer.write(" ]");
                }
                writer.newLine();
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }
}
