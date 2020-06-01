package ru.job4j.pojo;

public class Library {

    public static void main(String[] args){
        Book[] book = new Book[4];
        book[0] = new Book("Java", 1000);
        book[1] = new Book("Python", 900);
        book[2] = new Book("C++", 800);
        book[3] = new Book("Clean code", 700);
        for (int index = 0; index < book.length; index++) {
            System.out.println(index + ". " + book[index].getName() + "  страниц - " + book[index].getNumber());
        }
        System.out.println();
        System.out.println("Меняем 0 и 3 книгу");
        //book[0].swap(book[3]);
        Book temp = new Book();
        temp = book[0];
        book[0] = book[3];
        book[3] = temp;
        for (int index = 0; index < book.length; index++) {
            System.out.println(index + ". " + book[index].getName() + "  страниц - " + book[index].getNumber());
        }
        System.out.println();
        System.out.println("Выводим книги Clean Code");
        for (int index = 0; index < book.length; index++) {
            if (book[index].getName().equals("Clean code")) {
                System.out.println(index + ". " + book[index].getName() + "  страниц - " + book[index].getNumber());
            }
        }
    }
}
