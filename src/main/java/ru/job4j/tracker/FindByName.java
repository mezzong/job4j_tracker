package ru.job4j.tracker;

public class FindByName implements UserAction{
    @Override
    public String name() {
        return "=== Find item by name === ";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
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
        return true;
    }
}
