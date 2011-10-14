package org.karpukhin.springmvcdemo.service;

import org.karpukhin.springmvcdemo.dto.CategorySearchCriteria;
import org.karpukhin.springmvcdemo.model.Category;

import java.util.List;

/**
 * @author Pavel Karpukhin
 */
public interface CategoryService {

    /**
     * Returns list of categories found by given search criteria
     * @param criteria category search criteria
     * @return list of categories
     */
    List<Category> getCategoriesBySearchCriteria(CategorySearchCriteria criteria);

    /**
     * Returns list of categories found by given event id
     * @param eventId event id
     * @return list of categories
     */
    List<Category> getCategoriesByEventId(int eventId);

    /**
     * Returns list of all categories
     * @return list of all categories
     */
    List<Category> getAllCategories();
}
