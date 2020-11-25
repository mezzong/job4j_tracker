package ru.job4j.collection;

import java.util.*;

public class Departments {

    public static List<String> fillGaps(List<String> deps) {
        LinkedHashSet<String> temp = new LinkedHashSet<>();
        for (String department : deps) {
            String s = "";
            for (String value : department.split("/")) {
                if (s.equals("")) {
                    s = value;
                } else {
                    s = s + "/" + value;
                }
                temp.add(s);
            }
        }
        return new ArrayList<>(temp);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}