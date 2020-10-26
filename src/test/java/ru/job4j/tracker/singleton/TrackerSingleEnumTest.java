package ru.job4j.tracker.singleton;


import org.junit.Test;

import static org.junit.Assert.assertSame;

public class TrackerSingleEnumTest {
    @Test
    public void getInstance() {
        TrackerSingleEnum tracker1 = TrackerSingleEnum.INSTANCE;
        TrackerSingleEnum tracker2 = TrackerSingleEnum.INSTANCE;

        assertSame(tracker1, tracker2);
    }
}