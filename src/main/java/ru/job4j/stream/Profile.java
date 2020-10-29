package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(x -> x.address)
                .distinct()
                .sorted((o1, o2) -> o1.getCity().compareTo(o2.getCity()))
                .collect(Collectors.toList());
    }
}
