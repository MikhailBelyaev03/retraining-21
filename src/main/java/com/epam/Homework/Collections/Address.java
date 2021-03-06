package com.epam.Homework.Collections;

import java.util.Comparator;
import java.util.Objects;

public class Address implements Comparable<Address> {

    private String city;

    private String street;

    private String house;

    private int apartment;


    public Address(String city, String street, String house, int apartment) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return apartment == address.apartment && city.equals(address.city) && street.equals(address.street) && house.equals(address.house);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, house, apartment);
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", apartment=" + apartment +
                '}';
    }

    @Override
    public int compareTo(Address o) {
        return Comparator.comparing(Address::getCity)
                .thenComparing(Address::getStreet)
                .thenComparing(Address::getHouse)
                .thenComparingInt(Address::getApartment)
                .compare(this, o);
    }
}
