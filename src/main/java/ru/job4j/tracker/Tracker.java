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
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
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

    public boolean replace(int id, Item item) {
        boolean result = false;
        int indexItem = indexOf(id);
        if (indexItem != -1) {
            item.setId(id);
            items[indexItem] = item;
            result = true;
        }
        return result;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
        if (items[index] != null && items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean result = false;
        if (index != -1) {
            System.arraycopy(items, index + 1, items, index, size - index + 1);
            result = true;
        }
        return result;
    }
}