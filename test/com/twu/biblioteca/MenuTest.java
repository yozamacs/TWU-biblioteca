package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {

    PrintStream out;
    Menu menu;

    @Before
    public void setUp() {
       this.out = mock(PrintStream.class);
       this.menu = new Menu(out);
    }

    @Test
    public void showMenuOnStartup() {
        menu.display();
        verify(out).println("Menu");
        verify(out).println("1. Print Book List");
        verify(out).println("2. Checkout a Book");
    }

}