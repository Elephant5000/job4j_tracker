package ru.job4j.tracker;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void replace() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("test1");
        tracker.add(item1);
        Item item2 = new Item("test2");
        tracker.add(item2);
        Item newItem = new Item("testNew");
        String idItemForReplace = item1.getId();
        Boolean result = tracker.replace(idItemForReplace, newItem);
        assertThat(result, is(true));
        assertThat(tracker.findById(idItemForReplace).getName(),is(newItem.getName()));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item = new Item("TestFind");
        tracker.add(item);
        String id = item.getId();
        assertThat(tracker.findById(id).getName(), is("TestFind"));
    }

    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        Item item = new Item("TestFindAll");
        tracker.add(item);
        List<Item> rsl = tracker.findAll();
        List<Item> expected = new ArrayList<Item>();
        expected.add(item);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenSortToHighTracker() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Item1");
        tracker.add(item1);
        Item item4 = new Item("Item4");
        tracker.add(item4);
        Item item2 = new Item("Item2");
        tracker.add(item2);
        Item item3 = new Item("Item3");
        tracker.add(item3);
        List<Item> rsl = tracker.findAll();
        Collections.sort(rsl);
        List<Item> expected = Arrays.asList(item1, item2, item3, item4);
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenSortToLowTracker() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Item1");
        tracker.add(item1);
        Item item4 = new Item("Item4");
        tracker.add(item4);
        Item item2 = new Item("Item2");
        tracker.add(item2);
        Item item3 = new Item("Item3");
        tracker.add(item3);
        List<Item> rsl = tracker.findAll();
        Collections.sort(rsl, Collections.reverseOrder());
        List<Item> expected = Arrays.asList(item4, item3, item2, item1);
        assertThat(rsl, is(expected));

    }
}