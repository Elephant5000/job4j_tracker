package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Item by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findByName(input.askStr("Enter name"));
        if (items.length > 0) {
            System.out.println("Result - ");
            for (int index = 0; index < items.length; index++) {
                System.out.println(items[index]);
            }
        } else {
            System.out.println("Not found this name");
        }
        return true;
    }
}
