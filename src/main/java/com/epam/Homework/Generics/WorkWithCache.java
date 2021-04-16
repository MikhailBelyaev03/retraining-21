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
        System.out.format("Cache is:  - %s \n", cache);

        cache.delete("Lera");
        System.out.format("Delete Lera from cache:  - %s \n", cache);

        cache.delete("Stepan");
        System.out.format("Delete Stepan from cache:  %s \n", cache);

        System.out.format("Is Masha present in cashe: %s \n", cache.isPresent("Masha"));
        System.out.format("Is Lera present in cashe:  %s \n", cache.isPresent("Lera"));
        System.out.format("Is 2225 present in cashe:  %s \n", cache.isPresent(2225));
        System.out.format("Is 2235 present in cashe:  %s \n", cache.isPresent(2235));

        cache.get(4752);
        System.out.format("Get Marysya from cache: %s \n", cache);

        cache.get(2225);
        System.out.format("Get Victor from cache:  %s \n", cache);

        cache.add("Vera", 4756);
        cache.add("Marat", 7897);
        System.out.format("Add Vera and Marat to cache: %s \n", cache);
        cache.add("Alexandr", 7897);
        System.out.format("Add Alexandr to cache: %s \n", cache);

        cache.clear();
        System.out.format("Clear all cache: %s \n", cache);
        System.out.format("Is 2225 present in cashe:  %s \n", cache.isPresent(7897));
    }
}
