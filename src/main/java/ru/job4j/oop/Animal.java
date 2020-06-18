package ru.job4j.oop;

public class Animal {

    private String name;

    public Animal(){
        super();
        System.out.println(Animal.class);
    }

    public Animal(String name) {
        super();
        this.name = name;
        System.out.println(Animal.class);
    }

    public static void main(String[] args) {
        Tiger barsik = new Tiger("Barsik");
    }
}