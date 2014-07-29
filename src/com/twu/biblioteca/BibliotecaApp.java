package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.*;
public class BibliotecaApp {

    public static void main(String[] args) {
        ArrayList<Book> bl = new ArrayList<Book>();
        bl.add(new Book("A Wrinkle In Time"));
        bl.add(new Book("Great Gatsby"));
        bl.add(new Book("Anne of Green Gables"));
        BibliotecaApp ba = new BibliotecaApp(System.out, bl);
        ba.start();

    }

    PrintStream out;
    ArrayList<Book> bl;

    public BibliotecaApp(PrintStream out, ArrayList<Book> bl) {
        this.out=out;
        this.bl = bl;
    }

    public void start() {
        out.println("Welcome to Biblioteca!!!!!");
        for(Book b : bl) {
            out.println(b.getTitle());
        }
    }
}
