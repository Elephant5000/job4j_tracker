package ru.job4j.tracker;

public class StartUI {

    private void showMenu() {
        System.out.println();
        System.out.println("Menu.");
        System.out.println("0. Add new Item.");
        System.out.println("1. Show all items.");
        System.out.println("2. Edit item.");
        System.out.println("3. Delete item.");
        System.out.println("4. Find item by Id.");
        System.out.println("5. Find items by name.");
        System.out.println("6. Exit Program.");
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showItem(Tracker tracker) {
        System.out.println("=== Show all Item ====");
        Item[] items = tracker.findAll();
        for (int index = 0; index < items.length; index++) {
            System.out.println(items[index]);
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        String id = input.askStr("Enter id: ");
        if (tracker.replace(id, item)) {
            System.out.println("Successfully");
        } else {
            System.out.println("Unsuccessfully");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ====");
        String id = input.askStr("Enter id for delete");
        if (tracker.delete(id)) {
            System.out.println("Successfully");
        } else {
            System.out.println("Unsuccessfully");
        }
    }


    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find Item by Id ====");
        Item item = tracker.findById(input.askStr("Enter id"));
        if (item != null) {
            System.out.println("Result - " + item);
        } else {
            System.out.println("Not found this Id");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Find Item by name ====");
        Item[] items = tracker.findByName(input.askStr("Enter name"));
        if (items.length > 0) {
            System.out.println("Result - ");
            for (int index = 0; index < items.length; index++) {
                System.out.println(items[index]);
            }
        } else {
            System.out.println("Not found this name");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showItem(tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemByName(input, tracker);
            } else if (select == 6) {
                run = false;
            }
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
