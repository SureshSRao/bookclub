/*
 * Suresh, Sripathi Rao. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.web;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import com.bookclub.service.impl.MongoWishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * WishlistRestController class.
 * This class exposes RESTful endpoints for wishlist items.
 */
@RestController
@RequestMapping(path = "/api/wishlist", produces = "application/json")
@CrossOrigin(origins = "*")
public class WishlistRestController {

    private WishlistDao wishlistDao = new MongoWishlistDao();

    /**
     * Sets the wishlist DAO.
     *
     * @param wishlistDao the wishlist DAO implementation
     */
    @Autowired
    private void setWishlistDao(WishlistDao wishlistDao) {
        this.wishlistDao = wishlistDao;
    }

    /**
     * Returns all wishlist items.
     *
     * @return list of wishlist items
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<WishlistItem> showWishlist() {
        return wishlistDao.list();
    }

    /**
     * Returns a wishlist item by id.
     *
     * @param id the wishlist item id
     * @return matching wishlist item
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public WishlistItem findById(@PathVariable String id) {
        return wishlistDao.find(id);
    }
}