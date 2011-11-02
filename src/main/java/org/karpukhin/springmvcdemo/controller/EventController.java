package org.karpukhin.springmvcdemo.controller;

import org.karpukhin.springmvcdemo.dto.DialogInfo;
import org.karpukhin.springmvcdemo.dto.EditEventDto;
import org.karpukhin.springmvcdemo.dto.EventSearchCriteria;
import org.karpukhin.springmvcdemo.model.Category;
import org.karpukhin.springmvcdemo.model.Discipline;
import org.karpukhin.springmvcdemo.model.Event;
import org.karpukhin.springmvcdemo.service.CategoryService;
import org.karpukhin.springmvcdemo.service.DisciplineService;
import org.karpukhin.springmvcdemo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pavel Karpukhin
 */
@Controller
public class EventController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private DisciplineService disciplineService;
    @Autowired
    private EventService eventService;

    /**
     * Default constructor
     */
    public EventController() {
    }

    /**
     * Constructs controller with given {@link CategoryService},
     * {@link DisciplineService} and {@link EventService} implementations
     * @param categoryService {@link CategoryService} implementation
     * @param disciplineService {@link DisciplineService} implementation
     * @param eventService    {@link EventService} implementation
     */
    public EventController(CategoryService categoryService, DisciplineService disciplineService, EventService eventService) {
        this.categoryService = categoryService;
        this.disciplineService = disciplineService;
        this.eventService = eventService;
    }

    /**
     * Returns view with list of events found by given discipline id and
     * event search criteria
     * @param disciplineId discipline id
     * @param criteria     event search criteria
     * @return view with list of events
     */
    @RequestMapping("/disciplines/{disciplineId:\\d+}/events")
    public ModelAndView getEventList(@PathVariable("disciplineId") int disciplineId,
                                     @ModelAttribute("criteria") EventSearchCriteria criteria) {
        criteria.getExample().setDisciplineId(disciplineId);
        List<Event> events = eventService.getEventsBySearchCriteria(criteria);
        PagedListHolder<Event> result = new PagedListHolder<Event>(events);
        result.setPageSize(10);
        result.setPage(criteria.getPage());
        return new ModelAndView("events/list")
            .addObject("events", result.getPageList())
            .addObject("criteria", criteria)
            .addObject("pageCount", result.getPageCount());
    }

    /**
     * Returns view with form for editing of event with given id
     * @param eventId event id
     * @return view with form
     */
    @RequestMapping(value = "/events/{eventId:\\d+}/edit", method = RequestMethod.GET)
    public ModelAndView getEventEditView(@PathVariable("eventId") int eventId) {
        Event event = eventService.getEventById(eventId);
        Discipline discipline = disciplineService.getDisciplineById(event.getDisciplineId());
        List<Category> categories = categoryService.getAllCategories();
        List<Category> eventCategories = categoryService.getCategoriesByEventId(eventId);
        EditEventDto editEventDto = new EditEventDto();
        editEventDto.setId(event.getId());
        editEventDto.setName(event.getName());
        editEventDto.setDisciplineId(event.getDisciplineId());
        editEventDto.setCategoryIds(getCategoryIds(eventCategories));
        return new ModelAndView("events/addEdit")
            .addObject("event", editEventDto)
            .addObject("discipline", discipline)
            .addObject("categories", categories);
    }

    /**
     * Saves event with given id
     * @param eventId event id
     * @param eventDto event data
     * @return redirect to the list of events
     */
    @RequestMapping(value = "/events/{eventId:\\d+}", method = RequestMethod.POST)
    public ModelAndView saveEditedEvent(@PathVariable("eventId") int eventId,
                                        @ModelAttribute("event") EditEventDto eventDto) {
        return new ModelAndView("redirect:/disciplines/" + eventDto.getDisciplineId() + "/events.html");
    }

    /**
     *
     * @param eventId
     * @return
     */
    @RequestMapping(value = "/events/{eventId:\\d+}/delete", method = RequestMethod.GET)
    public ModelAndView deleteEvent(@PathVariable("eventId") int eventId,
                                    @RequestParam("dialog") String dialog) {
        DialogInfo dialogInfo = new DialogInfo();
        dialogInfo.setDialog(dialog);
        if (eventService.isEventUsed(eventId)) {
            return new ModelAndView("common/messageDlg")
                .addObject("message", "Event can't be deleted as it is used")
                .addObject("dialogInfo", dialogInfo);
        }
        dialogInfo.setAction("/events/" + eventId + "/confirmDelete.html");
        return new ModelAndView("confirmDelete")
            .addObject("entityName", "Event")
            .addObject("dialogInfo", dialogInfo);
    }

    @RequestMapping(value = "/events/{eventId:\\d+}/confirmDelete")
    @ResponseBody
    public String confirmDeleteEvent(@PathVariable("eventId") int eventId) {
        return "OK";
    }

    private List<Integer> getCategoryIds(List<Category> categories) {
        List<Integer> result = new ArrayList<Integer>();
        for (Category category : categories) {
            result.add(category.getId());
        }
        return result;
    }
}
