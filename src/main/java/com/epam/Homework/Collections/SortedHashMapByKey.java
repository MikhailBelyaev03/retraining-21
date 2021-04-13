package com.epam.Homework.Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
        
        System.out.println(new TreeMap<>(map));
    }
}
