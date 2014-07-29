package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {
    private Book b;
    @Before
    public void SetUp() {
        this.b = new Book("Great Gatsby and the Long Title", "F. Scott Fitzgerald", 1953);
    }

    @Test
    public void shouldGetBookTitle() {
        assertEquals(b.getTitle(), "Great Gatsby and the Long Title");
    }

    @Test
    public void shouldGetBookAuthor(){
        assertEquals(b.getAuthor(), "F. Scott Fitzgerald");
    }

    @Test
    public void shouldGetYearPublished(){
        assertEquals(b.getYear(), 1953);
    }

    @Test
    public void shouldGetDetails(){
        assertEquals(b.getDetails(),"Great Gatsby and t| F. Scott Fitzgerald   | 1953");
    }

}
