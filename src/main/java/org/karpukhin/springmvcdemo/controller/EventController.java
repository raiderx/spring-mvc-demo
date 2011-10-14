package org.karpukhin.springmvcdemo.controller;

import org.karpukhin.springmvcdemo.dto.EditEventDto;
import org.karpukhin.springmvcdemo.dto.EventSearchCriteria;
import org.karpukhin.springmvcdemo.model.Event;
import org.karpukhin.springmvcdemo.service.CategoryService;
import org.karpukhin.springmvcdemo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Pavel Karpukhin
 */
@Controller
public class EventController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private EventService eventService;

    /**
     * Default constructor
     */
    public EventController() {
    }

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping("/disciplines/{disciplineId}/events")
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

    @RequestMapping("/events/{eventId}")
    public ModelAndView getEventEditView(@PathVariable("eventId") int eventId) {
        Event event = eventService.getEventById(eventId);
        EditEventDto editEventDto = new EditEventDto();
        editEventDto.setName(event.getName());
        editEventDto.setDisciplineId(event.getDisciplineId());
        return new ModelAndView("events/addEdit")
            .addObject("event", editEventDto);
    }
}
