/* 
 * Suresh, Sripathi Rao. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * HomeController class handles navigation for the Bookclub application.
 * This controller maps HTTP requests to their respective HTML views.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    /**
     * Handles requests to the home page.
     * @param model Model object for passing data to the view
     * @return index page
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showHome(Model model) {
        return "index";
    }

    /**
     * Handles requests to the About Us page.
     * @param model Model object
     * @return about page
     */
    @RequestMapping(method = RequestMethod.GET, path = "about")
    public String showAboutUs(Model model) {
        return "about";
    }

    /**
     * Handles requests to the Contact Us page.
     * @param model Model object
     * @return contact page
     */
    @RequestMapping(method = RequestMethod.GET, path = "contact")
    public String showContactUs(Model model) {
        return "contact";
    }
}