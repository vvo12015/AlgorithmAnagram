package ua.com.anagram;

import ua.com.anagram.read.ConsoleReader;
import ua.com.anagram.read.FileReader;
import ua.com.anagram.write.ConsoleWriter;
import ua.com.anagram.write.FileWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    private static final String WELCOME_MESSAGE = "Welcome to our program that implements the algorithm " +
            "for finding anagrams.";
    private static final String MESSAGE_TO_SELECT_SOURCE = "Please select the source of text for finding " +
            "anagrams. Console(c) or file (f) or press Enter to exit:";
    private static final String CONSOLE = "c";
    private static final String FILE = "f";
    private static final String MESSAGE_TO_ENTER_FILENAME = "Please enter file name:";
    private static final String MESSAGE_TO_WRITE_ANAGRAMS = "Please select the destination for output. " +
            "Console(c) or file(f):";

    public static void main(String[] args) {
        System.out.println(WELCOME_MESSAGE);

        List<String> words = new ArrayList<>(selectSource());

        AlgorithmAnagram algorithmAnagram = new AlgorithmAnagram();

        selectOutput(algorithmAnagram.execute(Prepare.prepare(words)));
    }

    private static List<String> selectSource () {

        ConsoleReader consoleReader = new ConsoleReader();

        List<String> words = new ArrayList<>();

        String source = consoleReader.readLine(MESSAGE_TO_SELECT_SOURCE);

        switch (source) {
            case (CONSOLE):
                words = consoleReader.read();
                break;
            case (FILE):
                FileReader fileReader = new FileReader(consoleReader.readLine(MESSAGE_TO_ENTER_FILENAME));
                words = fileReader.read();
                if (words.isEmpty()) {
                    selectSource();
                }
                break;
            case (""):
                System.exit(0);
            default:
                selectSource();
        }
        return words;
    }

    private static void selectOutput (Map<String, List<String>> anagrams) {

        ConsoleReader consoleReader = new ConsoleReader();

        String destination = consoleReader.readLine(MESSAGE_TO_WRITE_ANAGRAMS);

        switch (destination) {
            case (CONSOLE):
                ConsoleWriter consoleWriter = new ConsoleWriter();
                consoleWriter.write(anagrams);
                break;
            case (FILE):
                String fileToWrite = consoleReader.readLine("Please type filename to write anagrams or" +
                        " press enter to write anagrams to default file path: ");
                if (fileToWrite.equals("")) {
                    FileWriter fileWriter = new FileWriter();
                    fileWriter.write(anagrams);
                } else {
                    FileWriter fileWriter = new FileWriter(fileToWrite);
                    fileWriter.write(anagrams);
                }
                break;
            default:
                selectOutput(anagrams);
        }
    }
}