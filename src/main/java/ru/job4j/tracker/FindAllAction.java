package ru.job4j.tracker;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Find All Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        if (items.length > 0) {
            System.out.println("Result - ");
            for (int index = 0; index < items.length; index++) {
                System.out.println(items[index]);
            }
        } else {
            System.out.println("Not found items");
        }
        return true;
    }
}
