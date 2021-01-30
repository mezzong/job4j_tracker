package ru.job4j.tracker.singleton;

import ru.job4j.tracker.MemTracker;

public enum TrackerSingleEnum {
    INSTANCE;

    private final MemTracker memTracker = new MemTracker();

    public MemTracker getMemTracker() {
        return memTracker;
    }
}
