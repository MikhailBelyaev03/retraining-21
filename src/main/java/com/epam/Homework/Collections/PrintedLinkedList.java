package com.epam.Homework.Collections;

import java.util.LinkedList;
import java.util.List;

public class PrintedLinkedList {

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add((int) (Math.random() * 100));
        list.add((int) (Math.random() * 100));
        list.add((int) (Math.random() * 100));
        list.add((int) (Math.random() * 100));
        list.add((int) (Math.random() * 100));
        list.add((int) (Math.random() * 100));
        list.add((int) (Math.random() * 100));
        for (int i = 0; i < list.size(); i++) {
            System.out.format("Value:  %s; index:  %s \n", list.get(i), i);
        }
    }
}
