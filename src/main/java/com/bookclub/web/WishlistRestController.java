/*
 * Suresh, Sripathi Rao. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.web;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * WishlistRestController exposes REST endpoints for wishlist data.
 */
@RestController
@RequestMapping(path = "/api/wishlist", produces = "application/json")
@CrossOrigin(origins = "*")
public class WishlistRestController {

    private WishlistDao wishlistDao;

    /**
     * Injects the WishlistDao implementation.
     *
     * @param wishlistDao the wishlist DAO implementation
     */
    @Autowired
    private void setWishlistDao(WishlistDao wishlistDao) {
        this.wishlistDao = wishlistDao;
    }

    /**
     * Returns wishlist items for the currently authenticated user.
     *
     * @param authentication the current authentication object
     * @return list of wishlist items for the authenticated user
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<WishlistItem> showWishlist(Authentication authentication) {
        String username = authentication.getName();

        return wishlistDao.list(username);
    }

    /**
     * Returns one wishlist item by id.
     *
     * @param id the wishlist item id
     * @return the matching wishlist item
     */
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public WishlistItem findById(@PathVariable String id) {
        return wishlistDao.find(id);
    }
}