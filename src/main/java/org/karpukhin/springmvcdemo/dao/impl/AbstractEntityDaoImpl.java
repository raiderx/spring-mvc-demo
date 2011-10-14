package org.karpukhin.springmvcdemo.dao.impl;

import org.karpukhin.springmvcdemo.dto.SearchCriteria;
import org.karpukhin.springmvcdemo.model.Entity;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Pavel Karpukhin
 */
public abstract class AbstractEntityDaoImpl<T extends Entity> {

    protected List<T> sortEntities(List<T> entities, SearchCriteria criteria) {
        if (criteria == null || criteria.getSortColumn() == null) {
            return entities;
        }
        Comparator<T> comparator = createComparator(criteria);
        Collections.sort(entities, comparator);
        return entities;
    }

    protected abstract Comparator<T> createComparator(SearchCriteria<T> criteria);
}
