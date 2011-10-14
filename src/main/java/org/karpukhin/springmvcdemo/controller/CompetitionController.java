package org.karpukhin.springmvcdemo.controller;

import org.karpukhin.springmvcdemo.dto.CompetitionSearchCriteria;
import org.karpukhin.springmvcdemo.model.Competition;
import org.karpukhin.springmvcdemo.service.ClassificationService;
import org.karpukhin.springmvcdemo.service.CompetitionService;
import org.karpukhin.springmvcdemo.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Pavel Karpukhin
 */
@Controller
public class CompetitionController {

	@Autowired
	private ClassificationService classificationService;
	@Autowired
	private CompetitionService competitionService;
	@Autowired
	private DisciplineService disciplineService;

	@RequestMapping("/competitions")
	public ModelAndView getCompetitionList(@ModelAttribute("criteria") CompetitionSearchCriteria criteria) {
		criteria.setStatuses(Arrays.asList("PUBLISHED", "HELD"));
		List<Competition> competitions = competitionService.getCompetitionsByCriteria(criteria);
        PagedListHolder<Competition> result = new PagedListHolder<Competition>(competitions);
        result.setPageSize(10);
        result.setPage(criteria.getPage());
		return new ModelAndView("competitions/list")
            .addObject("competitions", result.getPageList())
            .addObject("criteria", criteria)
            .addObject("disciplines", disciplineService.getAllDisciplines())
            .addObject("classifications", classificationService.getAllClassifications())
            .addObject("pageCount", result.getPageCount());
	}

	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

}
