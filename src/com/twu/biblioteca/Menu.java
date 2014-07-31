package com.twu.biblioteca;

import java.io.PrintStream;

/**
 * Created by maryumstyles on 7/31/14.
 */
public class Menu {
    private PrintStream out;

    public Menu(PrintStream out) {
        this.out = out;
    }

    public void display() {
        out.println("Menu");
        out.println("1. Print Book List");
        out.println("2. Checkout a Book");
        out.println("If you would like to exit, please enter -1");
    }
}
