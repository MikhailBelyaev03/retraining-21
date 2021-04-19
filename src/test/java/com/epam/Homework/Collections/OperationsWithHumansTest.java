package com.epam.Homework.Collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class OperationsWithHumansTest {

    private final PrintStream standardOut = System.out;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void findDuplicatesTest() {
        List<Human> actualListOfHumans = new ArrayList<>();
        actualListOfHumans.add(new Human("Vasya", 14, new Address("Moscow", "Lad", "1a", 154)));
        actualListOfHumans.add(new Human("Vera", 15, new Address("Moscow", "Lad", "1a", 154)));
        actualListOfHumans.add(new Human("Vasya", 14, new Address("Moscow", "Lad", "1a", 154)));
        OperationsWithHumans.findDuplicates(actualListOfHumans);
        assertEquals("Find duplicates of Human - \n" +
                "Human{FullName='Vasya', age=14, address=Address{city='Moscow', street='Lad', house='1a', apartment=154}}", outputStreamCaptor.toString()
                .trim());
    }

    @Test
    public void getDuplicateListTest() {
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
    public void deleteDuplicatesTest() {
        List<Human> actualListOfHumans = new ArrayList<>();
        actualListOfHumans.add(new Human("Vasya", 14, new Address("Moscow", "Lad", "1a", 154)));
        actualListOfHumans.add(new Human("Vera", 15, new Address("Moscow", "Lad", "1a", 154)));
        actualListOfHumans.add(new Human("Vasya", 14, new Address("Moscow", "Lad", "1a", 154)));

        OperationsWithHumans.deleteDuplicates(actualListOfHumans);
        assertEquals(2, actualListOfHumans.size());
    }

}