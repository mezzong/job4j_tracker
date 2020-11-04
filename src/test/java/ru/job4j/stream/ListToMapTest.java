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
        List<Student> studentList = List.of(new Student(1, "Smith"),
                new Student(2, "Johnson"),
                new Student(3, "Brown"),
                new Student(1, "Garcia"),
                new Student(1, "Smith")
        );
        Map<String, Student> rsl = ListToMap.listToMap(studentList);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Brown", new Student(3, "Brown"));
        expected.put("Johnson", new Student(2, "Johnson"));
        expected.put("Smith", new Student(1, "Smith"));
        expected.put("Garcia", new Student(1, "Garcia"));

        assertThat(rsl, is(expected));
    }
}