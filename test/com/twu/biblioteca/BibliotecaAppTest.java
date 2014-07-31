package com.twu.biblioteca;

import java.io.*;
import java.util.*;

import org.hamcrest.CoreMatchers;
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
    private BufferedReader br;
    Library library;
    private Menu menu;

    @Before
    public void SetUp() throws IOException {
        ArrayList<Book> bl = new ArrayList<Book>();
        Book b1 = mock(Book.class);
        when(b1.getDetails()).thenReturn("A Wrinkle In Time | Madeline L'engle      | 1995");
        when(b1.getTitle()).thenReturn("A Wrinkle In Time");
        bl.add(b1);
        Book b2 = mock(Book.class);
        when(b2.getDetails()).thenReturn("Great Gatsby and t| F. Scott Fitzgerald   | 1953");
        when(b2.getTitle()).thenReturn("The Great Gatsby");
        bl.add(b2);
        library = new Library(bl);
        this.out = mock(PrintStream.class);
        this.br = mock(BufferedReader.class);
        menu = new Menu(out);
        this.ba = new BibliotecaApp(library, out, br, menu);
    }


    @Test
    public void welcomeMessageIsProduced() {
        ba.displayWelcome();
        verify(out).println("Welcome to Biblioteca!!!!!");
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
        ba.chooseOption(9);
        verify(out).println("Option not valid, please choose again");
    }
    @Test
    public void shouldQuitOnQuit() {
        ba.chooseOption(1);
        ba.chooseOption(-1);
        verify(out).println("Goodbye!");
    }

    @Test
    public void shouldPromptTheUseForBookNameWhenCheckoutOptionIsSelected() throws IOException {
        when(this.br.readLine()).thenReturn("The Great Gatsby");
        ba.chooseOption(2);
        verify(out).println("Please enter a book title");
    }

    @Test
    public void shouldGetTheTitleFromTheUser() throws IOException {
        when(this.br.readLine()).thenReturn("The Great Gatsby");
        assertThat(ba.getBookTitleFromUser(br), is("The Great Gatsby"));
    }

    @Test
    public void shouldGetTheTitleFromTheUserWhenOptionTwoIsSelected() throws IOException {
        String bookTitle = "The Great Gatsby";
        when(this.br.readLine()).thenReturn(bookTitle);
        ba.chooseOption(2);
        assertThat(library.inList(bookTitle), CoreMatchers.is(false));
    }



}
