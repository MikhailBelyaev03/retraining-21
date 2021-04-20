package com.epam.Homework.Collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class OperationsWithHumansTest {

    @Test
    public void findDuplicatesWhenThereAreDuplicatesInListReturnListOfDoubles() {
        List<Human> expectedListOfHumans = new ArrayList<>();
        expectedListOfHumans.add(new Human("Vasya", 14, new Address("Moscow", "Lad", "1a", 154)));
        List<Human> actualListOfHumans = new ArrayList<>();
        actualListOfHumans.add(new Human("Vasya", 14, new Address("Moscow", "Lad", "1a", 154)));
        actualListOfHumans.add(new Human("Vera", 15, new Address("Moscow", "Lad", "1a", 154)));
        actualListOfHumans.add(new Human("Vasya", 14, new Address("Moscow", "Lad", "1a", 154)));
        actualListOfHumans = OperationsWithHumans.findDuplicates(actualListOfHumans);
        assertEquals(expectedListOfHumans, actualListOfHumans);
    }

    @Test
    public void getDuplicatesListReturnListOfHumanWithCountOfPresented() {
        Map<Human, Integer> expectedDuplicatesOfHuman = new HashMap<>();
        expectedDuplicatesOfHuman.put(new Human("Vasya", 14, new Address("Moscow", "Lad", "1a", 154)), 2);
        expectedDuplicatesOfHuman.put(new Human("Vera", 15, new Address("Moscow", "Lad", "1a", 154)), 1);
        List<Human> actualListOfHumans = new ArrayList<>();
        actualListOfHumans.add(new Human("Vasya", 14, new Address("Moscow", "Lad", "1a", 154)));
        actualListOfHumans.add(new Human("Vera", 15, new Address("Moscow", "Lad", "1a", 154)));
        actualListOfHumans.add(new Human("Vasya", 14, new Address("Moscow", "Lad", "1a", 154)));
        assertEquals(expectedDuplicatesOfHuman, OperationsWithHumans.getDuplicatesList(actualListOfHumans));
    }

    @Test
    public void deleteDuplicatesTestWhenThereAreADuplicatesThenDeleteDuplicatesFromList() {
        List<Human> actualListOfHumans = new ArrayList<>();
        actualListOfHumans.add(new Human("Vasya", 14, new Address("Moscow", "Lad", "1a", 154)));
        actualListOfHumans.add(new Human("Vera", 15, new Address("Moscow", "Lad", "1a", 154)));
        actualListOfHumans.add(new Human("Vasya", 14, new Address("Moscow", "Lad", "1a", 154)));

        OperationsWithHumans.deleteDuplicates(actualListOfHumans);
        assertEquals(2, actualListOfHumans.size());
    }

}