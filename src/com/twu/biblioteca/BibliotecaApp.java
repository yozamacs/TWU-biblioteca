package com.twu.biblioteca;

import java.io.PrintStream;

public class BibliotecaApp {

    PrintStream out;

    public BibliotecaApp(PrintStream out) {
        this.out=out;

    }

    public static void main(String[] args) {
        BibliotecaApp ba = new BibliotecaApp(System.out);
        ba.start();
        BookList listOfBooks = new BookList();
        listOfBooks.add(new Book("A Wrinkle In Time"));
        listOfBooks.add(new Book("Great Gatsby"));
        listOfBooks.add(new Book("Anne of Green Gables"));
        System.out.println(listOfBooks.getList());
    }

    public void start() {
        out.println("Welcome to Biblioteca!!!!!");
    }
}
