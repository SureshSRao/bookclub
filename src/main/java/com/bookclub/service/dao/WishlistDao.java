/*
 * Suresh, Sripathi Rao. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.service.dao;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.GenericCrudDao;

/**
 * WishlistDao interface.
 * This interface defines CRUD operations for WishlistItem objects.
 */
public interface WishlistDao extends GenericCrudDao<WishlistItem, String> {
}