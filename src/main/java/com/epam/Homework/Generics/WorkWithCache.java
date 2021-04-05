package com.epam.Homework.Generics;

public class WorkWithCache {
    public static void main(String[] args) {
        Cache<String> cache = new Cache<>(5);
        cache.add("Masha", 4456);
        cache.add("Misha", 4782);
        cache.add("Victor", 2225);
        cache.add("Marysya", 4752);
        cache.add("Stepan", 7745);
        cache.add("Lera", 6354);
        System.out.println("Cache is:  - " + cache);

        cache.delete("Lera");
        System.out.println("Delete Lera from cache:  -" + cache);

        cache.delete("Stepan");
        System.out.println("Delete Stepan from cache:  " + cache);

        System.out.println("Is Masha present in cashe: " + cache.isPresent("Masha"));
        System.out.println("Is Lera present in cashe:  " + cache.isPresent("Lera"));
        System.out.println("Is 2225 present in cashe:  " + cache.isPresent(2225));
        System.out.println("Is 2235 present in cashe::  " + cache.isPresent(2235));

        cache.get(4752);
        System.out.println("Get Marysya from cache: " + cache);

        cache.get(2225);
        System.out.println("Get Victor from cache:  " + cache);

        cache.add("Vera", 4756);
        cache.add("Marat", 7897);
        System.out.println("Add Vera and Marat to cache: " + cache);
        cache.add("Alexandr", 7897);
        System.out.println("Add Alexandr to cache: " + cache);

        cache.clear();
        System.out.println("Clear all cache: " + cache);
    }
}
