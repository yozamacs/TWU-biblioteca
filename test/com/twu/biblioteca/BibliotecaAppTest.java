package com.twu.biblioteca;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaAppTest {
    private BibliotecaApp ba;
    private PrintStream out;

    @Before
    public void SetUp(){
        ArrayList<Book> bl = new ArrayList<Book>();
        bl.add(new Book("A Wrinkle In Time"));
        bl.add(new Book("Great Gatsby"));
        bl.add(new Book("Anne of Green Gables"));
        this.out = mock(PrintStream.class);
        this.ba = new BibliotecaApp(out, bl);
    }

    @Test
    public void whenBookIsCreatedTitleIsCorrect() {
        Book b = new Book("Great Gatsby");
        assertEquals(b.getTitle(), "Great Gatsby");
    }

    @Test
    public void welcomeMessageIsProduced() {
        ba.start();
        verify(out).println("Welcome to Biblioteca!!!!!");
    }

    @Test
    public void verifyBookTitlesArePrinted() {
        this.ba.start();
        verify(out).println("A Wrinkle In Time");
        verify(out).println("Great Gatsby");
        verify(out).println("Anne of Green Gables");
    }


}
