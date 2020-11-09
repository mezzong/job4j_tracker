package ru.job4j.tracker.singleton;


import org.junit.Test;
import ru.job4j.tracker.Tracker;

import static org.junit.Assert.assertSame;

public class TrackerSingleEagerStaticTest {
    @Test
    public void getInstance() {
        Tracker tracker1 = TrackerSingleEagerStatic.getInstance();
        Tracker tracker2 = TrackerSingleEagerStatic.getInstance();

        assertSame(tracker1, tracker2);
    }
}