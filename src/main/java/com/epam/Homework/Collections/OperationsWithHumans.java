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

        Comparator<Human> sortByName = Comparator.comparing(o1 -> o1.getFullName());
        Collections.sort(list, sortByName);
        System.out.println("Sorted by Name");
        System.out.println(list);

        Comparator<Human> sortByAge = Comparator.comparing(o1 -> o1.getAge());
        Collections.sort(list, sortByAge);
        System.out.println("Sorted by Age");
        System.out.println(list);

        Comparator<Human> sortByAddress = Comparator.comparing(o1 -> o1.getAddress());
        System.out.println("Sorted by Address");
        Collections.sort(list, sortByAddress);
        System.out.println(list);

    }

    public static void findDuplicates(List<Human> list) {
        Map<Human, Integer> duplicatesOfHuman = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (duplicatesOfHuman.containsKey(list.get(i))) {
                int value = duplicatesOfHuman.get(list.get(i));
                duplicatesOfHuman.put(list.get(i), value + 1);
            } else
                duplicatesOfHuman.put(list.get(i), 1);
        }
        for (Map.Entry<Human, Integer> currentHuman : duplicatesOfHuman.entrySet()) {
            if (currentHuman.getValue() > 1) {
                System.out.println(String.format("Find duplicates of Human - %s \n", currentHuman.getKey()));
            }
        }
    }

    public static void deleteDuplicates(List<Human> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if ((list.get(i).equals(list.get(j))) && (i != j)) {
                    list.remove(j);
                }
            }
        }
    }

}
