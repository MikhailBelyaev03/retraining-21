package com.epam.Homework.Generics;

import org.junit.Test;

import static org.junit.Assert.*;

public class CacheTest {

    private Cache<String> actualCache = new Cache<>(5);

    private static CacheElement<String> expectedCacheElement;

    @Test
    public void addOneElementToCacheTest() {
        expectedCacheElement = new CacheElement<>("Misha", 4782);
        actualCache.add("Misha", 4782);
        actualCache.add("Victor", 2225);
        actualCache.add("Marysya", 4752);
        actualCache.add("Stepan", 7745);
        actualCache.add("Lera", 6354);

        assertEquals(expectedCacheElement, actualCache.get(4782));
    }

    @Test
    public void addMoreThenCapacityElementsTest() {
        expectedCacheElement = new CacheElement<>("Masha", 4456);

        actualCache.add("Masha", 4456);
        actualCache.add("Misha", 4782);
        actualCache.add("Victor", 2225);
        actualCache.add("Marysya", 4752);
        actualCache.add("Stepan", 7745);
        actualCache.add("Lera", 6354);

        assertNotEquals(expectedCacheElement, actualCache.get(4782));
    }

    @Test
    public void deleteOneElementFromCacheTest() {
        expectedCacheElement = new CacheElement<>("Misha", 4782);

        actualCache.add("Misha", 4782);
        actualCache.add("Victor", 2225);
        actualCache.add("Marysya", 4752);
        actualCache.add("Stepan", 7745);
        actualCache.add("Lera", 6354);
        actualCache.delete("Marysya");

        assertNull(actualCache.get(4752));
    }

    @Test
    public void elementPresentByElementInCacheTest() {
        Cache<String> actualCache = new Cache<>(5);
        actualCache.add("Lera", 6354);

        assertTrue(actualCache.isPresent("Lera"));
    }

    @Test
    public void elementNotPresentByElementInCacheTest() {
        actualCache.add("Stepan", 7745);
        actualCache.add("Lera", 6354);

        assertFalse(actualCache.isPresent("Yura"));
    }

    @Test
    public void elementPresentByIndexInCacheTest() {
        actualCache.add("Lera", 6354);

        assertTrue(actualCache.isPresent(6354));
    }

    @Test
    public void elementNotPresentByIndexInCacheTest() {
        actualCache.add("Stepan", 7745);
        actualCache.add("Lera", 6354);

        assertFalse(actualCache.isPresent(6666));
    }

    @Test
    public void getPresentElementFromCacheTest() {
        expectedCacheElement = new CacheElement<>("Misha", 4782);
        actualCache.add("Misha", 4782);
        actualCache.add("Victor", 2225);
        actualCache.add("Marysya", 4752);
        actualCache.add("Stepan", 7745);
        actualCache.add("Lera", 6354);

        actualCache.get(4752);

        assertEquals(expectedCacheElement, actualCache.get(4782));
    }

    @Test
    public void getNotPresentElementFromCacheTest() {
        expectedCacheElement = new CacheElement<>("Vasya", 1111);
        actualCache.add("Misha", 4782);
        actualCache.add("Victor", 2225);
        actualCache.add("Marysya", 4752);
        actualCache.add("Stepan", 7745);
        actualCache.add("Lera", 6354);

        assertNull(actualCache.get(1111));
    }


    @Test
    public void clearAllCacheTest() {
        actualCache.add("Stepan", 7745);
        actualCache.add("Lera", 6354);
        actualCache.clear();

        assertFalse(actualCache.isPresent(7745));
        assertFalse(actualCache.isPresent(6354));
    }

    @Test
    public void getCapacityTest() {
        assertEquals(5, actualCache.getCapacity());
    }

    @Test
    public void toStringTest() {
        assertEquals("Cache{cache=[null, null, null, null, null], capacity=5}", actualCache.toString());
    }
}