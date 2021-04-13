package com.epam.Homework.Generics;

import java.util.Arrays;
import java.util.Objects;

public class Cache<T> {

    private CacheElement<T>[] cache;

    private int capacity;

    public Cache(int capacity) {
        this.capacity = capacity;
        cache = new CacheElement[capacity];
    }

    public CacheElement<T>[] getCache() {
        return cache;
    }

    public void setCache(CacheElement<T>[] cache) {
        this.cache = cache;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add(T element, int index) {
        CacheElement<T> newCacheElement = new CacheElement<>(element, index);
        boolean marker = false;
        for (int i = 0; i < cache.length; i++) {
            if (cache[i] == null) {
                cache[i] = newCacheElement;
                marker = true;
                break;
            }
        }
        if (!marker) {
            shiftElements(0, cache);
            cache[cache.length - 1] = newCacheElement;
        }
    }

    private static <T> void shiftElements(int startWith, CacheElement<T>[] cache) {
        for (int i = startWith; i < cache.length; i++) {
            if (cache.length - 1 == i) break;
            if (cache[i + 1] == null) {
                cache[i] = null;
                break;
            } else
                cache[i] = cache[i + 1];
        }
    }

    public void delete(T element) {
        for (int i = 0; i < cache.length; i++) {
            if (cache[i] != null) {
                if (cache[i].getElement().equals(element)) {
                    cache[i] = null;
                    shiftElements(i, cache);
                }
            }
        }
    }

    public boolean isPresent(T element) {
        for (CacheElement<T> tCacheElement : cache) {
            if ((tCacheElement != null) && (tCacheElement.getElement().equals(element)))
                return true;
        }
        return false;
    }

    public boolean isPresent(int index) {
        for (CacheElement<T> tCacheElement : cache) {
            if ((tCacheElement != null) && ((tCacheElement.getIndex() == index))) {
                return true;
            }
        }
        return false;
    }

    public CacheElement<T> get(int index) {
        CacheElement<T> currentElement = null;
        int lastIndex = cache.length;
        int currentIndex = -1;
        for (int i = 0; i < cache.length; i++) {
            if (cache[i] != null) {
                if (cache[i].getIndex() == index) {
                    currentElement = cache[i];
                    currentIndex = i;
                }
            }
        }
        for (int i = cache.length - 1; i >= 0; i--) {
            if (cache[i] == null) {
                lastIndex = i;
            }
        }
        if (currentIndex == -1)
            return null;
        else {
            if (lastIndex != currentIndex) {
                shiftElements(currentIndex, cache);
            }
            cache[lastIndex - 1] = currentElement;
            return currentElement;
        }
    }

    public void clear() {
        Arrays.fill(cache, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cache)) return false;
        Cache<?> cache1 = (Cache<?>) o;
        return getCapacity() == cache1.getCapacity() && Arrays.equals(getCache(), cache1.getCache());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getCapacity());
        result = 31 * result + Arrays.hashCode(getCache());
        return result;
    }

    @Override
    public String toString() {
        return "Cache{" +
                "cache=" + Arrays.toString(cache) +
                ", capacity=" + capacity +
                '}';
    }
}
