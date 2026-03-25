/*
 * Suresh, S. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.web;

import com.bookclub.model.Book;
import com.bookclub.service.impl.MemBookDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * HomeController class handles navigation for the Bookclub application.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    /**
     * Displays the home page and a list of books.
     *
     * @param model model object
     * @return the index view
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showHome(Model model) {
        MemBookDao bookDao = new MemBookDao();
        List<Book> books = bookDao.list();

        model.addAttribute("books", books);
        return "index";
    }

    /**
     * Displays the About Us page.
     *
     * @param model model object
     * @return the about view
     */
    @RequestMapping(method = RequestMethod.GET, path = "/about")
    public String showAboutUs(Model model) {
        return "about";
    }

    /**
     * Displays the Contact Us page.
     *
     * @param model model object
     * @return the contact view
     */
    @RequestMapping(method = RequestMethod.GET, path = "/contact")
    public String showContactUs(Model model) {
        return "contact";
    }

    /**
     * Displays a single monthly book.
     *
     * @param id the book ISBN
     * @param model model object
     * @return the monthly-books/view view
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String getMonthlyBook(@PathVariable("id") String id, Model model) {
        MemBookDao bookDao = new MemBookDao();
        Book book = bookDao.find(id);

        model.addAttribute("book", book);
        return "monthly-books/view";
    }
}