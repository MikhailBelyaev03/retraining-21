package com.epam.Homework.Generics;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class StorageTest {

    private String expectedString;

    @Mock
    Cache<String> cache = new Cache<>(5);

    @InjectMocks
    private Storage<String> storage = new Storage<>();

    @Test
    public void storageWhenCreateObjectThenUseTheArray() {
        String[] arrayForFillStorage = new String[11];
        arrayForFillStorage[0] = "1";
        arrayForFillStorage[1] = "1";
        arrayForFillStorage[2] = "1";
        arrayForFillStorage[3] = "1";
        arrayForFillStorage[4] = "1";
        arrayForFillStorage[5] = "1";
        arrayForFillStorage[6] = "1";
        arrayForFillStorage[7] = "1";
        arrayForFillStorage[8] = "1";
        arrayForFillStorage[9] = "1";
        arrayForFillStorage[10] = "12";

        Storage<String> storage = new Storage<>(arrayForFillStorage);
        assertNull(storage.getLast());
    }

    @Test
    public void addWhenAddElementThenLastElementIsChange() {
        expectedString = "Misha";
        storage.add("Misha");

        assertEquals(expectedString, storage.getLast());
    }

    @Test
    public void addWhenAddMoreThenCapacityElementsThenChangeCapacity() {
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

        assertNull(storage.get(14));
    }

    @Test
    public void deleteWhenElementIsNotPresentedInCacheThenDeleteFromStorage() {
        storage.add("Misha1");
        storage.add("Misha2");
        when(cache.isPresent("Misha")).thenReturn(false);
        storage.delete("Misha");
        verify(cache, times(0)).delete("Misha");

    }

    @Test
    public void deleteWhenElementPresentedInCacheThenDeleteFromCacheAndStorage() {
        storage.add("Misha1");
        storage.add("Misha2");
        when(cache.isPresent("Misha")).thenReturn(true);
        storage.delete("Misha");
        verify(cache).delete("Misha");
    }

    @Test
    public void deleteWhenElementIsNotNullThenPositive() {
        storage.add("Misha1");
        storage.add("Misha2");
        storage.delete("Misha2");
        assertNotEquals("Misha1", storage.getLast());
    }

    @Test
    public void getWhenElementIsNotPresentedInCacheThenDoNothing() {
        expectedString = "Masha";
        storage.add("Masha");
        when(cache.isPresent(0)).thenReturn(false);
        verify(cache, times(0)).add("Masha", 0);
        assertEquals(expectedString, storage.get(0));
    }

    @Test
    public void getWhenElementIsPresentedInCacheThenReturnElement() {
        expectedString = "Masha";
        storage.add("Masha");
        when(cache.isPresent(0)).thenReturn(true);
        when(cache.get(0)).thenReturn(new CacheElement<>("Masha", 0));
        assertEquals(expectedString, storage.get(0));
    }

    @Test
    public void getWhenLastElementIsPresentThenReturnElement() {
        expectedString = "Misha";
        storage.add("Masha");
        storage.add("Misha");
        assertEquals(expectedString, storage.getLast());
    }

    @Test
    public void getWhenEmptyStorageThenReturnNull() {
        Assert.assertNull(storage.getLast());
    }

    @Test
    public void clearWhenStorageClearThenClearCache() {
        storage.clear();
        verify(cache).clear();
    }

    @Test
    public void toStringTest() {
        assertEquals("Storage{storage=[null, null, null, null, null, null, null, null, null, null], cache=cache}", storage.toString());
    }
}