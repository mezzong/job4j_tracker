package ru.job4j.tracker.singleton;

public class TrackerStaticInner {
    private TrackerStaticInner() {
    }

    public static TrackerStaticInner getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerStaticInner INSTANCE = new TrackerStaticInner();
    }
}
