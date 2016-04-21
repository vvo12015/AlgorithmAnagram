package ua.com.anagram.read;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ConsoleReader implements Reader {

    private static final String CONSOLE_MESSAGE = "Enter words using space";
    private static final String SPACE = " ";
    private final Scanner scanner;

    public ConsoleReader() {
        this.scanner = getScanner();
    }

    public List<String> read(){

        List<String> wordsList = new ArrayList<>();

        String consoleLine = readLine(CONSOLE_MESSAGE);

        if (consoleLine.contains(SPACE)) {
            Collections.addAll(wordsList, consoleLine.split(SPACE));
        }
        else Collections.addAll(wordsList, consoleLine);

        return wordsList;
    }

    public String readLine(String line){
        System.out.println(line);
        return getScanner().nextLine();
    }

    private Scanner getScanner() {
        if (scanner != null) {
            return scanner;
        }
        return new Scanner(System.in);
    }
}
