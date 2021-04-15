package com.epam.Homework.Generics;

import java.util.Arrays;

public class Cache<T> {

    private CacheElement<T>[] cache;

    private int capacity;

    public Cache(int capacity) {
        this.capacity = capacity;
        cache = new CacheElement[capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(T element, int index) {
        CacheElement<T> newCacheElement = new CacheElement<>(element, index);
        boolean marker = false;
        for (int i = 0; i < cache.length; i++) {
            if (cache[i] == null) {
                cache[i] = newCacheElement;
                return;
            }
        }
        shiftElements(0, cache);
        cache[cache.length - 1] = newCacheElement;
    }

    public void delete(T element) {
        for (int i = 0; i < cache.length; i++) {
            if ((cache[i] != null) && (cache[i].getElement().equals(element))) {
                cache[i] = null;
                shiftElements(i, cache);
            }
        }
    }

    public boolean isPresent(T element) {
        for (CacheElement<T> CacheElement : cache) {
            if (CacheElement != null && CacheElement.getElement().equals(element)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPresent(int index) {
        for (CacheElement<T> CacheElement : cache) {
            if ((CacheElement != null) && ((CacheElement.getIndex() == index))) {
                return true;
            }
        }
        return false;
    }

    public CacheElement<T> get(int index) {
        int lastIndex = cache.length;
        for (int i = cache.length - 1; i >= 0; i--) {
            if (cache[i] == null) {
                lastIndex = i;
            }
        }
        CacheElement<T> currentElement = null;
        for (int i = 0; i < cache.length; i++) {
            if (cache[i] != null) {
                if (cache[i].getIndex() == index) {
                    if (lastIndex != i) {
                        currentElement = cache[i];
                        shiftElements(i, cache);
                    }
                    cache[lastIndex - 1] = currentElement;
                    return cache[i];

                }
            }
        }
        return null;
    }

    public void clear() {
        Arrays.fill(cache, null);
    }

    private <T> void shiftElements(int startWith, CacheElement<T>[] cache) {
        for (int i = startWith; i < cache.length; i++) {
            if (cache.length - 1 == i) break;
            if (cache[i + 1] == null) {
                cache[i] = null;
                break;
            } else
                cache[i] = cache[i + 1];
        }
    }

    @Override
    public String toString() {
        return "Cache{" +
                "cache=" + Arrays.toString(cache) +
                ", capacity=" + capacity +
                '}';
    }
}
