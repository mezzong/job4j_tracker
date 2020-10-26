package ru.job4j.tracker.singleton;


import org.junit.Test;

import static org.junit.Assert.assertSame;

public class TrackerSingleLazyStaticTest {
    @Test
    public void getInstance() {
        TrackerSingleLazyStatic tracker1 = TrackerSingleLazyStatic.getInstance();
        TrackerSingleLazyStatic tracker2 = TrackerSingleLazyStatic.getInstance();

        assertSame(tracker1, tracker2);
    }
}