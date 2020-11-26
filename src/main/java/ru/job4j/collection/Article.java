package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class Article {
    public static boolean generateBy(String origin, String line) {
        HashSet<String> originSet = new HashSet<>(
                List.of(origin.replaceAll("\\pP", "").split(" ")));
        HashSet<String> lineSet = new HashSet<>(
                List.of(line.replaceAll("\\pP", "").split(" ")));
        return originSet.containsAll(lineSet);
    }
}
