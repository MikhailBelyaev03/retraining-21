package com.epam.Homework.Generics;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StorageTest {

    private String expectedString;

    @Mock
    Cache cache = new Cache(5);

    @InjectMocks
    private Storage<String> storage = new Storage<String>();

    @Test
    public void AddOneElementToStorage() {
        expectedString = new String("Misha");
        storage.add("Misha");

        assertEquals(expectedString, storage.getLast());
    }

    @Test
    public void AddMoreThenCapacityElementsToStorage() {
        storage.add("Misha1");
        storage.add("Misha2");
        storage.add("Misha3");
        storage.add("Misha4");
        storage.add("Misha5");
        storage.add("Misha6");
        storage.add("Misha7");
        storage.add("Misha8");
        storage.add("Misha9");
        storage.add("Misha10");
        storage.add("Misha11");
        storage.add("Misha12");

        Assert.assertNull(storage.get(14));
    }

    @Test
    public void deleteElementIsNotPresentedInCache() {
        storage.add("Misha1");
        storage.add("Misha2");
        when(cache.isPresent("Misha")).thenReturn(false);
        storage.delete("Misha");
        verify(cache, times(0)).delete("Misha");

    }

    @Test
    public void deleteElementIsPresentedInCache() {
        storage.add("Misha1");
        storage.add("Misha2");
        when(cache.isPresent("Misha")).thenReturn(true);
        storage.delete("Misha");
        verify(cache).delete("Misha");
    }

    @Test
    public void deleteElementPresentedInStorage() {
        storage.add("Misha1");
        storage.add("Misha2");
        storage.delete("Misha2");
        assertNotEquals("Misha1", storage.getLast());
    }

    @Test
    public void getElementIsNotPresentedInCache() {
        expectedString = "Masha";
        storage.add("Masha");
        when(cache.isPresent(0)).thenReturn(false);
        verify(cache, times(0)).add("Masha", 0);
        assertEquals(expectedString, storage.get(0));
    }

    @Test
    public void getElementIsPresentedInCache() {
        expectedString = "Masha";
        storage.add("Masha");
        when(cache.isPresent(0)).thenReturn(true);
        when(cache.get(0)).thenReturn(new CacheElement("Masha", 0));
        assertEquals(expectedString, storage.get(0));
    }

    @Test
    public void getLastElementFromStorage() {
        expectedString = new String("Misha");
        storage.add("Masha");
        storage.add("Misha");

        assertEquals(expectedString, storage.getLast());
    }

    @Test
    public void getLastElementFromEmptyStorage() {
        Assert.assertNull(storage.getLast());
    }

    @Test
    public void ClearAllCacheTest() {
        storage.clear();
        verify(cache).clear();
    }
}