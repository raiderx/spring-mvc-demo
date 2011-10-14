package org.karpukhin.springmvcdemo.dao.impl;

import org.karpukhin.springmvcdemo.dao.CategoryDao;
import org.karpukhin.springmvcdemo.dto.CategorySearchCriteria;
import org.karpukhin.springmvcdemo.dto.SearchCriteria;
import org.karpukhin.springmvcdemo.model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Pavel Karpukhin
 */
@Repository
public class CategoryDaoImpl extends AbstractEntityDaoImpl<Category> implements CategoryDao {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Category> getCategoriesBySearchCriteria(CategorySearchCriteria criteria) {
        List<Category> categories = getAllEntities();
        List<Category> result = new ArrayList<Category>();
        for (Category category : categories) {
            if (doesCategorySatisfyCriteria(category, criteria)) {
                result.add(category);
            }
        }
        return sortEntities(result, criteria);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Comparator<Category> createComparator(SearchCriteria criteria) {
        final boolean sortById = "id".equals(criteria.getSortColumn().toLowerCase());
        final boolean sortByName = "name".equals(criteria.getSortColumn().toLowerCase());
        final boolean sortByDescription = "description".equals(criteria.getSortColumn().toLowerCase());
        final int multiplier = "asc".equals(criteria.getSortOrder().toLowerCase()) ? 1 : -1;
        Comparator<Category> comparator = new Comparator<Category>() {
            @Override
            public int compare(Category c1, Category c2) {
                if (sortById) {
                    return c1.getId().compareTo(c2.getId()) * multiplier;
                }
                if (sortByName) {
                    return c1.getName().compareTo(c2.getName()) * multiplier;
                }
                if (sortByDescription) {
                    return c1.getDescription().compareTo(c2.getDescription()) * multiplier;
                }
                return 0;
            }
        };
        return comparator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected List<Category> getAllEntities() {
        List<Category> categories = new ArrayList<Category>();
        categories.add(new Category(1, "Y", "General", true));
        categories.add(new Category(2, "Y16", "Public junior", true));
        categories.add(new Category(3, "N", "Ladies", true));
        categories.add(new Category(4, "N16", "Junior women", true));
        categories.add(new Category(5, "Y50", "Senior general", true));
        categories.add(new Category(5, "R", "Removed category", false));
        return categories;
    }

    private static boolean doesCategorySatisfyCriteria(Category category, CategorySearchCriteria criteria) {
        if (category != null && criteria != null) {
            if (criteria.getExample().getActive() != null && category.getActive() != criteria.getExample().getActive()) {
                return false;
            }
            if (criteria.getExample().getName() != null && !criteria.getExample().getName().isEmpty() && !category.getName().contains(criteria.getExample().getName())) {
                return false;
            }
        }
        return true;
    }
}
