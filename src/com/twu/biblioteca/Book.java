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

    public String getDetails() {
        int titleChars = Math.min(getTitle().length(), 18);
        int authorChars = Math.min(getAuthor().length(), 22);
        return String.format("%-18s| %-22s| %-4d", getTitle().substring(0, titleChars), getAuthor().substring(0, authorChars), getYear());
    }
}
