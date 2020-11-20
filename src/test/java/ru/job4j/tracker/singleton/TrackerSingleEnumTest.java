package ru.job4j.tracker.singleton;


import org.junit.Test;
import ru.job4j.tracker.Tracker;

import static org.junit.Assert.assertSame;

public class TrackerSingleEnumTest {
    @Test
    public void getInstance() {
        Tracker tracker1 = TrackerSingleEnum.INSTANCE.getTracker();
        Tracker tracker2 = TrackerSingleEnum.INSTANCE.getTracker();

        assertSame(tracker1, tracker2);
    }
}