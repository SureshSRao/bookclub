/*
 * Suresh, Sripathi Rao. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.web;

import com.bookclub.model.Book;
import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.dao.BookDao;
import com.bookclub.service.dao.BookOfTheMonthDao;
import com.bookclub.service.impl.RestBookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Calendar;
import java.util.List;

/**
 * HomeController handles main navigation and monthly book display.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    private BookOfTheMonthDao bookOfTheMonthDao;

    /**
     * Injects the BookOfTheMonthDao implementation.
     *
     * @param bookOfTheMonthDao the monthly book DAO
     */
    @Autowired
    public void setBookOfTheMonthDao(BookOfTheMonthDao bookOfTheMonthDao) {
        this.bookOfTheMonthDao = bookOfTheMonthDao;
    }

    /**
     * Displays the home page with current month books.
     *
     * @param model the model object
     * @return index view
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showHome(Model model) {
        Calendar calendar = Calendar.getInstance();
        int calendarMonth = calendar.get(Calendar.MONTH) + 1;

        BookDao bookDao = new RestBookDao();
        List<BookOfTheMonth> monthlyBooks =
                bookOfTheMonthDao.list(Integer.toString(calendarMonth));

        StringBuilder isbnBuilder = new StringBuilder();
        isbnBuilder.append("ISBN:");

        for (BookOfTheMonth monthlyBook : monthlyBooks) {
            isbnBuilder.append(monthlyBook.getIsbn()).append(",");
        }

        List<Book> books;

        if (monthlyBooks.isEmpty()) {
            books = bookDao.list("ISBN:9780593099322");
        } else {
            String isbnString = isbnBuilder.substring(0, isbnBuilder.length() - 1);
            books = bookDao.list(isbnString);
        }

        model.addAttribute("books", books);
        return "index";
    }

    /**
     * Displays the About Us page.
     *
     * @return about view
     */
    @RequestMapping(method = RequestMethod.GET, path = "/about")
    public String showAboutUs() {
        return "about";
    }

    /**
     * Displays the Contact Us page.
     *
     * @return contact view
     */
    @RequestMapping(method = RequestMethod.GET, path = "/contact")
    public String showContactUs() {
        return "contact";
    }

    /**
     * Displays selected book details.
     *
     * @param id the ISBN id
     * @param model the model object
     * @return monthly book detail view
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String getMonthlyBook(@PathVariable("id") String id, Model model) {
        BookDao bookDao = new RestBookDao();

        model.addAttribute("book", bookDao.find(id));
        return "monthly-books/view";
    }
}