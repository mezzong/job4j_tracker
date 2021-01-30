package ru.job4j.tracker.singleton;


import org.junit.Test;
import ru.job4j.tracker.MemTracker;

import static org.junit.Assert.assertSame;

public class MemTrackerSingleEnumTest {
    @Test
    public void getInstance() {
        MemTracker memTracker1 = TrackerSingleEnum.INSTANCE.getMemTracker();
        MemTracker memTracker2 = TrackerSingleEnum.INSTANCE.getMemTracker();

        assertSame(memTracker1, memTracker2);
    }
}