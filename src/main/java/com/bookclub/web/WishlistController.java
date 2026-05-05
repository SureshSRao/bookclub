/*
 * Suresh, Sripathi Rao. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.web;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * WishlistController handles web page requests for wishlist management.
 */
@Controller
@RequestMapping("/wishlist")
public class WishlistController {

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
     * Displays the wishlist list page.
     *
     * @return wishlist list view
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showWishlist() {
        return "wishlist/list";
    }

    /**
     * Displays the new wishlist item form.
     *
     * @param model the model used to bind form data
     * @return new wishlist item view
     */
    @RequestMapping(method = RequestMethod.GET, path = "/new")
    public String wishlistForm(Model model) {
        model.addAttribute("wishlistItem", new WishlistItem());
        return "wishlist/new";
    }

    /**
     * Processes a new wishlist item form submission.
     *
     * @param wishlistItem the submitted wishlist item
     * @param bindingResult validation results
     * @param authentication the current authentication object
     * @return new form on validation errors or redirect to wishlist page
     */
    @RequestMapping(method = RequestMethod.POST)
    public String addWishlistItem(@Valid WishlistItem wishlistItem,
                                  BindingResult bindingResult,
                                  Authentication authentication) {
        wishlistItem.setUsername(authentication.getName());

        if (bindingResult.hasErrors()) {
            return "wishlist/new";
        }

        wishlistDao.add(wishlistItem);
        return "redirect:/wishlist";
    }

    /**
     * Displays the edit form for a selected wishlist item.
     *
     * @param id the wishlist item id
     * @param model the model used to bind the wishlist item
     * @return wishlist item edit view
     */
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public String showWishlistItem(@PathVariable String id, Model model) {
        WishlistItem wishlistItem = wishlistDao.find(id);

        model.addAttribute("wishlistItem", wishlistItem);
        return "wishlist/view";
    }

    /**
     * Processes updates to an existing wishlist item.
     *
     * @param wishlistItem the wishlist item containing updated values
     * @param bindingResult validation results
     * @param authentication the current authentication object
     * @return edit form on validation errors or redirect to wishlist page
     */
    @RequestMapping(method = RequestMethod.POST, path = "/update")
    public String updateWishlistItem(@Valid WishlistItem wishlistItem,
                                     BindingResult bindingResult,
                                     Authentication authentication) {
        wishlistItem.setUsername(authentication.getName());

        if (bindingResult.hasErrors()) {
            return "wishlist/view";
        }

        wishlistDao.update(wishlistItem);
        return "redirect:/wishlist";
    }

    /**
     * Removes a wishlist item by id.
     *
     * @param id the wishlist item id
     * @return redirect to wishlist page
     */
    @RequestMapping(method = RequestMethod.GET, path = "/remove/{id}")
    public String removeWishlistItem(@PathVariable String id) {
        wishlistDao.remove(id);

        return "redirect:/wishlist";
    }
}