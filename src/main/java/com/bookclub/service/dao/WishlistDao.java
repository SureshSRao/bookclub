/*
 * Suresh, S. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.service.dao;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.GenericDao;

/**
 * WishlistDao interface.
 * This interface defines DAO operations for WishlistItem objects.
 */
public interface WishlistDao extends GenericDao<WishlistItem, String> {
}