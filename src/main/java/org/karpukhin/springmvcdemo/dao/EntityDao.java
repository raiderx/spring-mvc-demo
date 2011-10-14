package org.karpukhin.springmvcdemo.dao;

import org.karpukhin.springmvcdemo.model.Entity;

/**
 * @author Pavel Karpukhin
 */
public interface EntityDao<T extends Entity> {

    /**
     * Returns entity found by given id
     * @param id id
     * @return entity
     */
    T getById(int id);
}
