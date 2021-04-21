package com.epam.Homework.Collections;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SortedHashMapByKeyTest {

    SortedHashMapByKey sortedHashMapByKey = new SortedHashMapByKey();

    @Test
    public void sortWhenMapDontSortedReturnSorted() {
        Map<Integer, String> map = new HashMap<>();
        map.put(13, "f");
        map.put(45, "a");
        map.put(12, "b");
        sortedHashMapByKey.sort(map);
        assertEquals("{12=b, 13=f, 45=a}", map.toString());
    }
}