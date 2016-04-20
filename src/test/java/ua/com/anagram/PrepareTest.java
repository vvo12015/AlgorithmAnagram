package ua.com.anagram;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PrepareTest {

    private List<String> validSourceList;
    private List<String> emptySourceList;
    private List<String> preparedList;

    @Before
    public void setUp() throws Exception {
        validSourceList = getValidSourceList();
        preparedList = getPreparedList();
        emptySourceList = getEmptySourceList();
    }

    @Test(timeout = 1000)
    public void testPrepare() throws Exception {
        final List<String> result = Prepare.prepare(validSourceList);

        assertEquals(preparedList, result);
    }

    @Test(timeout = 1000)
    public void testPrepareEmptyList() throws Exception {
        final List<String> result = Prepare.prepare(emptySourceList);

        assertEquals(new ArrayList<String>(), result);
    }

    private List<String> getValidSourceList() {
        List<String> list = new ArrayList<>();
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
        return list;
    }

    private List<String> getPreparedList() {
        List<String> preparedList = new ArrayList<>();
        preparedList.add("brother");
        preparedList.add("brother");
        preparedList.add("brother");
        preparedList.add("brother");
        preparedList.add("брат");
        preparedList.add("брат");
        preparedList.add("брат");
        preparedList.add("брат");
        return preparedList;
    }

    private List<String> getEmptySourceList() {
        List<String> emptyList = new ArrayList<>();
        emptyList.add("");
        return emptyList;
    }
}