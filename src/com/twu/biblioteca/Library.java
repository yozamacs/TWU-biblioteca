package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

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


    public void checkOut(String bookTitle) {
        for (Book b: bookList) {
            if (b.getTitle().equals(bookTitle)){
                bookList.remove(b);
                return;
            }
        }
    }

    public boolean inList(String bookTitle) {
        for(Book b: bookList) {
            if (b.getTitle().equals(bookTitle)) {
                return true;
            }
        }
        return false;
    }
}
