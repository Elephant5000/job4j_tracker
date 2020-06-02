package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int position = 0;

    public Item add(Item item) {
        item.setId(generateId());
        items[position++] = item;
        return item;
    }

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < position; index++) {
            if (items[index] == null) continue;
            if (items[index].getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll(){
        Item[] itemsWithoutNul = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null) {
                itemsWithoutNul[size] = items[index];
                size++;
            }
        }
        itemsWithoutNul = Arrays.copyOf(itemsWithoutNul, size);
        return itemsWithoutNul;
    }

    public Item[] findByName(String key){
        Item[] itemFindName = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            if (items[index] == null) continue;
            if (items[index].getName().equals(key)) {
                itemFindName[size] = items[index];
                size++;
            }
        }
        itemFindName = Arrays.copyOf(itemFindName,size);
        return itemFindName;
    }

    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(String id) {
        int idForDel = indexOf(id);
        if (idForDel != -1) {
            items[idForDel] = null;
            System.arraycopy(items, idForDel + 1, items, idForDel, position - idForDel);
            items[position-1] = null;
            position--;
            return true;
        } else return false;
    }

}