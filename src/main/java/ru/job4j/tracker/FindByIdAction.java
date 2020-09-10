package ru.job4j.tracker;

public class FindByIdAction implements UserAction{
    @Override
    public String name() {
        return "==== Find item by id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter the id to search");
        Item item = tracker.findById(id);
        if (item == null) {
            System.out.println("Item with this ID not found");
        } else {
            System.out.println(item);
        }
        return true;
    }
}
