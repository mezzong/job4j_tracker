package ru.job4j.collection;

public class Article {
    public static boolean generateBy(String origin, String line) {
        String[] arr = line.split(" ");
        for (String s : arr) {
            if (!origin.contains(s)) {
                return false;
            }
        }
        return true;
    }
}
