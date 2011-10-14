package org.karpukhin.springmvcdemo.controller;

import org.karpukhin.springmvcdemo.dto.DisciplineSearchCriteria;
import org.karpukhin.springmvcdemo.dto.EditDisciplineDto;
import org.karpukhin.springmvcdemo.model.Category;
import org.karpukhin.springmvcdemo.model.Discipline;
import org.karpukhin.springmvcdemo.model.Event;
import org.karpukhin.springmvcdemo.service.CategoryService;
import org.karpukhin.springmvcdemo.service.DisciplineService;
import org.karpukhin.springmvcdemo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pavel Karpukhin
 */
@Controller
public class DisciplineController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private DisciplineService disciplineService;
    @Autowired
    private EventService eventService;

    /**
     * Default constructor
     */
    public DisciplineController() {
    }

    /**
     * Constructs controller with given {@link DisciplineService} implementation
     */
    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    /**
     * Returns view with list of disciplines found by given search criteria
     * @param criteria discipline search criteria
     * @return view with list of disciplines
     */
    @RequestMapping("/disciplines")
    public ModelAndView getDisciplineList(@ModelAttribute("criteria") DisciplineSearchCriteria criteria) {
        List<Discipline> disciplines = disciplineService.getDisciplinesByCriteria(criteria);
        PagedListHolder<Discipline> result = new PagedListHolder<Discipline>(disciplines);
        result.setPageSize(10);
        result.setPage(criteria.getPage());
        return new ModelAndView("disciplines/list")
            .addObject("disciplines", result.getPageList())
            .addObject("criteria", criteria)
            .addObject("pageCount", result.getPageCount());
    }

    @RequestMapping(value = "/disciplines/{disciplineId}/edit", method = RequestMethod.GET)
    public ModelAndView getDisciplineEditView(@PathVariable("disciplineId") int disciplineId) {
        Discipline discipline = disciplineService.getDisciplineById(disciplineId);
        List<Event> events = eventService.getEventsByDisciplineId(disciplineId);
        List<Category> categories = categoryService.getAllCategories();
        Map<Integer, List<Integer>> eventCategories = new HashMap<Integer, List<Integer>>();
        for (Event event : events) {
            List<Category> c = categoryService.getCategoriesByEventId(event.getId());
            eventCategories.put(event.getId(), getCategoryIds(c));
        }

        EditDisciplineDto disciplineDto = new EditDisciplineDto();
        disciplineDto.setId(discipline.getId());
        disciplineDto.setName(discipline.getName());
        disciplineDto.setEventCategories(eventCategories);
        return new ModelAndView("disciplines/addEdit")
            .addObject("discipline", disciplineDto)
            .addObject("events", events)
            .addObject("categories", categories);
    }

    @RequestMapping(value = "/disciplines/{disciplineId}", method = RequestMethod.POST)
    public ModelAndView saveEditedDiscipline(@PathVariable("disciplineId") int disciplineId,
                                             @ModelAttribute("discipline") EditDisciplineDto DisciplineDto) {
        return new ModelAndView("redirect:/disciplines.html");
    }

    private List<Integer> getCategoryIds(List<Category> categories) {
        List<Integer> result = new ArrayList<Integer>();
        for (Category category : categories) {
            result.add(category.getId());
        }
        return result;
    }
}
