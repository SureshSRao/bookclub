/*
 * Suresh, S. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.web;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.impl.MemWishlistDao;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * WishlistController class.
 * This class handles requests for the wishlist pages.
 */
@Controller
@RequestMapping("/wishlist")
public class WishlistController {

    /**
     * Displays the wishlist page.
     *
     * @param model model object
     * @return wishlist/list view
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showWishlist(Model model) {
        MemWishlistDao wishlistDao = new MemWishlistDao();
        List<WishlistItem> wishlist = wishlistDao.list();

        model.addAttribute("wishlist", wishlist);
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

        return "redirect:/wishlist";
    }
}