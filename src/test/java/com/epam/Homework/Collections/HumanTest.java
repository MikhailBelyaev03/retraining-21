package com.epam.Homework.Collections;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class HumanTest {

    Human human1;

    Human human2;

    @Test
    public void setFullNameTest() {
        human1 = new Human("Vasya", 10, new Address("Moscow", "L1", "4d", 14));
        human1.setFullName("Misha");
        assertEquals("Misha", human1.getFullName());
    }

    @Test
    public void setAgeTest() {
        human1 = new Human("Vasya", 10, new Address("Moscow", "L1", "4d", 14));
        human1.setAge(15);
        assertEquals(15, human1.getAge());
    }

    @Test
    public void setAdressTest() {
        human1 = new Human("Vasya", 10, new Address("Moscow", "L1", "4d", 14));
        human1.setAddress(new Address("Moscow", "L2", "4d", 14));
        assertEquals(new Address("Moscow", "L2", "4d", 14), human1.getAddress());
    }

    @Test
    public void equalsTest() {
        human1 = new Human("Vasya", 10, new Address("Moscow", "L1", "4d", 14));
        human2 = new Human("Vasya", 10, new Address("Moscow", "L1", "4d", 14));
        assertEquals(human1, human2);
    }

    @Test
    public void dontEqualsTest() {
        human1 = new Human("Vasya", 10, new Address("Moscow", "L1", "4d", 14));
        human2 = new Human("Vasya2", 10, new Address("Moscow", "L1", "4d", 14));

        assertNotEquals(human1, human2);
    }

    @Test
    public void hashCodeEqualsTest() {
        human1 = new Human("Vasya", 10, new Address("Moscow", "L1", "4d", 14));
        human2 = new Human("Vasya", 10, new Address("Moscow", "L1", "4d", 14));
        assertEquals(human1.hashCode(), human2.hashCode());
    }


    @Test
    public void toStringTest() {
        human1 = new Human("Vasya", 10, new Address("Moscow", "L1", "4d", 14));

        assertThat(human1.toString(), is("\nHuman{FullName='Vasya', age=10, address=Address{city='Moscow', street='L1', house='4d', apartment=14}}"));
    }


}