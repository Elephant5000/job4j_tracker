package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show all Item ====");
                Item[] items = tracker.findAll();
                for (int index = 0; index < items.length; index++) {
                    System.out.println(items[index].getId() + " " + items[index].getName());
                }
            } else if (select == 2) {
                System.out.println("=== Edit Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                System.out.print("Enter id: ");
                String id = scanner.nextLine();
                if (tracker.replace(id, item)) {
                    System.out.println("Successfully");
                } else {
                    System.out.println("Unsuccessfully");
                }
            } else if (select == 3) {
                System.out.println("=== Delete Item ====");
                System.out.println("Enter id for delete");
                String id = scanner.nextLine();
                if (tracker.delete(id)) {
                    System.out.println("Successfully");
                } else {
                    System.out.println("Unsuccessfully");
                }
            } else if (select == 4) {
                System.out.println("=== Find Item by Id ====");
                Item item = tracker.findById(scanner.nextLine());
                if (item != null) {
                    System.out.println("Result - " + item.getId() + " " + item.getName());
                } else {
                    System.out.println("Not found this Id");
                }
            } else if (select == 5) {
                System.out.println("=== Find Item by name ====");
                Item[] items = tracker.findByName(scanner.nextLine());
                if (items.length > 0) {
                    System.out.println("Result - ");
                    for (int index = 0; index < items.length; index++) {
                        System.out.println(items[index].getId() + " " + items[index].getName());
                    }
                } else {
                    System.out.println("Not found this name");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

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


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
