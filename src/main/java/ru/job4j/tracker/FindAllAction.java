package ru.job4j.tracker;

import java.util.List;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Find All Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> items = tracker.findAll();
        if (items.size() > 0) {
            System.out.println("Result - ");
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Not found items");
        }
        return true;
    }
}
