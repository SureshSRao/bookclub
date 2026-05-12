/*
 * Suresh, Sripathi Rao. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.service.dao;

import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.GenericCrudDao;

/**
 * DAO contract for BookOfTheMonth CRUD operations.
 */
public interface BookOfTheMonthDao extends GenericCrudDao<BookOfTheMonth, String> {
}