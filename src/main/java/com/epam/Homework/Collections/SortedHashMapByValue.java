package com.epam.Homework.Collections;

import java.util.Map;
import java.util.TreeSet;

public class SortedHashMapByValue {
    public TreeSet<String> sort(Map<Integer, String> map) {
        return new TreeSet<>(map.values());
    }
}

