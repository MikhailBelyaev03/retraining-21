package com.epam.Homework.Collections;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class SortedHashMapByValueTest {

    SortedHashMapByValue sortedHashMapByValue = new SortedHashMapByValue();

    @Test
    public void sortWhenMapDontSortedReturnSorted() {
        Map<Integer, String> map = new HashMap<>();
        map.put(13, "f");
        map.put(45, "a");
        map.put(12, "b");
        TreeSet<String> expectedSet = sortedHashMapByValue.sort(map);
        assertEquals("[a, b, f]", expectedSet.toString());
    }

}