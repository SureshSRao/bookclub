/*
 * Suresh, Sripathi Rao. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.model;

import java.util.List;

/**
 * Book model class.
 * This class stores information for a single book.
 */
public class Book {

    private String isbn;
    private String title;
    private String description;
    private int numOfPages;
    private List<String> authors;

    /**
     * Default constructor.
     */
    public Book() {
    }

    /**
     * Parameterized constructor.
     *
     * @param isbn the book ISBN
     * @param title the book title
     * @param description the book description
     * @param numOfPages the number of pages
     * @param authors the list of authors
     */
    public Book(String isbn, String title, String description, int numOfPages, List<String> authors) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.numOfPages = numOfPages;
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{isbn=" + isbn + ", title=" + title + ", description=" + description
                + ", numOfPages=" + numOfPages + ", authors=" + authors + "}";
    }
}