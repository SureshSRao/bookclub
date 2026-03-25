/*
 * Suresh, S. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.service.impl;

import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * MemBookDao class.
 * This class provides an in-memory list of books.
 */
public class MemBookDao implements BookDao {

    private List<Book> books = new ArrayList<>();

    /**
     * Default constructor.
     * Loads five books into memory.
     */
    public MemBookDao() {
        books.add(new Book(
                "9780134685991",
                "Effective Java",
                "A practical guide to best practices for the Java platform.",
                416,
                Arrays.asList("Joshua Bloch")
        ));

        books.add(new Book(
                "9781617294945",
                "Spring in Action",
                "A hands-on guide to building Spring-based applications.",
                520,
                Arrays.asList("Craig Walls")
        ));

        books.add(new Book(
                "9780132350884",
                "Clean Code",
                "A handbook of agile software craftsmanship.",
                464,
                Arrays.asList("Robert C. Martin")
        ));

        books.add(new Book(
                "9781492072508",
                "Designing Data-Intensive Applications",
                "Concepts and patterns for reliable, scalable systems.",
                616,
                Arrays.asList("Martin Kleppmann")
        ));

        books.add(new Book(
                "9780596009205",
                "Head First Design Patterns",
                "A learner-friendly guide to software design patterns.",
                694,
                Arrays.asList("Eric Freeman", "Bert Bates", "Kathy Sierra", "Elisabeth Robson")
        ));
    }

    /**
     * Returns all books.
     *
     * @return list of books
     */
    @Override
    public List<Book> list() {
        return this.books;
    }

    /**
     * Finds a book by ISBN.
     *
     * @param key the ISBN value
     * @return matching Book or a new Book if not found
     */
    @Override
    public Book find(String key) {
        for (Book book : this.books) {
            if (book.getIsbn().equals(key)) {
                return book;
            }
        }

        return new Book();
    }
}