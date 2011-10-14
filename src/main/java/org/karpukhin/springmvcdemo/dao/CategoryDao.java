package org.karpukhin.springmvcdemo.dao;

import org.karpukhin.springmvcdemo.dto.CategorySearchCriteria;
import org.karpukhin.springmvcdemo.model.Category;

import java.util.List;

/**
 * @author Pavel Karpukhin
 */
public interface CategoryDao {

    /**
     * Returns list of categories found by given search criteria
     * @param criteria category search criteria
     * @return list of categories
     */
    List<Category> getCategoriesBySearchCriteria(CategorySearchCriteria criteria);
}
