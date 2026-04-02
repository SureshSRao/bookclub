/*
 * Suresh, S. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.service.impl;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;

import java.util.ArrayList;
import java.util.List;

/**
 * MemWishlistDao class.
 * This class provides an in-memory list of wishlist items.
 */
public class MemWishlistDao implements WishlistDao {

    private List<WishlistItem> wishlist = new ArrayList<>();

    /**
     * Default constructor.
     * Loads sample wishlist items into memory.
     */
    public MemWishlistDao() {
        wishlist.add(new WishlistItem("9780345339683", "The Hobbit or There and Back Again"));
        wishlist.add(new WishlistItem("9780261103573", "The Fellowship of the Ring"));
        wishlist.add(new WishlistItem("9780261102361", "The Two Towers"));
        wishlist.add(new WishlistItem("9780261102378", "The Return of the King"));
    }

    /**
     * Returns all wishlist items.
     *
     * @return list of wishlist items
     */
    @Override
    public List<WishlistItem> list() {
        return this.wishlist;
    }

    /**
     * Finds a wishlist item by ISBN.
     *
     * @param key the ISBN value
     * @return matching WishlistItem or a new WishlistItem if not found
     */
    @Override
    public WishlistItem find(String key) {
        for (WishlistItem wishlistItem : this.wishlist) {
            if (wishlistItem.getIsbn().equals(key)) {
                return wishlistItem;
            }
        }

        return new WishlistItem();
    }
}