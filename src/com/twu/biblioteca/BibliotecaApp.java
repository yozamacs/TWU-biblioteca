package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
public class BibliotecaApp {

    public static void main(String[] args) {
        ArrayList<Book> bl = new ArrayList<Book>();
        bl.add(new Book("A Wrinkle In Time", "Madeline L'engle", 1995));
        bl.add(new Book("Great Gatsby", "F. Scott Fitzgerald", 1953));
        bl.add(new Book("Anne of Green Gables", "A Lady", 1901));
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
        out.println("Menu");
        out.println("1. Print Book List");
    }

    public void chooseOption(int choice) {
        if(choice==1){
            printBookList();
        }
    }

    public void printBookList() {
        out.println(String.format("%-18s| %-22s| %-4s", "Title", "Author", "Year"));
        for(Book b : bl) {
            out.println(b.getDetails());
        }
    }

    public int getUserChoice(InputStream in) {
        return 1;
    }
}
