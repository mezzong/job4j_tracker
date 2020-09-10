package ru.job4j.tracker;

public class ReplaceAction implements UserAction{
    @Override
    public String name() {
        return "==== Replace item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id item");
        String name = input.askStr("Enter name to change: ");
        if (tracker.replace(id, new Item(name))) {
            System.out.println("Success");
        } else {
            System.out.println("Error id not found");
        }
        return true;
    }
}
