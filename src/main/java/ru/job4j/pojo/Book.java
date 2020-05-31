package ru.job4j.pojo;

public class Book {
    private String name;
    private int number;

    public Book(){

    }

    public Book(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void swap(Book book) {
        Book temp = new Book();
        temp.setName(this.getName());
        temp.setNumber(this.getNumber());
        this.setName(book.getName());
        this.setNumber(book.getNumber());
        book.setName(temp.getName());
        book.setNumber(temp.getNumber());
    }
}
