package main.java.com.epam.homework.collections;

import java.util.LinkedList;
import java.util.List;

public class PrintedLinkedList {

    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();
        list.add( (int) (Math.random()*100));
        list.add( (int) (Math.random()*100));
        list.add( (int) (Math.random()*100));
        list.add( (int) (Math.random()*100));
        list.add( (int) (Math.random()*100));
        list.add( (int) (Math.random()*100));
        list.add( (int) (Math.random()*100));
        for (int i=0;i<list.size();i++){
            System.out.println("Value: "+list.get(i)+"; index: "+i);
        }

    }

}
