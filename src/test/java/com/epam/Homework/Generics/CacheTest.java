package com.epam.Homework.Generics;

import org.junit.Test;

import static org.junit.Assert.*;

public class CacheTest {

    private Cache<String> actualCache = new Cache<>(5);

    private static CacheElement<String> expectedCacheElement;

    @Test
    public void addWhenElementIsNotNullThenElementContainsInCache() {
        expectedCacheElement = new CacheElement<>("Misha", 4782);
        actualCache.add("Misha", 4782);

        assertEquals(expectedCacheElement, actualCache.get(4782));
    }

    @Test
    public void addWhenCapacityOfCacheDontEnoughThenShiftElements() {
        expectedCacheElement = new CacheElement<>("Misha", 4782);
        actualCache.add("Misha", 4782);
        actualCache.add("Victor", 2225);
        actualCache.add("Marysya", 4752);
        actualCache.add("Stepan", 7745);
        actualCache.add("Lera", 6354);
        actualCache.add("Dana", 6254);

        assertFalse(actualCache.isPresent(4782));
    }

    @Test
    public void deleteWhenElementNotNullElementFromCache() {
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
    public void isPresentWhenElementInCacheThenPositive() {
        Cache<String> actualCache = new Cache<>(5);
        actualCache.add("Lera", 6354);

        assertTrue(actualCache.isPresent("Lera"));
    }

    @Test
    public void isPresentWhenElementIsNotInCacheThenNegative() {
        actualCache.add("Stepan", 7745);
        actualCache.add("Lera", 6354);

        assertFalse(actualCache.isPresent("Yura"));
    }

    @Test
    public void isPresentWhenElementByIndexInCacheThenPositive() {
        actualCache.add("Lera", 6354);

        assertTrue(actualCache.isPresent(6354));
    }

    @Test
    public void isPresentWhenElementByIndexIsNotInCacheThenNegative() {
        actualCache.add("Stepan", 7745);
        actualCache.add("Lera", 6354);

        assertFalse(actualCache.isPresent(6666));
    }

    @Test
    public void getWhenElementIsInCacheThenReturnElement() {
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
    public void getWhenElementIsInCacheThenReturnNull() {
        expectedCacheElement = new CacheElement<>("Vasya", 1111);
        actualCache.add("Misha", 4782);
        actualCache.add("Victor", 2225);
        actualCache.add("Marysya", 4752);
        actualCache.add("Stepan", 7745);
        actualCache.add("Lera", 6354);

        assertNull(actualCache.get(1111));
    }


    @Test
    public void clearAllWhenCacheIsNotEmptyThenClearAllCache() {
        actualCache.add("Stepan", 7745);
        actualCache.add("Lera", 6354);
        actualCache.clear();

        assertFalse(actualCache.isPresent(7745));
        assertFalse(actualCache.isPresent(6354));
    }

    @Test
    public void getCapacity() {
        assertEquals(5, actualCache.getCapacity());
    }

    @Test
    public void toStringTest() {
        assertEquals("Cache{cache=[null, null, null, null, null], capacity=5}", actualCache.toString());
    }

}