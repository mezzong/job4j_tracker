package ru.job4j.tracker;

public class DeleteAction implements UserAction{
    @Override
    public String name() {
        return "==== Delete an item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id for delete: ");
        if (tracker.delete(id)) {
            System.out.println("Success");
        } else {
            System.out.println("Error id not found");
        }
        return true;
    }
}
