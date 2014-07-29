package com.twu.biblioteca;

/**
 * Created by alexjablonski on 7/29/14.
 */
public class Book {
    private String title;
    private String author;
    private int pubYear;

    public Book(String t, String a, int p) {
        title = t;
        author = a;
        pubYear = p;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return pubYear;
    }
}
