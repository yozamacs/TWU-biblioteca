package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {
    private Book b;
    @Before
    public void SetUp() {
        this.b = new Book("Great Gatsby", "F. Scott Fitzgerald", 1953);
    }

    @Test
    public void shouldGetBookTitle() {
        assertEquals(b.getTitle(), "Great Gatsby");
    }

    @Test
    public void shouldGetBookAuthor(){
        assertEquals(b.getAuthor(), "F. Scott Fitzgerald");
    }

    @Test
    public void shouldGetYearPublished(){
        assertEquals(b.getYear(), 1953);
    }

}
