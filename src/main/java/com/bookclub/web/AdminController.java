/*
 * Suresh, Sripathi Rao. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.web;

import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.dao.BookOfTheMonthDao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * AdminController handles admin-only monthly book management pages.
 */
@Controller
@RequestMapping("/monthly-books")
public class AdminController {

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
     * Displays all monthly book records.
     *
     * @param model the model object
     * @return monthly books list view
     */
    @RequestMapping(method = RequestMethod.GET)
    public String showBookOfTheMonth(Model model) {
        List<BookOfTheMonth> monthlyBooks = bookOfTheMonthDao.list("999");

        model.addAttribute("monthlyBooks", monthlyBooks);
        return "monthly-books/list";
    }

    /**
     * Displays the new monthly book form.
     *
     * @param model the model object
     * @return monthly books new view
     */
    @RequestMapping(method = RequestMethod.GET, path = "/new")
    public String bookOfTheMonthForm(Model model) {
        model.addAttribute("months", getMonths());
        model.addAttribute("bookOfTheMonth", new BookOfTheMonth());

        return "monthly-books/new";
    }

    /**
     * Adds a new monthly book record.
     *
     * @param bookOfTheMonth the submitted monthly book object
     * @param bindingResult validation results
     * @param model the model object
     * @return form on error or redirect to monthly books page
     */
    @RequestMapping(method = RequestMethod.POST)
    public String addBookOfTheMonth(@Valid BookOfTheMonth bookOfTheMonth,
                                    BindingResult bindingResult,
                                    Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("months", getMonths());
            return "monthly-books/new";
        }

        bookOfTheMonthDao.add(bookOfTheMonth);
        return "redirect:/monthly-books";
    }

    /**
     * Removes a monthly book by id.
     *
     * @param id the monthly book id
     * @return redirect to monthly books page
     */
    @RequestMapping(method = RequestMethod.GET, path = "/remove/{id}")
    public String removeBookOfTheMonth(@PathVariable String id) {
        bookOfTheMonthDao.remove(id);

        return "redirect:/monthly-books";
    }

    /**
     * Returns month names by number.
     *
     * @return map of month numbers and names
     */
    private Map<Integer, String> getMonths() {
        Map<Integer, String> months = new LinkedHashMap<>();

        months.put(1, "January");
        months.put(2, "February");
        months.put(3, "March");
        months.put(4, "April");
        months.put(5, "May");
        months.put(6, "June");
        months.put(7, "July");
        months.put(8, "August");
        months.put(9, "September");
        months.put(10, "October");
        months.put(11, "November");
        months.put(12, "December");

        return months;
    }
}