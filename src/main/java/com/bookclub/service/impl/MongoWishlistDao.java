/*
 * Suresh, Sripathi Rao. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.service.impl;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MongoWishlistDao class.
 * This class provides MongoDB persistence for wishlist items.
 */
@Repository("wishlistDao")
public class MongoWishlistDao implements WishlistDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Adds a new wishlist item to MongoDB.
     *
     * @param entity the wishlist item to add
     */
    @Override
    public void add(WishlistItem entity) {
        mongoTemplate.save(entity);
    }

    /**
     * Updates an existing wishlist item in MongoDB.
     *
     * @param entity the wishlist item to update
     */
    @Override
    public void update(WishlistItem entity) {
        mongoTemplate.save(entity);
    }

    /**
     * Removes a wishlist item from MongoDB.
     *
     * @param entity the wishlist item to remove
     * @return true if removed; otherwise false
     */
    @Override
    public boolean remove(WishlistItem entity) {
        WishlistItem deletedItem = mongoTemplate.findAndRemove(
                org.springframework.data.mongodb.core.query.Query.query(
                        org.springframework.data.mongodb.core.query.Criteria.where("isbn").is(entity.getIsbn())
                ),
                WishlistItem.class
        );

        return deletedItem != null;
    }

    /**
     * Returns all wishlist items.
     *
     * @return list of wishlist items
     */
    @Override
    public List<WishlistItem> list() {
        return mongoTemplate.findAll(WishlistItem.class);
    }

    /**
     * Finds a wishlist item by ISBN.
     *
     * @param key the ISBN value
     * @return matching WishlistItem or null if not found
     */
    @Override
    public WishlistItem find(String key) {
        return mongoTemplate.findOne(
                org.springframework.data.mongodb.core.query.Query.query(
                        org.springframework.data.mongodb.core.query.Criteria.where("isbn").is(key)
                ),
                WishlistItem.class
        );
    }
}