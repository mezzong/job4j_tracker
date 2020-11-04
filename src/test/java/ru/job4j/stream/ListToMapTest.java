package ru.job4j.stream;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ListToMapTest {

    @Test
    public void whenCollectAddresses() {
        List<Student> studentList = List.of(new Student("Smith", 1),
                new Student("Johnson", 2),
                new Student("Brown", 3),
                new Student("Garcia", 1),
                new Student("Smith", 1)
        );
        Map<String, Student> rsl = ListToMap.listToMap(studentList);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Brown", new Student("Brown", 3));
        expected.put("Johnson", new Student("Johnson", 2));
        expected.put("Smith", new Student("Smith", 1));
        expected.put("Garcia", new Student("Garcia", 1));

        assertThat(rsl, is(expected));
    }
}