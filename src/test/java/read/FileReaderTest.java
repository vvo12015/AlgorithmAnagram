package read;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileReaderTest {

    private final ArrayList<String> listResult = new ArrayList<String>();

    @Before
    public void setUpRead(){
        listResult.add("loveFile");
        listResult.add("catFile");
        listResult.add("tacFile");
        listResult.add("actFile");
        listResult.add("ovelFile");
        listResult.add("readFile");
    }

    @Test
    public void read() throws Exception {
        Reader reader = mock(Reader.class);

        when(reader.read()).thenReturn(listResult);

    }

}