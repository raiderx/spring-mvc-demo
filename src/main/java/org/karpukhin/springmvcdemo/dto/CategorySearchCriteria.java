package org.karpukhin.springmvcdemo.dto;

import org.karpukhin.springmvcdemo.model.Category;

/**
 * @author Pavel Karpukhin
 */
public class CategorySearchCriteria extends SearchCriteria<Category> {

    /**
     * Default constructor
     */
    public CategorySearchCriteria() {
        super(new Category(), "name", "asc");
    }
}
