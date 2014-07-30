package com.twu.biblioteca;

import java.io.*;
import java.util.*;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BibliotecaAppTest {
    private BibliotecaApp ba;
    private PrintStream out;
    private InputStream in;
    private BufferedReader br;

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
        this.br = mock(BufferedReader.class);
        this.ba = new BibliotecaApp(out, bl,in);
    }


    @Test
    public void welcomeMessageIsProduced() {
        ba.displayMenu();
        verify(out).println("Welcome to Biblioteca!!!!!");
    }

    @Test
    public void verifyBookInfoIsPrinted() {

        //this.ba.start();
        ba.printBookList();
        verify(out).println("Title             | Author                | Year");
        verify(out).println("A Wrinkle In Time | Madeline L'engle      | 1995");
        verify(out).println("Great Gatsby and t| F. Scott Fitzgerald   | 1953");
        //verify(out).println("Anne of Green Gables");
    }

    @Test
    public void showMenuOnStartup(){
        ba.displayMenu();
        verify(out).println("Menu");
        verify(out).println("1. Print Book List");
    }

    @Test
    public void when1IsChosenPrintList(){
        //ba.start();
        ba.chooseOption(1);
        verify(out).println("Title             | Author                | Year");
        verify(out).println("A Wrinkle In Time | Madeline L'engle      | 1995");
        verify(out).println("Great Gatsby and t| F. Scott Fitzgerald   | 1953");
    }

    @Test
    public void userInputRetrieved() throws IOException {
        when(this.br.readLine()).thenReturn("1");
        assertThat(ba.getUserChoice(br), is(1));

    }

    @Test
    public void shouldNotifyUserOnInvalidMenuOption() {
        ba.chooseOption(2);
        verify(out).println("Option not valid, please choose again");
    }
    @Test
    public void shouldQuitOnQuit() {
        ba.chooseOption(1);
        ba.chooseOption(2);
        ba.chooseOption(-1);
        verify(out).println("Goodbye!");
    }

}
