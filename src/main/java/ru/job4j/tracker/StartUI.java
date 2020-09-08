package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                System.out.println("==== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] items = tracker.findAll();
                for (Item item :
                        items) {
                    System.out.println(item);
                }
            } else if (select == 2) {
                int id = Integer.valueOf(input.askStr("Enter id item"));
                String name = input.askStr("Enter name to change: ");
                if (tracker.replace(id, new Item(name))) {
                    System.out.println("Success");
                } else {
                    System.out.println("Error id not found");
                }
            } else if (select == 3) {
                int id = Integer.valueOf(input.askStr("Enter id for delete: "));
                if (tracker.delete(id)) {
                    System.out.println("Success");
                } else {
                    System.out.println("Error id not found");
                }
            } else if (select == 4) {
                int id = Integer.valueOf(input.askStr("Enter the id to search"));
                Item item = tracker.findById(id);
                if (item == null) {
                    System.out.println("Item with this ID not found");
                } else {
                    System.out.println(item);
                }
            }else if (select == 5) {
                String name = input.askStr("Enter the name to search");
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item i :
                            items) {
                        System.out.println(i);
                    }
                } else {
                    System.out.println("No tickets with this name were found");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
