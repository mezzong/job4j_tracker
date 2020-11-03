package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {
  public static void main(String[] args) {
      List<Student> studentList = List.of(new Student(1, "Smith"),
              new Student(2, "Johnson"),
              new Student(3, "Brown"),
              new Student(1, "Garcia"),
              new Student(1, "Smith")
      );
      Map<String, Student> studentMap = studentList.stream()
              .distinct()
              .collect(Collectors.toMap(Student::getSurname, e -> e));
      System.out.println(studentMap);
  }
}
