package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> combineName = person -> person.getName().contains(key);
        Predicate<Person> combineSurname = person -> person.getSurname().contains(key);
        Predicate<Person> combinePhone = person -> person.getPhone().contains(key);
        Predicate<Person> combineAddress = person -> person.getAddress().contains(key);
        Predicate<Person> combine = combineName.or(combineSurname.or(combinePhone.or(combineAddress)));
        var result = new ArrayList<Person>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}