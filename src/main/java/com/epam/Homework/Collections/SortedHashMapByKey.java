package com.epam.Homework.Collections;

import java.util.*;

public class SortedHashMapByKey {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(13, "f");
        map.put(45, "a");
        map.put(12, "b");
        map.put(5, "c");
        map.put(53, "d");
        map.put(109, "e");
        map.put(455, "f");
        map.put(2, "f");

        Map<Integer, String> duplicateMap = new TreeMap<>();
        for (Map.Entry<Integer, String> l : map.entrySet()) {
            duplicateMap.put(l.getKey(), l.getValue());
        }
        System.out.println(duplicateMap);
    }
}
