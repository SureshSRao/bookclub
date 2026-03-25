/*
 * Suresh, S. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.service.dao;

import com.bookclub.model.Book;
import com.bookclub.service.GenericDao;

/**
 * BookDao interface.
 * This interface defines DAO operations for Book objects.
 */
public interface BookDao extends GenericDao<Book, String> {
}