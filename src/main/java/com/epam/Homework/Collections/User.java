package com.epam.Homework.Collections;

import java.util.Objects;

public class User {

    private String FullName;

    private Role role;

    public User(String fullName, Role role) {
        FullName = fullName;
        this.role = role;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getFullName(), user.getFullName()) && getRole() == user.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFullName(), getRole());
    }

    @Override
    public String toString() {
        return "User{" +
                "FullName='" + FullName + '\'' +
                ", role=" + role +
                '}';
    }
}
