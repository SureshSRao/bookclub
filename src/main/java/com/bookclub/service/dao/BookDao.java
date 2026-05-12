/*
 * Suresh, Sripathi Rao. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.service.dao;

import com.bookclub.model.Book;
import com.bookclub.service.GenericDao;

/**
 * DAO contract for Book data.
 */
public interface BookDao extends GenericDao<Book, String> {
}