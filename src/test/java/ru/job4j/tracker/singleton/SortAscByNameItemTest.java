package ru.job4j.tracker.singleton;


import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.Item;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortAscByNameItemTest {
    @Test
    public void ascSortByName() {
        List<Item> items = Arrays.asList(
                new Item("C"),
                new Item("B"),
                new Item("A"),
                new Item("D")
        );
        List<Item> expected = Arrays.asList(
                new Item("A"),
                new Item("B"),
                new Item("C"),
                new Item("D")
        );
        System.out.println(items);
        Collections.sort(items, new SortAscByNameItem());
        System.out.println(items);
        Assert.assertEquals(items, expected);
    }
}