/*
 * Suresh, Sripathi Rao. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

/**
 * WishlistItem model class.
 * This class stores information for a single wishlist item.
 */
public class WishlistItem {

    @NotNull(message = "ISBN is a required field.")
    @NotEmpty(message = "ISBN is a required field.")
    private String isbn;

    @NotNull(message = "Title is a required field.")
    @NotEmpty(message = "Title is a required field.")
    private String title;

    /**
     * Default constructor.
     */
    public WishlistItem() {
    }

    /**
     * Parameterized constructor.
     *
     * @param isbn the item ISBN
     * @param title the item title
     */
    public WishlistItem(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    /**
     * Returns the ISBN.
     *
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets the ISBN.
     *
     * @param isbn the isbn value
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Returns the title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title the title value
     */
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "WishlistItem{isbn=" + isbn + ", title=" + title + "}";
    }
}