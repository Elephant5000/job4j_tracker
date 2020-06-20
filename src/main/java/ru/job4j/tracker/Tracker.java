package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tracker {
    private final List<Item> items = new ArrayList<Item>();
    private int ids = 1;
    private int position = 0;

    public Item add(Item item) {
        item.setId(generateId());
        this.items.add(item);
        return item;
    }


    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return this.items;
    }

    public List<Item> findByName(String key) {
        List<Item> itemFindName = new ArrayList<Item>();
        for (Item item : this.items) {
            if (item.getName().equals(key)) {
                itemFindName.add(item);
            }
        }
        return itemFindName;
    }

    public boolean replace(String id, Item item) {
        boolean rsl = false;
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items.set(index, item);
            rsl = true;
        }
        return rsl;
    }

    public boolean delete(String id) {
        boolean rsl = false;
        int positionForDel = indexOf(id);
        if (positionForDel != -1) {
            items.remove(positionForDel);
            rsl = true;
        }
        return rsl;
    }

}