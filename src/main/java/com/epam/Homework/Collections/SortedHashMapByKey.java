package com.epam.Homework.Collections;

import java.util.Map;
import java.util.TreeMap;

public class SortedHashMapByKey {
    public Map<Integer, String> sort(Map<Integer, String> map) {
        return new TreeMap<>(map);
    }
}
