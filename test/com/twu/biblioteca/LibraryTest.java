package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LibraryTest {

    PrintStream out;
    Library library;

    @Before
    public void setUp(){
        ArrayList<Book> bl = new ArrayList<Book>();
        Book b1 = mock(Book.class);
        when(b1.getDetails()).thenReturn("A Wrinkle In Time | Madeline L'engle      | 1995");
        when(b1.getTitle()).thenReturn("A Wrinkle In Time");
        bl.add(b1);
        Book b2 = mock(Book.class);
        when(b2.getDetails()).thenReturn("Great Gatsby and t| F. Scott Fitzgerald   | 1953");
        when(b2.getTitle()).thenReturn("Great Gatsby and the Long Title");
        bl.add(b2);
        library = new Library(bl);
        this.out = mock(PrintStream.class);
    }
    @Test
    public void verifyBookInfoIsPrinted() {

        //this.ba.start();
        library.printBookList(out);
        verify(out).println("Title             | Author                | Year");
        verify(out).println("A Wrinkle In Time | Madeline L'engle      | 1995");
        verify(out).println("Great Gatsby and t| F. Scott Fitzgerald   | 1953");
        //verify(out).println("Anne of Green Gables");
    }

    @Test
    public void ifBookIsCheckedOutRemoveFromList(){
        String bookTitle = "A Wrinkle In Time";
        library.checkOut(bookTitle);
        assertThat(library.inList(bookTitle), is(false));
    }



}