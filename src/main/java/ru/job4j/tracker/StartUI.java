package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.println("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("==== Create a new Item ====");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                Item[] items = tracker.findAll();
                for (Item item :
                        items) {
                    System.out.println(item);
                }
            } else if (select == 2) {
                System.out.println("Enter id item");
                int id = Integer.valueOf(scanner.nextLine());
                System.out.println("Enter name to change: ");
                String name = scanner.nextLine();
                if (tracker.replace(id, new Item(name))) {
                    System.out.println("Success");
                } else {
                    System.out.println("Error id not found");
                }
            } else if (select == 3) {
                System.out.println("Enter id for delete: ");
                int id = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Success");
                } else {
                    System.out.println("Error id not found");
                }
            } else if (select == 4) {
                System.out.println("Enter the id to search");
                int id = Integer.valueOf(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item == null) {
                    System.out.println("Item with this ID not found");
                } else {
                    System.out.println(item);
                }
            }else if (select == 5) {
                System.out.println("Enter the name to search");
                String name = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
