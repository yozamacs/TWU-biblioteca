package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

public class Library {
    private final ArrayList<Book> bookList;

    public Library(ArrayList<Book> bookList) {
        this.bookList = bookList;

    }

    public void printBookList(PrintStream out) {
        out.println(String.format("%-18s| %-22s| %-4s", "Title", "Author", "Year"));
        for(Book b : bookList) {
            out.println(b.getDetails());
        }
    }


}
