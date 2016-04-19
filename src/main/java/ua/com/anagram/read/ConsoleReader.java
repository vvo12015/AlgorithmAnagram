package ua.com.anagram.read;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleReader implements Reader {

    private static final String MESSAGE_FOR_CONSOLE_ENTER = "Enter words using space";
    public static final String SPACE_STRING = " ";
    private Scanner scanner;

    public ConsoleReader() {
        this.scanner = getScanner();
    }

    public ArrayList<String> read(){

        ArrayList<String> wordsList = new ArrayList<>();

        String consoleLine = readLine(MESSAGE_FOR_CONSOLE_ENTER);

        if (consoleLine.contains(SPACE_STRING)) {
            for (String word : consoleLine.split(SPACE_STRING)) {
                wordsList.add(word);
            }
        }

        return wordsList;
    }

    public String readLine(String message){
        System.out.println(message);
        return getScanner().nextLine();
    }

    private Scanner getScanner() {
        if (scanner != null) {
            return scanner;
        }
        return new Scanner(System.in);
    }

    private void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

}
