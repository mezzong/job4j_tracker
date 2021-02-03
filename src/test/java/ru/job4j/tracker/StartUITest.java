package ru.job4j.tracker;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void whenCreateItem() throws Exception {
        try (Store tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Output out = new ConsoleOutput();
            Input in = new StubInput(out,
                    new String[] {"0", "Item name", "1"}
            );
            List<UserAction> actions = new ArrayList<>();
            actions.add(new CreateAction(out));
            actions.add(new ExitAction());
            new StartUI(out).init(in, tracker, actions);
            assertThat(tracker.findAll().get(0).getName(), is("Item name"));
        }
    }

    @Test
    public void whenReplaceItem() throws Exception {
        try (Store tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Output out = new ConsoleOutput();
            /* Добавим в tracker новую заявку */
            Item item = tracker.add(new Item("Replaced item"));
            /* Входные данные должны содержать ID добавленной заявки item.getId() */
            String replacedName = "New item name";
            Input in = new StubInput(out,
                    new String[] {"0", "1", replacedName, "1"}
            );
            List<UserAction> actions = new ArrayList<>();
            actions.add(new ReplaceAction(out));
            actions.add(new ExitAction());
            new StartUI(out).init(in, tracker, actions);
            assertThat(tracker.findById(String.valueOf(1)).getName(), is(replacedName));
        }
    }

    @Test
    public void whenDeleteItem() throws Exception {
        try (Store tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Output out = new ConsoleOutput();
            /* Добавим в tracker новую заявку */
            Item item = tracker.add(new Item("Deleted item"));
            /* Входные данные должны содержать ID добавленной заявки item.getId() */
            Input in = new StubInput(out,
                    new String[] {"0", "1", "1"}
            );
            List<UserAction> actions = new ArrayList<>();
            actions.add(new DeleteAction(out));
            actions.add(new ExitAction());
            new StartUI(out).init(in, tracker, actions);
            assertThat(tracker.findById(String.valueOf(item.getId())), is(nullValue()));
        }
    }

    @Test
    public void whenExit() throws Exception {
        try (Store tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Output out = new StubOutput();
            Input in = new StubInput(out,
                    new String[] {"0"}
            );
            List<UserAction> actions = new ArrayList<>();
            actions.add(new ExitAction());
            new StartUI(out).init(in, tracker, actions);
            assertThat(out.toString(), is(
                    "Menu." + System.lineSeparator()
                            + "0. Exit program" + System.lineSeparator()
                            + "Select: " + System.lineSeparator()
            ));
        }
    }

    @Test
    public void whenFindAll() throws Exception {
        try (Store tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Output out = new StubOutput();
            Input in = new StubInput(out,
                    new String[] {"0", "1"}
            );
            tracker.add(new Item("Item1"));
            List<UserAction> actions = new ArrayList<>();
            actions.add(new FindAllAction(out));
            actions.add(new ExitAction());
            new StartUI(out).init(in, tracker, actions);
            assertThat(out.toString(), is(
                    "Menu." + System.lineSeparator()
                            + "0. Show all items" + System.lineSeparator()
                            + "1. Exit program" + System.lineSeparator()
                            + "Select: " + System.lineSeparator()
                            + "==== Find all items ====" + System.lineSeparator()
                            + "Item{id=1, name='Item1'}" + System.lineSeparator()
                            + "Menu." + System.lineSeparator()
                            + "0. Show all items" + System.lineSeparator()
                            + "1. Exit program" + System.lineSeparator()
                            + "Select: " + System.lineSeparator()

            ));
        }
    }

    @Test
    public void whenFindByName() throws Exception {
        try (Store tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Output out = new StubOutput();
            Input in = new StubInput(out,
                    new String[] {"0", "Item1", "1"}
            );
            tracker.add(new Item("Item1"));
            List<UserAction> actions = new ArrayList<>();
            actions.add(new FindByName(out));
            actions.add(new ExitAction());
            new StartUI(out).init(in, tracker, actions);
            assertThat(out.toString(), is(
                    "Menu." + System.lineSeparator()
                            + "0. Find items by name" + System.lineSeparator()
                            + "1. Exit program" + System.lineSeparator()
                            + "Select: " + System.lineSeparator()
                            + "Enter the name to search" + System.lineSeparator()
                            + "Item{id=1, name='Item1'}" + System.lineSeparator()
                            + "Menu." + System.lineSeparator()
                            + "0. Find items by name" + System.lineSeparator()
                            + "1. Exit program" + System.lineSeparator()
                            + "Select: " + System.lineSeparator()

            ));
        }
    }

    @Test
    public void whenInvalidExit() throws Exception {
        try (Store tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Output out = new StubOutput();
            Input in = new StubInput(out,
                    new String[] {"-1", "0"}
            );
            List<UserAction> actions = new ArrayList<>();
            actions.add(new ExitAction());
            new StartUI(out).init(in, tracker, actions);
            assertThat(out.toString(), is(
                    String.format(
                            "Menu.%n"
                                    + "0. Exit program%n"
                                    + "Select: %n"
                                    + "Wrong input, you can select: 0 .. 0%n"
                                    + "Menu.%n"
                                    + "0. Exit program%n"
                                    + "Select: %n"
                    )
            ));
        }
    }
}
