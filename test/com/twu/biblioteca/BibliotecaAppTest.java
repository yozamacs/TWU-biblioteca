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
        when(b1.getAuthor()).thenReturn("Madeline L'engle");
        when(b1.getYear()).thenReturn(1995);
        bl.add(b1);
        Book b2 = mock(Book.class);
        when(b2.getTitle()).thenReturn("Great Gatsby And The Long Title");
        when(b2.getAuthor()).thenReturn("F. Scott Fitzgerald");
        when(b2.getYear()).thenReturn(1953);
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
    public void verifyBookInfoIsPrinted() {
        this.ba.start();
        verify(out).println("Title             | Author                | Year");
        verify(out).println("A Wrinkle In Time | Madeline L'engle      | 1995");
        verify(out).println("Great Gatsby and t| F. Scott Fitzgerald   | 1953");
        //verify(out).println("Anne of Green Gables");
    }


}
