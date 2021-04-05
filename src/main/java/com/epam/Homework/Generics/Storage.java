package com.epam.Homework.Generics;

import java.util.Arrays;
import java.util.Objects;

public class Storage<T> {

    private T[] storage;

    private Cache<T> cache;

    public Storage() {
        this.storage = (T[]) new Object[10];
        this.cache = new Cache<T>(10);
    }

    public Storage(T[] storage) {
        int capacity = 10;
        while (capacity < storage.length) {
            capacity = (int) (capacity * 1.5);
        }
        this.storage = (T[]) new Object[capacity];
        for (int i = 0; i < storage.length; i++) {
            this.storage[i] = storage[i];
        }
        this.cache = new Cache<T>(10);
    }

    public T[] getStorage() {
        return storage;
    }

    public void setStorage(T[] storage) {
        this.storage = storage;
    }

    public Cache<T> getCache() {
        return cache;
    }

    public void setCache(Cache<T> cache) {
        this.cache = cache;
    }

    public void add(T element) {
        if (storage[storage.length - 1] != null) {
            storage = Arrays.copyOf(storage, (int) (this.storage.length * 1.5));
        }
        int lastIndex = -1;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                lastIndex = i;
                break;
            }
        }
        if (lastIndex != -1) {
            storage[lastIndex] = element;
        }
    }

    public void delete(T element) {
        int lastIndex = -1;
        if (cache.isPresent(element)) {
            cache.delete(element);
        }
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                lastIndex = i;
                break;
            }
        }
        if (lastIndex != -1) {
            storage[lastIndex] = null;
        }
    }

    public T getLast() {
        int lastIndex = -1;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                lastIndex = i - 1;
                break;
            }
        }
        if (lastIndex != -1) {
            return storage[lastIndex];
        } else return null;
    }

    public T get(int index) {
        if (cache.isPresent(index)) return cache.get(index).getElement();
        else {
            if (cache.getCapacity() > index) {
                cache.add(storage[index], index);
                return storage[index];
            } else return null;
        }
    }

    public void clear() {
        cache.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Storage)) return false;
        Storage<?> storage1 = (Storage<?>) o;
        return Arrays.equals(getStorage(), storage1.getStorage()) && Objects.equals(getCache(), storage1.getCache());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getCache());
        result = 31 * result + Arrays.hashCode(getStorage());
        return result;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "storage=" + Arrays.toString(storage) +
                ", cache=" + cache +
                '}';
    }
}
