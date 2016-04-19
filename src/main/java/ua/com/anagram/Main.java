package ua.com.anagram;

import ua.com.anagram.read.ConsoleReader;
import ua.com.anagram.read.FileReader;
import ua.com.anagram.write.ConsoleWriter;
import ua.com.anagram.write.FileWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static final String FIRST_MESSAGE = "Welcome to our program that implements the algorithm anagrams.";
    public static final String MESSAGE_BEFORE_SELECT = "Please select the source of words for analysis. Console(c)" +
            " or reading in file (f) for exit just press Enter";
    public static final char CONSOLE = 'c';
    public static final char FILE = 'f';
    public static final String FOR_ENTER_FILENAME = "Enter file name";
    public static final String MESSAGE_GOODBYE = "As output. Console(c) or File(f)";

    public static void main(String[] args) {

        ArrayList<String> words = new ArrayList<>(welcome());

        AlgorithmAnagram algorithmAnagram = new AlgorithmAnagram();

        goodbye(algorithmAnagram.execute(Prepare.prepare(words)));
    }

    private static void goodbye(Map<String, List<String>> anagrams) {

        ConsoleReader consoleReader = new ConsoleReader();
        String s = consoleReader.readLine(MESSAGE_GOODBYE);

        char select = s.charAt(0);

        if (select == CONSOLE) {

            ConsoleWriter consoleWriter = new ConsoleWriter(anagrams);

            consoleWriter.write();

        } else if (select == FILE) {

            FileWriter fileWriter = new FileWriter(anagrams, consoleReader.readLine("Please enter filename"));
        }


    }

    private static ArrayList<String> welcome() {

        ConsoleReader consoleReader = new ConsoleReader();
        ArrayList<String> words = new ArrayList<>();

        System.out.println(FIRST_MESSAGE);

        String s = consoleReader.readLine(MESSAGE_BEFORE_SELECT);

        char select = s.charAt(0);

        if (select == CONSOLE) {
            words = consoleReader.read();

        } else if (select == FILE) {

            FileReader fileReader = new FileReader(consoleReader.readLine(FOR_ENTER_FILENAME));

            words = fileReader.read();
        }

        return words;
    }
}
