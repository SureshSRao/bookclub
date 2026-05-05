/*
 * Suresh, Sripathi Rao. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.service;

import java.util.List;

/**
 * GenericCrudDao defines common CRUD operations for DAO classes.
 *
 * @param <E> the entity type managed by the DAO
 * @param <K> the key type used to find, list, or remove entities
 */
public interface GenericCrudDao<E, K> {

    /**
     * Adds a new entity.
     *
     * @param entity the entity to add
     */
    void add(E entity);

    /**
     * Updates an existing entity.
     *
     * @param entity the entity containing updated values
     */
    void update(E entity);

    /**
     * Removes an entity by key.
     *
     * @param key the key used to identify the entity to remove
     * @return true when the remove operation completes
     */
    boolean remove(K key);

    /**
     * Returns a list of entities filtered by key.
     *
     * @param key the key used to filter the list
     * @return a list of matching entities
     */
    List<E> list(K key);

    /**
     * Finds one entity by key.
     *
     * @param key the key used to find the entity
     * @return the matching entity
     */
    E find(K key);
}