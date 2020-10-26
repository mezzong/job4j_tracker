package ru.job4j.tracker.singleton;


import org.junit.Test;

import static org.junit.Assert.assertSame;

public class TrackerStaticInnerTest {
    @Test
    public void getInstance() {
        TrackerStaticInner tracker1 = TrackerStaticInner.getInstance();
        TrackerStaticInner tracker2 = TrackerStaticInner.getInstance();

        assertSame(tracker1, tracker2);
    }
}