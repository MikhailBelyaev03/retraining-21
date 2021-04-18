package com.epam.Homework.Collections;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

    @Test
    public void test() {
        User user1 = new User("test1", Role.USER);
        User user2 = new User("test1", Role.USER);

        assertEquals(user1, user2);
    }
}