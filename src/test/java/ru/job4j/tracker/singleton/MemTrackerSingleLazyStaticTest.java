package ru.job4j.tracker.singleton;


import org.junit.Test;
import ru.job4j.tracker.MemTracker;

import static org.junit.Assert.assertSame;

public class MemTrackerSingleLazyStaticTest {
    @Test
    public void getInstance() {
        MemTracker memTracker1 = TrackerSingleLazyStatic.getInstance();
        MemTracker memTracker2 = TrackerSingleLazyStatic.getInstance();

        assertSame(memTracker1, memTracker2);
    }
}