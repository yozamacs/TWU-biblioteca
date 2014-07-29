package com.twu.biblioteca;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BibliotecaAppTest {
    private BibliotecaApp ba;
    private PrintStream out;

    @Before
    public void SetUp(){
        ArrayList<Book> bl = new ArrayList<Book>();
        Book b1 = mock(Book.class);
        when(b1.getTitle()).thenReturn("A Wrinkle In Time");
        bl.add(b1);
        Book b2 = mock(Book.class);
        when(b2.getTitle()).thenReturn("Great Gatsby");
        bl.add(b2);
        this.out = mock(PrintStream.class);
        this.ba = new BibliotecaApp(out, bl);
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
        //verify(out).println("Anne of Green Gables");
    }


}
