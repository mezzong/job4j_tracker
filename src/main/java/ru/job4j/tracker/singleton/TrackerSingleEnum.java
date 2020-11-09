package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;

import java.util.ArrayList;
import java.util.List;

public enum TrackerSingleEnum {
    INSTANCE;

    private final List<Item> items = new ArrayList<>();
    private int id = 1;

    public Item add(Item item) {
        item.setId(id++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (int index = 0; index < items.size(); index++) {
            String itemName = items.get(index).getName();
            if (key.equals(itemName)) {
                rsl.add(items.get(index));
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        boolean result = false;
        int indexItem = indexOf(id);
        if (indexItem != -1) {
            item.setId(id);
            items.set(indexItem, item);
            result = true;
        }
        return result;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
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
            items.remove(index);
            result = true;
        }
        return result;
    }
}
