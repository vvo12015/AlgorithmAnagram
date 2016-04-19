package ua.com.anagram;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PrepareTest {

    private static final List<String> list = new ArrayList<>();

    static {
        list.add("brother");
        list.add("brother123");
        list.add("brother-");
        list.add("brother ");
        list.add("BROTHER");
        list.add("");
        list.add(" ");
        list.add("брат");
        list.add("брат123");
        list.add("брат-");
        list.add("брат  ");
        list.add("БРАТ");
    }

    @Test (timeout = 1000)
    public void testPrepare() throws Exception {

        final List<String> listToBe = new ArrayList<>();
        listToBe.add("brother");
        listToBe.add("brother");
        listToBe.add("brother");
        listToBe.add("brother");
        listToBe.add("брат");
        listToBe.add("брат");
        listToBe.add("брат");
        listToBe.add("брат");

        final  List<String> result = Prepare.prepare(list);

        assertEquals(listToBe, result);
    }
}