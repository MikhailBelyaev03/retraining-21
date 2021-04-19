package com.epam.Homework.Collections;

import java.util.Map;
import java.util.TreeSet;

public class SortedHashMapByValue {
    public void sort(Map<Integer, String> map) {
        TreeSet<String> treeMap = new TreeSet<>(map.values());
        System.out.println(treeMap);
    }
}

