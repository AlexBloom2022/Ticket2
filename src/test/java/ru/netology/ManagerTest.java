package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    Repository repo = new Repository();
    Manager manager = new Manager(repo);

    Ticket first = new Ticket(11, 10, "DME", "DYR", 2);
    Ticket second = new Ticket(590, 3, "VKO", "KZN", 1);
    Ticket third = new Ticket(79, 5, "DME", "KVK", 3);
    Ticket fourth = new Ticket(588, 17, "ZIA", "ASF", 6);
    Ticket fifth = new Ticket(5589, 19, "SVO", "ARH", 2);


    @Test
    void shouldFindAll() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);

        Ticket[] expected = {first, second, third, fourth};
        Assertions.assertArrayEquals(expected, repo.findAll());
    }

    @Test
    void shouldFindDME() {
        manager.addItem(first);
        manager.addItem(second);
        manager.addItem(third);
        manager.addItem(fourth);

        Ticket[] expected = {first};
        assertArrayEquals(expected, manager.getAll("DME", "DYR"));
    }

    @Test
    void shouldFindVKO() {
        manager.addItem(first);
        manager.addItem(second);
        manager.addItem(third);
        manager.addItem(fourth);

        Ticket[] expected = {second};
        assertArrayEquals(expected, manager.getAll("VKO", "KZN"));
    }

    @Test
    void shouldFindNonExisting() {
        manager.addItem(first);
        manager.addItem(second);
        manager.addItem(third);
        manager.addItem(fourth);
        manager.addItem(fifth);

        Ticket[] expected = {};
        assertArrayEquals(expected, manager.getAll("VKO", "SVO"));
    }
}