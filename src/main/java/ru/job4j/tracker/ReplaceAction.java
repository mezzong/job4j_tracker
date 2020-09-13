package ru.job4j.tracker;

public class ReplaceAction implements UserAction{

    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id item");
        String name = input.askStr("Enter name to change: ");
        if (tracker.replace(id, new Item(name))) {
            out.println("Success");
        } else {
            out.println("Error id not found");
        }
        return true;
    }
}
