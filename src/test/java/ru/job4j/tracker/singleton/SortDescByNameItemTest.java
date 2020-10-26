package ru.job4j.tracker.singleton;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.Item;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortDescByNameItemTest {
    @Test
    public void testCompare() {
        List<Item> items = Arrays.asList(
                new Item("C"),
                new Item("B"),
                new Item("A"),
                new Item("D")
        );
        List<Item> expected = Arrays.asList(
                new Item("D"),
                new Item("C"),
                new Item("B"),
                new Item("A")
        );
        System.out.println(items);
        Collections.sort(items, new SortDescByNameItem());
        System.out.println(items);
        Assert.assertEquals(items, expected);
    }
}