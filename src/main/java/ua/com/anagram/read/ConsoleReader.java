package ua.com.anagram.read;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleReader implements Reader {

    private static final String MESSAGE_FOR_CONSOLE_ENTER = "Enter words using space";
    private Scanner scanner;

    private Scanner getScanner() {
        return scanner;
    }

    private void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public ArrayList<String> read(){

        ArrayList<String> wordsList = new ArrayList<>();

        String consoleLine = readLine(MESSAGE_FOR_CONSOLE_ENTER);

        if (consoleLine.contains(" ")) {
            for (String word : consoleLine.split(" ")) {
                wordsList.add(word);
            }
        }

        return wordsList;
    }
//
    public String readLine(String message){
        System.out.println(message);
        return scanner.nextLine();
    }


}
