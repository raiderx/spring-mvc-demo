package org.karpukhin.springmvcdemo.service.impl;

import org.karpukhin.springmvcdemo.dao.CategoryDao;
import org.karpukhin.springmvcdemo.dto.CategorySearchCriteria;
import org.karpukhin.springmvcdemo.model.Category;
import org.karpukhin.springmvcdemo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel Karpukhin
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    /**
     * Default constructor
     */
    public CategoryServiceImpl() {
    }

    /**
     * Constructs object with given {@link CategoryDao} implementation
     * @param categoryDao
     */
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Category> getCategoriesBySearchCriteria(CategorySearchCriteria criteria) {
        return categoryDao.getCategoriesBySearchCriteria(criteria);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Category> getCategoriesByEventId(int eventId) {
        return new ArrayList<Category>();
    }

    @Override
    public List<Category> getAllCategories() {
        CategorySearchCriteria criteria = new CategorySearchCriteria();
        criteria.setSortColumn("id");
        return categoryDao.getCategoriesBySearchCriteria(criteria);
    }
}
