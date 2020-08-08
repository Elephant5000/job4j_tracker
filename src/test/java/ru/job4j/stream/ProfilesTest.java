package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void collect() {
        List<Profile> profile = new ArrayList<>();
        profile.add(new Profile(new Address("Moskow", "Red Square", 1, 1)));
        profile.add(new Profile(new Address("Moskow", "Red Square", 1, 1)));
        profile.add(new Profile(new Address("Kazan", "Lenina", 1, 1)));
        List<Address> addressList = new ArrayList<>();
        addressList.add(new Address("Moskow", "Red Square", 1, 1));
        addressList.add(new Address("Kazan", "Lenina", 1, 1));
        addressList.sort(Comparator.comparing(Address::getCity));
        assertThat(Profiles.collect(profile), is(addressList));
    }
}