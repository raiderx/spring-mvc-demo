package org.karpukhin.springmvcdemo.controller;

import org.karpukhin.springmvcdemo.dto.DisciplineSearchCriteria;
import org.karpukhin.springmvcdemo.model.Discipline;
import org.karpukhin.springmvcdemo.service.DisciplineService;
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
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;

    @RequestMapping("/disciplines")
    public ModelAndView getDisciplinesList(@ModelAttribute("criteria") DisciplineSearchCriteria criteria) {
        List<Discipline> disciplines = disciplineService.getDisciplinesByCriteria(criteria);
        PagedListHolder<Discipline> result = new PagedListHolder<Discipline>(disciplines);
        result.setPageSize(10);
        result.setPage(criteria.getPage());
        return new ModelAndView("disciplines/list")
            .addObject("disciplines", result.getPageList())
            .addObject("criteria", criteria)
            .addObject("pageCount", result.getPageCount());
    }
}
