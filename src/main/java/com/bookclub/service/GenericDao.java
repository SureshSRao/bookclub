/*
 * Suresh, Sripathi Rao. (2026). CIS 530 Server-Side Development. Bellevue University.
 */

package com.bookclub.service;

import java.util.List;

/**
 * GenericDao defines read-only DAO operations.
 *
 * @param <E> entity type
 * @param <K> key type
 */
public interface GenericDao<E, K> {

    /**
     * Returns a list of entities filtered by key.
     *
     * @param key the filter key
     * @return list of entities
     */
    List<E> list(K key);

    /**
     * Finds one entity by key.
     *
     * @param key the lookup key
     * @return matching entity
     */
    E find(K key);
}