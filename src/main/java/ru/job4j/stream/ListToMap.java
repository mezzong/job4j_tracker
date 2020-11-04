package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {
  public static Map<String, Student> listToMap(List<Student> studentList) {
      return studentList.stream()
              .collect(Collectors.toMap(Student::getSurname, e -> e, (a, b) -> b));
  }
}
