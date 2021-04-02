package com.epam.Homework.Collections;

import java.util.Objects;

public class Human {

    private String FullName;

    private int age;

    private Address address;

    public Human(String fullName, int age, Address address) {
        FullName = fullName;
        this.age = age;
        this.address = address;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return age == human.age && FullName.equals(human.FullName) && Objects.equals(address, human.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FullName, age, address);
    }

    @Override
    public String toString() {
        return "\n" + "Human{" +
                "FullName='" + FullName + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

}