package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoArrayToList {
  public static void main(String[] args) {
      Integer[][] array = {
              {1, 2},
              {3, 4}
      };
      List<Integer> list = Stream.of(array)
              .flatMap(Stream::of)
              .collect(Collectors.toList());
      list.forEach(System.out::println);
  }
}
