/*
 * Suresh, Sripathi Rao. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;

/**
 * WishlistItem represents a single book entry stored in a user's wishlist.
 */
public class WishlistItem {

    @Id
    private String id;

    @NotNull(message = "ISBN is a required field.")
    @NotEmpty(message = "ISBN is a required field.")
    private String isbn;

    @NotNull(message = "Title is a required field.")
    @NotEmpty(message = "Title is a required field.")
    private String title;

    private String username;

    /**
     * Creates an empty WishlistItem object.
     */
    public WishlistItem() {
    }

    /**
     * Creates a WishlistItem with an ISBN and title.
     *
     * @param isbn the ISBN value
     * @param title the title value
     */
    public WishlistItem(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    /**
     * Sets the MongoDB document id.
     *
     * @param id the document id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the MongoDB document id.
     *
     * @return the document id
     */
    public String getId() {
        return id;
    }

    /**
     * Returns the ISBN.
     *
     * @return the ISBN value
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets the ISBN.
     *
     * @param isbn the ISBN value
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Returns the title.
     *
     * @return the title value
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

    /**
     * Returns the username associated with the wishlist item.
     *
     * @return the username value
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username associated with the wishlist item.
     *
     * @param username the authenticated username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns a formatted string representation of the wishlist item.
     *
     * @return formatted WishlistItem string
     */
    @Override
    public String toString() {
        return "WishlistItem{id=" + id + ", isbn=" + isbn + ", title=" + title
                + ", username=" + username + "}";
    }
}