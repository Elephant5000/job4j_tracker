package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Item by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> items = tracker.findByName(input.askStr("Enter name"));
        if (items.size() > 0) {
            System.out.println("Result - ");
            for (Item item : items) {
                System.out.println(items);
            }
        } else {
            System.out.println("Not found this name");
        }
        return true;
    }
}
