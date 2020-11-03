package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    private List<Profile> profiles = new ArrayList<>();

    @Before
    public void setUp() {
        profiles.add(new Profile(new Address("Moscow", "random street", 1, 1)));
        profiles.add(new Profile(new Address("Saint-Petersburg", "random street", 1, 1)));
        profiles.add(new Profile(new Address("Moscow", "random street", 1, 1)));
        profiles.add(new Profile(new Address("Minsk", "random street", 1, 1)));
        profiles.add(new Profile(new Address("Kiev", "random street", 1, 1)));
        profiles.add(new Profile(new Address("New-York", "random street", 1, 1)));
        profiles.add(new Profile(new Address("Moscow", "random street", 1, 1)));
        profiles.add(new Profile(new Address("Moscow", "random street", 1, 1)));
        profiles.add(new Profile(new Address("Moscow", "random street", 1, 1)));
        profiles.add(new Profile(new Address("Moscow", "random street", 1, 1)));
        profiles.add(new Profile(new Address("Moscow", "random street", 1, 1)));
        profiles.add(new Profile(new Address("Moscow", "random street", 1, 1)));
        profiles.add(new Profile(new Address("Moscow", "random street", 1, 1)));
        profiles.add(new Profile(new Address("Moscow", "random street", 1, 1)));
    }

    @Test
    public void whenCollectAddresses() {
        List<Address> rsl = Profiles.collect(profiles);
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("Kiev", "random street", 1, 1));
        expected.add(new Address("Minsk", "random street", 1, 1));
        expected.add(new Address("Moscow", "random street", 1, 1));
        expected.add(new Address("New-York", "random street", 1, 1));
        expected.add(new Address("Saint-Petersburg", "random street", 1, 1));
        assertThat(rsl, is(expected));
    }

}