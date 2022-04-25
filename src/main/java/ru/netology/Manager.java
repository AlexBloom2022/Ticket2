package ru.netology;

import java.util.Arrays;

public class Manager {
    private Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public void addItem(Ticket item) {
        repository.save(item);
    }

    public Ticket[] getAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket item : repository.findAll()
        ) {
            if (from.equals(item.getFrom()) && to.equals(item.getTo())) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public void removeById(int id) {
        repository.removeById(id);
    }
}