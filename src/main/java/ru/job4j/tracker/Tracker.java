package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int id = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(id++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, this.size);
    }


    public Item[] findByName(String key) {
        int rslSize = 0;
        Item[] rsl = new Item[this.size];
        for (int index = 0; index < this.size; index++) {
            String itemName = items[index].getName();
            if (key.equals(itemName)) {
                rsl[rslSize++] = items[index];
            }
        }
        return Arrays.copyOf(rsl, rslSize);
    }
}