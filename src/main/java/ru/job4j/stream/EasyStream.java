package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private final List<Integer> list;

    public EasyStream(List<Integer> list) {
        this.list = list;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> result = new ArrayList<>();
        for (Integer num : list) {
            result.add(fun.apply(num));
        }
        return new EasyStream(result);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> result = new ArrayList<>();
        for (Integer num : list) {
            if (fun.test(num)) {
                result.add(num);
            }
        }
        return new EasyStream(result);
    }

    public List<Integer> collect() {
        return list;
    }
}
