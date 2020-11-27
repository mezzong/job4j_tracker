package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class Article {
    public static boolean generateBy(String origin, String line) {
        HashSet<String> originSet = new HashSet<>(
                List.of(origin.replaceAll("\\pP", "")
                        .split(" ")));
        for (String s : line.split(" ")) {
            if (!originSet.contains(s)) {
                return false;
            }
        }
        return true;
    }
}
