package main.java.com.epam.homework.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

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
        map = sortMap(map);
        System.out.println(map);

    }

    public static Map<Integer,String> sortMap(Map<Integer, String> map) {

        Comparator<Map.Entry<Integer,String>> comparator = new Comparator<>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        };

        Set<Map.Entry<Integer, String>> entry = map.entrySet();
        List<Map.Entry<Integer, String>> listT = new ArrayList<>(entry);
        Collections.sort(listT,comparator);

        Map<Integer,String> lm = new LinkedHashMap<>();
        for (Map.Entry<Integer,String> l :listT){
            lm.put(l.getKey(),l.getValue());
        }
        return lm;}

}
