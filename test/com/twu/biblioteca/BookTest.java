package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {
    @Test
    public void shouldGetBookTitle() {
        Book b = new Book("Great Gatsby");
        assertEquals(b.getTitle(), "Great Gatsby");
    }

}
