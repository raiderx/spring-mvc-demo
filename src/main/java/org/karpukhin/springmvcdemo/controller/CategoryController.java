package org.karpukhin.springmvcdemo.controller;

import org.karpukhin.springmvcdemo.dto.CategorySearchCriteria;
import org.karpukhin.springmvcdemo.model.Category;
import org.karpukhin.springmvcdemo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Pavel Karpukhin
 */
@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/categories")
    public ModelAndView getCategoriesList(@ModelAttribute("criteria") CategorySearchCriteria criteria) {
        List<Category> categories = categoryService.getCategoriesBySearchCriteria(criteria);
        PagedListHolder<Category> result = new PagedListHolder<Category>(categories);
        result.setPageSize(10);
        result.setPage(criteria.getPage());
        return new ModelAndView("categories/list")
            .addObject("categories", result.getPageList())
            .addObject("criteria", criteria)
            .addObject("pageCount", result.getPageCount());
    }
}
