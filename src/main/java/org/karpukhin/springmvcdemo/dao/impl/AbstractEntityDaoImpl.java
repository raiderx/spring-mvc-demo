package org.karpukhin.springmvcdemo.dao.impl;

import org.karpukhin.springmvcdemo.dao.EntityDao;
import org.karpukhin.springmvcdemo.dto.SearchCriteria;
import org.karpukhin.springmvcdemo.model.Entity;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Pavel Karpukhin
 */
public abstract class AbstractEntityDaoImpl<T extends Entity> implements EntityDao<T> {

    /**
     * {@inheritDoc}
     */
    @Override
    public T getById(int id) {
        List<T> entities = getAllEntities();
        for (T entity : entities) {
            if (entity.getId() == id) {
                return entity;
            }
        }
        return null;
    }

    /**
     * Returns list of all entities
     * Implemented in childs
     * @return list of all entities
     */
    protected abstract List<T> getAllEntities();

    /**
     * Returns list of entities sorted by given search criteria
     * @param entities list of entities
     * @param criteria search criteria
     * @return sorted list of entities
     */
    protected List<T> sortEntities(List<T> entities, SearchCriteria criteria) {
        if (criteria == null || criteria.getSortColumn() == null) {
            return entities;
        }
        Comparator<T> comparator = createComparator(criteria);
        Collections.sort(entities, comparator);
        return entities;
    }

    /**
     * Creates comparator for given search criteria
     * Implemented in childs
     * @param criteria search criteria
     * @return comparator
     */
    protected abstract Comparator<T> createComparator(SearchCriteria<T> criteria);
}
