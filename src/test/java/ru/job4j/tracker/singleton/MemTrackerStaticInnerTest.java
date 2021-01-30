package ru.job4j.tracker.singleton;


import org.junit.Test;
import ru.job4j.tracker.MemTracker;

import static org.junit.Assert.assertSame;

public class MemTrackerStaticInnerTest {
    @Test
    public void getInstance() {
        MemTracker memTracker1 = TrackerStaticInner.getInstance();
        MemTracker memTracker2 = TrackerStaticInner.getInstance();

        assertSame(memTracker1, memTracker2);
    }
}