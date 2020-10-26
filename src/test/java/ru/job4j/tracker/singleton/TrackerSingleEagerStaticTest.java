package ru.job4j.tracker.singleton;


import org.junit.Test;

import static org.junit.Assert.assertSame;

public class TrackerSingleEagerStaticTest {
    @Test
    public void getInstance() {
        TrackerSingleEagerStatic tracker1 = TrackerSingleEagerStatic.getInstance();
        TrackerSingleEagerStatic tracker2 = TrackerSingleEagerStatic.getInstance();

        assertSame(tracker1, tracker2);
    }
}