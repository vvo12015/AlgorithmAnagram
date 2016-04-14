package ua.com.anagram.read;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConsoleReaderTest extends Assert {

    private final ArrayList<String> listResult = new ArrayList<String>();

    @Before
    public void setUpRead(){
        listResult.add("love");
        listResult.add("cat");
        listResult.add("tac");
        listResult.add("act");
        listResult.add("ovel");
        listResult.add("read");
    }


    @Test
    public void read() throws Exception {
        Reader reader = mock(Reader.class);

        when(reader.read()).thenReturn(listResult);

    }

}