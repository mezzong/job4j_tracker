package ru.job4j.tracker;

public class FindByName implements UserAction{

    private final Output out;

    public FindByName(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter the name to search");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item i :
                    items) {
                out.println(i);
            }
        } else {
            out.println("No tickets with this name were found");
        }
        return true;
    }
}