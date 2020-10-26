package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;

public class TrackerSingleEagerStatic {
    private static final TrackerSingleEagerStatic INSTANCE = new TrackerSingleEagerStatic();

    private TrackerSingleEagerStatic() {
    }

    public static TrackerSingleEagerStatic getInstance() {
        return INSTANCE;
    }

    public Item add(Item model) {
        return model;
    }
}
