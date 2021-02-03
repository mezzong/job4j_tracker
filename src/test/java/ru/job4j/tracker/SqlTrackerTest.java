package ru.job4j.tracker;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class SqlTrackerTest {
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
        try (SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item("name");
            sqlTracker.add(item);
            assertThat(sqlTracker.findByName("name").size(), is(1));
        }
    }

    @Test
    public void whenReplace() throws Exception {
        try (SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item bug = new Item();
            bug.setName("Bug");
            sqlTracker.add(bug);
            int id = 1;
            Item bugWithDesc = new Item();
            bugWithDesc.setId(1);
            bugWithDesc.setName("Bug with description");
            sqlTracker.replace(String.valueOf(id), bugWithDesc);
            assertThat(sqlTracker.findById(String.valueOf(id)).getName(),
                    is("Bug with description"));
        }
    }

    @Test
    public void whenDelete() throws Exception {
        try (SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item bug = new Item();
            Item testItem1 = new Item();
            Item testItem2 = new Item();
            Item testItem3 = new Item();
            bug.setName("Bug");
            testItem1.setName("testItem1");
            testItem2.setName("testItem2");
            testItem3.setName("testItem3");
            sqlTracker.add(bug);
            sqlTracker.add(testItem1);
            sqlTracker.add(testItem2);
            sqlTracker.add(testItem3);
            sqlTracker.delete(String.valueOf(1));
            assertThat(sqlTracker.findById(String.valueOf(1)), is(nullValue()));
        }
    }

    @Test
    public void whenFindItemById() throws Exception {
        try (SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item testItem = new Item();
            testItem.setName("Test item");
            sqlTracker.add(testItem);
            Item result = sqlTracker.findById("1");
            assertThat(1, is(1));
        }
    }

    @Test
    public void whenFindItemByName() throws Exception {
        try (SqlTracker sqlTracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item testItem1 = new Item();
            Item testItem2 = new Item();
            Item testItem3 = new Item();
            testItem1.setName("Test item 1");
            testItem2.setName("Test item 2");
            testItem3.setName("Test item 1");
            sqlTracker.add(testItem1);
            sqlTracker.add(testItem2);
            sqlTracker.add(testItem3);
            List<Item> expected = List.of(new Item(1, "Test item 1"),
                    new Item(3, "Test item 1"));
            List<Item> results = sqlTracker.findByName("Test item 1");
            assertThat(results, is(expected));
        }
    }
}