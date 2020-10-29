package ru.job4j.lambda;

import java.util.List;
import java.util.stream.Collectors;

public class StreamInteger {
  public static void main(String[] args) {
    List<Integer> container = List.of(1, 2, -4, 3, -8, 9, -7, 6);
    List<Integer> list = container.stream().filter(x -> x > 0).collect(Collectors.toList());
    list.forEach(System.out::println);
  }
}
