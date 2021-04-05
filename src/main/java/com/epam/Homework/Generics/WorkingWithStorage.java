package com.epam.Homework.Generics;

public class WorkingWithStorage {
    public static void main(String[] args) {
        Storage<String> firstStorage = new Storage<>();
        String[] arrayForStorage = new String[16];
        arrayForStorage[0] = "one";
        arrayForStorage[1] = "two";
        arrayForStorage[2] = "three";
        arrayForStorage[3] = "four";
        arrayForStorage[4] = "five";
        arrayForStorage[5] = "six";
        arrayForStorage[6] = "seven";
        arrayForStorage[7] = "eight";
        arrayForStorage[8] = "nine";
        arrayForStorage[9] = "ten";
        arrayForStorage[10] = "eleven";
        arrayForStorage[11] = "twelve";
        arrayForStorage[12] = "thirteen";
        arrayForStorage[13] = "fourteen";
        arrayForStorage[14] = "fifteen";
        arrayForStorage[15] = "sixteen";
        Storage<String> secondStorage = new Storage<>(arrayForStorage);
        System.out.println("Second storage is: " + secondStorage);

        firstStorage.add("Hola!1");
        firstStorage.add("Hola!2");
        firstStorage.add("Hola!3");
        firstStorage.add("Hola!4");
        firstStorage.add("Hola!5");
        firstStorage.add("Hola!6");
        firstStorage.add("Hola!7");
        firstStorage.add("Hola!8");
        firstStorage.add("Hola!9");
        firstStorage.add("Hola!10");
        firstStorage.add("Hola!11");
        firstStorage.add("Hola!12");
        firstStorage.add("Hola!13");
        System.out.println("First storage is: " + firstStorage);

        System.out.println("Last element of first storage : " + firstStorage.getLast());
        System.out.println("Last element from second storage" + secondStorage.getLast());
        firstStorage.get(1);
        firstStorage.get(10);
        firstStorage.get(1);
        System.out.println("First storage after getting 1 element : " + firstStorage);
    }
}
