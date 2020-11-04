package ru.job4j.stream;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TwoArrayToListTest {

    @Test
    public void testArrayToList() {
        Integer[][] array = {
                {1, 2},
                {3, 4}
        };
        List<Integer> result = TwoArrayToList.arrayToList(array);
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(result, is(expected));
    }
}