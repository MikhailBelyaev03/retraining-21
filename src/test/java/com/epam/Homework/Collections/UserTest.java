package com.epam.Homework.Collections;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserTest {

    User user1;

    User user2;

    @Before
    public void setUp() {
        user1 = new User("test1", Role.USER);
    }


    @Test
    public void setFullName() {

        user1.setFullName("test2");
        assertEquals("test2", user1.getFullName());
    }

    @Test
    public void setRole() {
        user1.setRole(Role.ADMIN);
        assertEquals(Role.ADMIN, user1.getRole());
    }

    @Test
    public void equals() {
        user2 = new User("test1", Role.USER);
        assertEquals(user1, user2);
    }

    @Test
    public void dontEquals() {
        user2 = new User("test2", Role.USER);

        assertNotEquals(user1, user2);
    }

    @Test
    public void hashCodeEquals() {
        user2 = new User("test1", Role.USER);
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    public void toStringTest() {
        assertThat(user1.toString(), is("User{FullName='test1', role=USER}"));
    }
}