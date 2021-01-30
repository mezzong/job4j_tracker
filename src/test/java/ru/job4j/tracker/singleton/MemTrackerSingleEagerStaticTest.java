package ru.job4j.tracker.singleton;


import org.junit.Test;
import ru.job4j.tracker.MemTracker;

import static org.junit.Assert.assertSame;

public class MemTrackerSingleEagerStaticTest {
    @Test
    public void getInstance() {
        MemTracker memTracker1 = TrackerSingleEagerStatic.getInstance();
        MemTracker memTracker2 = TrackerSingleEagerStatic.getInstance();

        assertSame(memTracker1, memTracker2);
    }
}