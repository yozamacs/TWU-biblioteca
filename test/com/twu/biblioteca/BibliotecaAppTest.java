package com.twu.biblioteca;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BibliotecaAppTest {
    private BibliotecaApp ba;
    private PrintStream out;
    private InputStream in;

    @Before
    public void SetUp() throws IOException {
        ArrayList<Book> bl = new ArrayList<Book>();
        Book b1 = mock(Book.class);
        when(b1.getDetails()).thenReturn("A Wrinkle In Time | Madeline L'engle      | 1995");
        bl.add(b1);
        Book b2 = mock(Book.class);
        when(b2.getDetails()).thenReturn("Great Gatsby and t| F. Scott Fitzgerald   | 1953");
        bl.add(b2);
        this.out = mock(PrintStream.class);
        this.in = mock(InputStream.class);
        when(this.in.read()).thenReturn(1);
        //this.in.
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
        ba.printBookList();
        verify(out).println("Title             | Author                | Year");
        verify(out).println("A Wrinkle In Time | Madeline L'engle      | 1995");
        verify(out).println("Great Gatsby and t| F. Scott Fitzgerald   | 1953");
        //verify(out).println("Anne of Green Gables");
    }

    @Test
    public void showMenuOnStartup(){
        ba.start();
        verify(out).println("Menu");
        verify(out).println("1. Print Book List");
    }

    @Test
    public void when1IsChosenPrintList(){
        ba.start();
        ba.chooseOption(1);
        verify(out).println("Title             | Author                | Year");
        verify(out).println("A Wrinkle In Time | Madeline L'engle      | 1995");
        verify(out).println("Great Gatsby and t| F. Scott Fitzgerald   | 1953");
    }

    @Test
    public void userInputRetrieved() {
        ba.start();
        assertThat(ba.getUserChoice(this.in), is(1));

    }

}
