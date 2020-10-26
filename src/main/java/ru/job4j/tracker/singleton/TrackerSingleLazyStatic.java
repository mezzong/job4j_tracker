package ru.job4j.tracker.singleton;

public class TrackerSingleLazyStatic {
    private static TrackerSingleLazyStatic instance;

    private TrackerSingleLazyStatic() {

    }

    public static TrackerSingleLazyStatic getInstance() {
        if (instance == null) {
            instance = new TrackerSingleLazyStatic();
        }
        return instance;
    }
}
