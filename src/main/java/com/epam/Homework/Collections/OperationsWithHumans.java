package com.epam.Homework.Collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationsWithHumans {

    public static void main(String[] args) {
    }

    public static List<Human> findDuplicates(List<Human> list) {
        Map<Human, Integer> duplicatesOfHuman = getDuplicatesList(list);
        List<Human> doublesOfHuman = new ArrayList<>();
        for (Map.Entry<Human, Integer> currentHuman : duplicatesOfHuman.entrySet()) {
            if (currentHuman.getValue() > 1) {
                doublesOfHuman.add(currentHuman.getKey());
            }
        }
        return doublesOfHuman;
    }

    public static Map<Human, Integer> getDuplicatesList(List<Human> list) {
        Map<Human, Integer> duplicatesOfHuman = new HashMap<>();
        for (Human human : list) {
            if (duplicatesOfHuman.containsKey(human)) {
                int value = duplicatesOfHuman.get(human);
                duplicatesOfHuman.put(human, value + 1);
            } else
                duplicatesOfHuman.put(human, 1);
        }
        return duplicatesOfHuman;
    }

    public static void deleteDuplicates(List<Human> list) {
        Map<Human, Integer> duplicatesOfHuman = getDuplicatesList(list);
        for (Map.Entry<Human, Integer> currentHuman : duplicatesOfHuman.entrySet()) {
            if (currentHuman.getValue() > 1) {
                list.remove(currentHuman.getKey());
            }
        }
    }

}
