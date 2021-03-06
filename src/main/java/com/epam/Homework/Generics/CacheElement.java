package com.epam.Homework.Generics;

import java.util.Objects;

public class CacheElement<T> {

    private T element;

    private int index;

    public CacheElement(T element, int index) {
        this.element = element;
        this.index = index;
    }

    public T getElement() {
        return element;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CacheElement)) return false;
        CacheElement<?> that = (CacheElement<?>) o;
        return getIndex() == that.getIndex() && Objects.equals(getElement(), that.getElement());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getElement(), getIndex());
    }

    @Override
    public String toString() {
        return "CacheElement{" +
                "element=" + element +
                ", index=" + index +
                '}';
    }
}
