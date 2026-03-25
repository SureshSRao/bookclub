/*
 * Suresh, Sripathi Rao. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.service;

import java.util.List;

/**
 * GenericDao interface.
 *
 * @param <E> entity type
 * @param <K> key type
 */
public interface GenericDao<E, K> {

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