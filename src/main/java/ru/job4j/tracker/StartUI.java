package ru.job4j.tracker;

public class StartUI {

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        for (int i = 0; i < 10; i++) {
            tracker.add(new Item());
        }

        Item[] items = tracker.findAll();
        for (Item i :
                items) {
            System.out.println(i.getId());
        }
    }
}
