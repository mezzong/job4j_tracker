package ru.job4j.tracker.singleton;

import ru.job4j.tracker.MemTracker;

public class TrackerStaticInner {
    private TrackerStaticInner() {
    }

    public static MemTracker getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final MemTracker INSTANCE = new MemTracker();
    }
}
