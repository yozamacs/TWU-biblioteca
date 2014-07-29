package com.twu.biblioteca;

import java.io.PrintStream;

public class BibliotecaApp {

    public static void main(String[] args) {
        BookList bl = new BookList();
        bl.add(new Book("A Wrinkle In Time"));
        bl.add(new Book("Great Gatsby"));
        bl.add(new Book("Anne of Green Gables"));
        BibliotecaApp ba = new BibliotecaApp(System.out, bl);
        ba.start();

    }

    PrintStream out;
    BookList bl;

    public BibliotecaApp(PrintStream out, BookList bl) {
        this.out=out;
        this.bl = bl;
    }

    public void start() {
        out.println("Welcome to Biblioteca!!!!!");
        out.println(bl.getList());
    }
}
