package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.MemTracker;

public class TrackerSingleEagerStatic {
    private static final MemTracker INSTANCE = new MemTracker();

    private TrackerSingleEagerStatic() {
    }

    public static MemTracker getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }
}
