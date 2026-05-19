package com.bookclub.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the Book model class.
 */
class BookTest {

    /**
     * Tests the Book constructor and getter methods.
     */
    @Test
    @DisplayName("Book constructor should set all fields")
    void bookConstructorShouldSetFields() {
        Book book = new Book(
                "9781617294945",
                "Spring in Action",
                "Spring development guide",
                "https://openlibrary.org/books/test",
                520
        );

        assertEquals("9781617294945", book.getIsbn());
        assertEquals("Spring in Action", book.getTitle());
        assertEquals("Spring development guide", book.getDescription());
        assertEquals("https://openlibrary.org/books/test", book.getInfoUrl());
        assertEquals(520, book.getNumOfPages());
    }
}