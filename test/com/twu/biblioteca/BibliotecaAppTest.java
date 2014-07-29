package com.twu.biblioteca;


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
        BookList bl = new BookList();
        bl.add(new Book("A Wrinkle In Time"));
        bl.add(new Book("Great Gatsby"));
        bl.add(new Book("Anne of Green Gables"));
        this.out = mock(PrintStream.class);
        this.ba = new BibliotecaApp(out,bl);
    }


    @Test
    public void whenBookIsCreatedTitleIsCorrect() {
        Book b = new Book("Great Gatsby");
        assertEquals(b.getTitle(), "Great Gatsby");
    }

    @Test
    public void viewListOfBooksWhenRequested(){
        BookList bl = new BookList();
        assertTrue(bl.isEmpty());
        assertEquals(bl.getList(), "");
    }

    @Test
    public void addBookToListAndVerifyTitleAdded(){
        BookList bl = new BookList();
        Book b = new Book("Maryum's Book");
        bl.add(b);
        assertEquals(bl.getList(), "Maryum's Book\n");
    }

    @Test
    public void addTwoBooksToListAndSeeBothTitles(){
        BookList bl = new BookList();
        Book b = new Book ("Alex's Book");
        Book c = new Book ("Maryum's Book");
        bl.add(b);
        bl.add(c);
        assertEquals(bl.getList(), "Alex's Book\nMaryum's Book\n");
    }

    @Test
    public void welcomeMessageIsProduced() {
        ba.start();
        verify(out).println("Welcome to Biblioteca!!!!!");
    }

    @Test
    public void verifyBookTitlesArePrinted() {
        this.ba.start();
        verify(out).println("A Wrinkle In Time\nGreat Gatsby\nAnne of Green Gables\n");
    }
}
