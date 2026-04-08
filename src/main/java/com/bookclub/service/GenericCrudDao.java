/*
 * Suresh, Sripathi Rao. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.service;

import java.util.List;

/**
 * GenericCrudDao interface.
 *
 * @param <E> entity type
 * @param <K> key type
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
     * @param entity the entity to update
     */
    void update(E entity);

    /**
     * Removes an entity.
     *
     * @param entity the entity to remove
     * @return true if removed; otherwise false
     */
    boolean remove(E entity);

    /**
     * Returns a list of entities.
     *
     * @return list of entities
     */
    List<E> list();

    /**
     * Finds an entity by key.
     *
     * @param key the lookup key
     * @return matching entity
     */
    E find(K key);
}