package com.epam.Homework.Collections;

import java.util.*;

public class SortedHashMapByValue {

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

        TreeSet<Map.Entry<Integer, String>> sortedSet = new TreeSet<Map.Entry<Integer, String>>(
                new Comparator<Map.Entry<Integer, String>>() {
                    @Override
                    public int compare(Map.Entry<Integer, String> e1, Map.Entry<Integer, String> e2) {
                        int res = e1.getValue().compareTo(e2.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedSet.addAll(map.entrySet());
        System.out.println(sortedSet);
    }
}

