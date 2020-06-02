package ru.job4j.tracker;

import org.junit.Test;
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
        Item item3 = new Item("test333");

        Item[] items = tracker.findByName("test2");
        String idItemForReplace = items[0].getId();

        Boolean result = tracker.replace(idItemForReplace, item3);
        assertThat(result, is(true));
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

/*    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        Item item = new Item("TestFindAll");
        tracker.add(item);
        Item[] exp = new Item[1];
        exp[0].setName("TestFindAll");
        exp[0].setId(item.getId());

        Item[] rsl = tracker.findAll();
        assertThat(rsl, is(exp));
    }

 */

}