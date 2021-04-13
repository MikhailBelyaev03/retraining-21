package com.epam.Homework.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationsWithHumans {

    public static void main(String[] args) {
        Human human1 = new Human("Василий Иванович Петров", 34, new Address("Москва", "ул.Ленина", "34а", 156));
        Human human2 = new Human("Иван Иванович Носов", 45, new Address("Москва", "ул.Кулибина", "13", 45));
        Human human3 = new Human("Юрий Владимирович Пастухов", 16, new Address("Москва", "ул.Льва Толстого", "8", 78));
        Human human4 = new Human("Олег Юрьевич Кузьмин", 33, new Address("Уфа", "ул.Ленина", "8а", 25));
        Human human5 = new Human("Олег Юрьевич Кузьмин", 33, new Address("Уфа", "ул.Ленина", "8а", 25));
        Human human6 = new Human("Василий Иванович Петров", 34, new Address("Москва", "ул.Ленина", "34а", 156));
        Human human7 = new Human("Олег Юрьвич Пономаренко", 56, new Address("Тольятти", "ул.Карбышева", "14", 48));
        Human human8 = new Human("Олег Юрьвич Пономаренко", 56, new Address("Тольятти", "ул.Карбышева", "14", 48));
        Human human9 = new Human("Василий Иванович Супрун", 34, new Address("Москва", "ул.Ленина", "34а", 14));
        Human human10 = new Human("Василий Иванович Латышев", 34, new Address("Москва", "ул.Ленина", "34а", 152));

        List<Human> list = new ArrayList<>();
        list.add(human1);
        list.add(human2);
        list.add(human3);
        list.add(human4);
        list.add(human5);
        list.add(human6);
        list.add(human7);
        list.add(human8);
        list.add(human9);
        list.add(human10);

        findDuplicates(list);
        deleteDuplicates(list);

        Comparator<Human> sortByName = Comparator.comparing(Human::getFullName);
        list.sort(sortByName);
        System.out.println("Sorted by Name");
        System.out.println(list);

        Comparator<Human> sortByAge = Comparator.comparing(Human::getAge);
        list.sort(sortByAge);
        System.out.println("Sorted by Age");
        System.out.println(list);

        Comparator<Human> sortByAddress = Comparator.comparing(Human::getAddress);
        System.out.println("Sorted by Address");
        list.sort(sortByAddress);
        System.out.println(list);

    }

    public static void findDuplicates(List<Human> list) {
        Map<Human, Integer> duplicatesOfHuman = getDuplicatesList(list);
        for (Map.Entry<Human, Integer> currentHuman : duplicatesOfHuman.entrySet()) {
            if (currentHuman.getValue() > 1) {
                System.out.format("Find duplicates of Human - %s \n", currentHuman.getKey());
            }
        }
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
