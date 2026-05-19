package com.bookclub.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the WishlistItem model class.
 */
class WishlistItemTest {

    /**
     * Tests WishlistItem setters and getters.
     */
    @Test
    @DisplayName("WishlistItem setters should update fields")
    void wishlistItemSettersShouldUpdateFields() {
        WishlistItem wishlistItem = new WishlistItem();

        wishlistItem.setId("12345");
        wishlistItem.setIsbn("9780345339683");
        wishlistItem.setTitle("The Hobbit");
        wishlistItem.setUsername("admin");

        assertEquals("12345", wishlistItem.getId());
        assertEquals("9780345339683", wishlistItem.getIsbn());
        assertEquals("The Hobbit", wishlistItem.getTitle());
        assertEquals("admin", wishlistItem.getUsername());
    }
}