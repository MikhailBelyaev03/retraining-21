package com.epam.Homework.Generics;

import java.util.Arrays;

public class Storage<T> {

    private T[] storage;

    private Cache<T> cache;

    private int capacity;

    public Storage() {
        this.storage = (T[]) new Object[10];
        this.cache = new Cache<>(10);
    }

    public Storage(T[] storage) {
        this.capacity = 10;
        while (this.capacity < storage.length) {
            this.capacity = (int) (this.capacity * 1.5);
        }
        this.storage = storage;
        this.cache = new Cache<>(this.capacity);
    }

    public void add(T element) {
        if (storage[storage.length - 1] != null) {
            storage = Arrays.copyOf(storage, (int) (this.storage.length * 1.5));
        }
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = element;
                return;
            }
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
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null && i > 0) {
                return storage[i - 1];
            }
        }
        return null;
    }

    public T get(int index) {
        if (cache.isPresent(index)) {
            return cache.get(index).getElement();
        }

        cache.add(storage[index], index);
        return storage[index];

    }

    public void clear() {
        cache.clear();
    }

    @Override
    public String toString() {
        return "Storage{" +
                "storage=" + Arrays.toString(storage) +
                ", cache=" + cache +
                '}';
    }
}
