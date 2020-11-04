package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoArrayToList {
  public static List<Integer> arrayToList(Integer[][] array) {
      List<Integer> list = Stream.of(array)
              .flatMap(Stream::of)
              .collect(Collectors.toList());
      return list;
  }
}
