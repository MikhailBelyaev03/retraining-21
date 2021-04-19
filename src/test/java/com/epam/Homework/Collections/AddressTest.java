package com.epam.Homework.Collections;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AddressTest {

    Address address1;

    Address address2;

    @Test
    public void setCityTest() {
        address1 = new Address("Moscow", "L1", "4d", 14);
        address1.setCity("London");
        assertEquals("London", address1.getCity());
    }

    @Test
    public void setStreetTest() {
        address1 = new Address("Moscow", "L1", "4d", 14);
        address1.setStreet("L2");
        assertEquals("L2", address1.getStreet());
    }

    @Test
    public void setHouseTest() {
        address1 = new Address("Moscow", "L1", "4d", 14);
        address1.setHouse("7b");
        assertEquals("7b", address1.getHouse());
    }

    @Test
    public void setApartmentTest() {
        address1 = new Address("Moscow", "L1", "4d", 14);
        address1.setApartment(45);
        assertEquals(45, address1.getApartment());
    }

    @Test
    public void compareTwoAddressesTest() {
        address1 = new Address("Moscow", "L1", "4d", 14);
        address2 = new Address("Moscow", "L2", "4d", 14);
        assertEquals(-1, address1.compareTo(address2));
    }

    @Test
    public void equalsTest() {
        address1 = new Address("Moscow", "L1", "4d", 14);
        address2 = new Address("Moscow", "L1", "4d", 14);
        assertEquals(address1, address2);
    }

    @Test
    public void dontEqualsTest() {
        address1 = new Address("Moscow", "L1", "4d", 14);
        address2 = new Address("Moscow", "L2", "4d", 14);

        assertNotEquals(address1, address2);
    }

    @Test
    public void hashCodeEqualsTest() {
        address1 = new Address("Moscow", "L1", "4d", 14);
        address2 = new Address("Moscow", "L1", "4d", 14);
        assertEquals(address1.hashCode(), address2.hashCode());
    }

    @Test
    public void toStringTest() {
        address1 = new Address("Moscow", "L1", "4d", 14);
        assertThat(address1.toString(), is("Address{city='Moscow', street='L1', house='4d', apartment=14}"));
    }


}