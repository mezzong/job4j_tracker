package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        Integer first = Integer.parseInt(left.split(". ")[0]);
        Integer second = Integer.parseInt(right.split(". ")[0]);
        return Integer.compare(first, second);
    }
}
