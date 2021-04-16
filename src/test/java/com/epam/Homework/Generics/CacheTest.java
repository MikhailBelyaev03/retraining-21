package com.epam.Homework.Generics;

import org.junit.Assert;
import org.junit.Test;

public class CacheTest {
    private Cache<String> expectedCache = new Cache<String>(5);

    private static CacheElement expectedCacheElement;

    private Cache<String> actualCache = new Cache<>(5);

    @Test
    public void AddOneElementToCache() {
        expectedCacheElement = new CacheElement("Misha", 4782);
        actualCache.add("Misha", 4782);
        actualCache.add("Victor", 2225);
        actualCache.add("Marysya", 4752);
        actualCache.add("Stepan", 7745);
        actualCache.add("Lera", 6354);

        Assert.assertEquals(expectedCacheElement, actualCache.get(4782));
    }

    @Test
    public void AddMoreThenCapacityElements() {
        expectedCacheElement = new CacheElement("Masha", 4456);

        actualCache.add("Masha", 4456);
        actualCache.add("Misha", 4782);
        actualCache.add("Victor", 2225);
        actualCache.add("Marysya", 4752);
        actualCache.add("Stepan", 7745);
        actualCache.add("Lera", 6354);

        Assert.assertNotEquals(expectedCacheElement, actualCache.get(4782));
    }

    @Test
    public void DeleteOneElementFromCache() {
        expectedCacheElement = new CacheElement("Misha", 4782);

        actualCache.add("Misha", 4782);
        actualCache.add("Victor", 2225);
        actualCache.add("Marysya", 4752);
        actualCache.add("Stepan", 7745);
        actualCache.add("Lera", 6354);
        actualCache.delete("Marysya");

        Assert.assertNull(actualCache.get(4752));
    }

    @Test
    public void ElementPresentByElementInCache() {
        Cache<String> actualCache = new Cache<>(5);
        actualCache.add("Lera", 6354);

        Assert.assertTrue(actualCache.isPresent("Lera"));
    }

    @Test
    public void ElementNotPresentByElementInCache() {
        actualCache.add("Stepan", 7745);
        actualCache.add("Lera", 6354);

        Assert.assertFalse(actualCache.isPresent("Yura"));
    }

    @Test
    public void ElementPresentByIndexInCache() {
        actualCache.add("Lera", 6354);

        Assert.assertTrue(actualCache.isPresent(6354));
    }

    @Test
    public void ElementNotPresentByIndexInCache() {
        actualCache.add("Stepan", 7745);
        actualCache.add("Lera", 6354);

        Assert.assertFalse(actualCache.isPresent(6666));
    }

    @Test
    public void getPresentElementFromCache() {
        expectedCacheElement = new CacheElement("Misha", 4782);
        actualCache.add("Misha", 4782);
        actualCache.add("Victor", 2225);
        actualCache.add("Marysya", 4752);
        actualCache.add("Stepan", 7745);
        actualCache.add("Lera", 6354);

        actualCache.get(4752);

        Assert.assertEquals(expectedCacheElement, actualCache.get(4782));
    }

    @Test
    public void getNotPresentElementFromCache() {
        expectedCacheElement = new CacheElement("Vasya", 1111);
        actualCache.add("Misha", 4782);
        actualCache.add("Victor", 2225);
        actualCache.add("Marysya", 4752);
        actualCache.add("Stepan", 7745);
        actualCache.add("Lera", 6354);

        Assert.assertNull(actualCache.get(1111));
    }


    @Test
    public void ClearAllCache() {
        actualCache.add("Stepan", 7745);
        actualCache.add("Lera", 6354);
        actualCache.clear();

        Assert.assertFalse(actualCache.isPresent(7745));
        Assert.assertFalse(actualCache.isPresent(6354));
    }
}