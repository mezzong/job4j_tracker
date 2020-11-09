package ru.job4j.tracker.singleton;


import org.junit.Test;
import ru.job4j.tracker.Tracker;

import static org.junit.Assert.assertSame;

public class TrackerStaticInnerTest {
    @Test
    public void getInstance() {
        Tracker tracker1 = TrackerStaticInner.getInstance();
        Tracker tracker2 = TrackerStaticInner.getInstance();

        assertSame(tracker1, tracker2);
    }
}