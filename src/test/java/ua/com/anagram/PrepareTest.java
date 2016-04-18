package ua.com.anagram;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class PrepareTest {

    private static Prepare prepareObject;
    private static final List<String> list = new ArrayList<>();

    static {
        list.add("brother");
        list.add("brother123");
        list.add("brother.,");
        list.add("brother  ");
        list.add("BROTHER");
        list.add("");
        list.add(" ");
        list.add("брат");
        list.add("брат123");
        list.add("брат.,");
        list.add("брат  ");
        list.add("БРАТ");
    }

    @BeforeClass
    public static void setUpClass() {
        prepareObject = new Prepare();
    }

    @Test (timeout = 1000)
    public void testPrepare() throws Exception {

        final List<String> listToBe = new ArrayList<>();
        listToBe.add("brother");
        listToBe.add("brother");
        listToBe.add("брат");
        listToBe.add("брат");

        final  List<String> result = prepareObject.prepare(list);

        assertEquals(listToBe, result);
    }
}