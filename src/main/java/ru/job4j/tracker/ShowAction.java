package ru.job4j.tracker;

import java.util.List;

public class ShowAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> items = tracker.findAll();
        for (Item item : items) {
            System.out.println(item);
        }
        return true;
    }
}
