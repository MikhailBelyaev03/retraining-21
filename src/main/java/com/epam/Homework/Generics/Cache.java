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
        int indexForAdd = -1;
        for (int i = cache.length - 1; i > 0; i--) {
            if ((cache[i] == null) && (cache[i - 1] != null)) {
                indexForAdd = i;
            }
        }
        if (indexForAdd == -1) {
            indexForAdd = cache.length - 1;
        }
        if ((indexForAdd >= cache.length - 1) && (cache[cache.length - 1] != null)) {
            for (int i = 0; i < indexForAdd; i++) {
                cache[i] = cache[i + 1];
            }
        }
        cache[indexForAdd] = newCacheElement;

// }

    }

    public void delete(T element) {
        int lastIndex = -1;
        for (int i = 0; i < cache.length - 1; i++) {
            if (cache[i].getElement().equals(element)) {
                for (int j = i; j <= cache.length - 2; j++) {
                    if (cache[j] == null) {
                        lastIndex = j;
                    }
                    cache[j] = cache[j + 1];
                }
            }
        }
        if (lastIndex != -1) {
            cache[lastIndex] = null;
        } else {
            cache[cache.length - 1] = null;
        }
    }

    public boolean isPresent(T element) {
        boolean marker = false;
        for (int i = 0; i < cache.length; i++) {
            if (cache[i] != null) {
                if (cache[i].getElement().equals(element)) {
                    marker = true;
                    break;
                }
            }
        }
        return marker;
    }

    public boolean isPresent(int index) {
        boolean marker = false;
        for (int i = 0; i < cache.length; i++) {
            if (cache[i] != null) {
                if (cache[i].getIndex() == index) {
                    marker = true;
                    break;
                }
            }
        }
        return marker;
    }

    public CacheElement<T> get(int index) {
        CacheElement<T> currentElement = null;
        int lastIndex = -1;
        int currentIndex = -1;
        for (int i = 0; i < cache.length; i++) {
            if (cache[i] != null) {
                if (cache[i].getIndex() == index) {
                    currentElement = cache[i];
                    currentIndex = i;
                }
            }
        }
        if (currentElement != null) {
            if (currentIndex != cache.length - 1) {
                for (int i = currentIndex; i < cache.length - 1; i++) {
                    cache[i] = cache[i + 1];
                }
                for (int i = cache.length - 1; i >= 0; i--) {
                    if (cache[i] == null) {
                        lastIndex = i;
                    }
                }

            } else lastIndex = currentIndex;
            cache[lastIndex] = currentElement;
        }
        return currentElement;
    }

    public void clear() {
        boolean marker = false;
        for (int i = 0; i < cache.length; i++) {
            cache[i] = null;
        }
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
