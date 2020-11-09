package ru.job4j.tracker.singleton;


import org.junit.Test;
import ru.job4j.tracker.Tracker;

import static org.junit.Assert.assertSame;

public class TrackerSingleLazyStaticTest {
    @Test
    public void getInstance() {
        Tracker tracker1 = TrackerSingleLazyStatic.getInstance();
        Tracker tracker2 = TrackerSingleLazyStatic.getInstance();

        assertSame(tracker1, tracker2);
    }
}