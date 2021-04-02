package com.epam.Homework.Collections;

import java.util.HashMap;
import java.util.Map;

public class GreetingUser {

    private static Map<Role, String> userRoles = new HashMap<>();

    static {
        userRoles.put(Role.ADMIN, "Administrator");
        userRoles.put(Role.USER, "Consumer");
        userRoles.put(Role.MODERATOR, "Chairman");
    }

    public static void main(String[] args) {
        User user1 = new User("John Doe", Role.USER);
        greeting(user1);
        User user2 = new User("John Smith", Role.ADMIN);
        greeting(user2);
        User user3 = new User("Rick Black", Role.MODERATOR);
        greeting(user3);
    }

    public static void greeting(User u) {
        System.out.println("Greeting, "+u.getFullName()+"! You're now a "+userRoles.get(u.getRole()));
    }
}
