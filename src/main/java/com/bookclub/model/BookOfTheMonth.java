/*
 * Suresh, Sripathi Rao. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.model;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

/**
 * Represents a book assigned to a specific month.
 */
public class BookOfTheMonth {

    @Id
    private String id;

    private Integer month;

    @NotEmpty(message = "ISBN is a required field.")
    private String isbn;

    /**
     * Creates an empty BookOfTheMonth object.
     */
    public BookOfTheMonth() {
    }

    /**
     * Creates a BookOfTheMonth object.
     *
     * @param month the month number
     * @param isbn the book ISBN
     */
    public BookOfTheMonth(Integer month, String isbn) {
        this.month = month;
        this.isbn = isbn;
    }

    /**
     * Returns the document id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the document id.
     *
     * @param id the document id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the month.
     *
     * @return the month
     */
    public Integer getMonth() {
        return month;
    }

    /**
     * Sets the month.
     *
     * @param month the month value
     */
    public void setMonth(Integer month) {
        this.month = month;
    }

    /**
     * Returns the ISBN.
     *
     * @return the ISBN
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

    @Override
    public String toString() {
        return "BookOfTheMonth{id=" + id + ", month=" + month + ", isbn=" + isbn + "}";
    }
}