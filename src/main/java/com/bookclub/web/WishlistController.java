/*
 * Suresh, Sripathi Rao. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.web;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * WishlistController class.
 * This class handles requests for the wishlist pages.
 */
@Controller
@RequestMapping("/wishlist")
public class WishlistController {

    private WishlistDao wishlistDao;

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
     * Displays the wishlist page.
     *
     * @return wishlist/list view
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showWishlist() {
        return "wishlist/list";
    }

    /**
     * Displays the new wishlist item form.
     *
     * @param model model object
     * @return wishlist/new view
     */
    @RequestMapping(method = RequestMethod.GET, path = "/new")
    public String wishlistForm(Model model) {
        model.addAttribute("wishlistItem", new WishlistItem());
        return "wishlist/new";
    }

    /**
     * Processes a submitted wishlist item form.
     *
     * @param wishlistItem the submitted wishlist item
     * @param bindingResult validation results
     * @return wishlist/new if errors exist; otherwise redirect to /wishlist
     */
    @RequestMapping(method = RequestMethod.POST)
    public String addWishlistItem(@Valid WishlistItem wishlistItem, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "wishlist/new";
        }

        wishlistDao.add(wishlistItem);
        return "redirect:/wishlist";
    }
}