/*
 * Suresh, Sripathi Rao. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.service.impl;

import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MongoWishlistDao provides MongoDB CRUD operations for WishlistItem objects.
 */
@Repository("wishlistDao")
public class MongoWishlistDao implements WishlistDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * Adds a wishlist item to MongoDB.
     *
     * @param entity the wishlist item to save
     */
    @Override
    public void add(WishlistItem entity) {
        mongoTemplate.save(entity);
    }

    /**
     * Updates an existing wishlist item in MongoDB.
     *
     * @param entity the wishlist item containing updated values
     */
    @Override
    public void update(WishlistItem entity) {
        WishlistItem wishlistItem = mongoTemplate.findById(entity.getId(), WishlistItem.class);

        if (wishlistItem != null) {
            wishlistItem.setIsbn(entity.getIsbn());
            wishlistItem.setTitle(entity.getTitle());
            wishlistItem.setUsername(entity.getUsername());

            mongoTemplate.save(wishlistItem);
        }
    }

    /**
     * Removes a wishlist item from MongoDB by id.
     *
     * @param key the MongoDB document id
     * @return true when the remove operation completes
     */
    @Override
    public boolean remove(String key) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(key));

        mongoTemplate.remove(query, WishlistItem.class);

        return true;
    }

    /**
     * Returns wishlist items for a specific username.
     *
     * @param username the authenticated username
     * @return list of wishlist items owned by the user
     */
    @Override
    public List<WishlistItem> list(String username) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));

        return mongoTemplate.find(query, WishlistItem.class);
    }

    /**
     * Finds a wishlist item by MongoDB document id.
     *
     * @param key the MongoDB document id
     * @return the matching wishlist item
     */
    @Override
    public WishlistItem find(String key) {
        return mongoTemplate.findById(key, WishlistItem.class);
    }
}