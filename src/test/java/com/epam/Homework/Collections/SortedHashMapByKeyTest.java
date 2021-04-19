package com.epam.Homework.Collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SortedHashMapByKeyTest {

    SortedHashMapByKey sortedHashMapByKey = new SortedHashMapByKey();

    private final PrintStream standardOut = System.out;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void sort() {
        Map<Integer, String> map = new HashMap<>();
        map.put(13, "f");
        map.put(45, "a");
        map.put(12, "b");
        sortedHashMapByKey.sort(map);
        assertEquals("{12=b, 13=f, 45=a}", outputStreamCaptor.toString()
                .trim());
    }
}