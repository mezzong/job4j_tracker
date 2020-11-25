package ru.job4j.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        OptionalDouble result;
        result = stream.flatMap(x -> x.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average();
        return result.orElse(0);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(x -> new Tuple(x.getName(), x.getSubjects()
        .stream()
        .mapToInt(Subject::getScore)
        .average()
        .orElse(0.0)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(x -> x.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(y -> new Tuple(y.getKey(), y.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(x -> new Tuple(x.getName(), x.getSubjects()
                .stream()
                .mapToInt(Subject::getScore)
                .sum()))
                .max(Comparator.comparingDouble(Tuple::getScore))
                .orElse(new Tuple("", 0.0));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(x -> x.getSubjects().stream())
        .collect(Collectors.groupingBy(Subject::getName,
                Collectors.summingDouble(Subject::getScore)))
        .entrySet()
        .stream()
        .map(y -> new Tuple(y.getKey(), y.getValue()))
        .max(Comparator.comparingDouble(Tuple::getScore))
        .orElse(null);
    }
}