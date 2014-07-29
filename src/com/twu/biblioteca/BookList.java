package com.twu.biblioteca;

/**
 * Created by alexjablonski on 7/29/14.
 */
public class BookList {
    String booklist = "";

    public boolean isEmpty() {
        return true;
    }

    public void add(Book b) {
        booklist += b.getTitle() + "\n";
    }


    public String getList() {
        return booklist;
    }
}
