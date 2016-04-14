package ua.com.anagram.read;

import java.io.IOException;
import java.util.ArrayList;

public interface Reader {

    ArrayList<String> read() throws IOException;
}
