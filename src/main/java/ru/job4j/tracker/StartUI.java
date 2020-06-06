package ru.job4j.tracker;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
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
        String id = input.askStr("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
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

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ShowAction(),
                new ReplaceAction(),
                new DeleteAction(),
                new FindByIdAction(),
                new FindByNameAction(),
                new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
    }
}
