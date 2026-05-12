/*
 * Suresh, Sripathi Rao. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.service.impl;

import com.bookclub.model.BookOfTheMonth;
import com.bookclub.service.dao.BookOfTheMonthDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MongoBookOfTheMonthDao provides MongoDB CRUD operations for monthly books.
 */
@Repository("bookOfTheMonthDao")
public class MongoBookOfTheMonthDao implements BookOfTheMonthDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Adds a monthly book record.
     *
     * @param entity the monthly book record
     */
    @Override
    public void add(BookOfTheMonth entity) {
        mongoTemplate.save(entity);
    }

    /**
     * Updates a monthly book record.
     *
     * @param entity the monthly book record
     */
    @Override
    public void update(BookOfTheMonth entity) {
        mongoTemplate.save(entity);
    }

    /**
     * Removes a monthly book record by id.
     *
     * @param key the document id
     * @return true when remove completes
     */
    @Override
    public boolean remove(String key) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(key));

        mongoTemplate.remove(query, BookOfTheMonth.class);

        return true;
    }

    /**
     * Returns monthly book records. A key of 999 returns all records.
     *
     * @param key month number or 999 for all
     * @return list of monthly books
     */
    @Override
    public List<BookOfTheMonth> list(String key) {
        int month = Integer.parseInt(key);

        if (month == 999) {
            return mongoTemplate.findAll(BookOfTheMonth.class);
        }

        Query query = new Query();
        query.addCriteria(Criteria.where("month").is(month));

        return mongoTemplate.find(query, BookOfTheMonth.class);
    }

    /**
     * Finds a monthly book record by id.
     *
     * @param key the document id
     * @return matching monthly book
     */
    @Override
    public BookOfTheMonth find(String key) {
        return mongoTemplate.findById(key, BookOfTheMonth.class);
    }
}