package org.karpukhin.springmvcdemo.controller;

import org.junit.Before;
import org.junit.Test;
import org.karpukhin.springmvcdemo.dto.EventSearchCriteria;
import org.karpukhin.springmvcdemo.model.Event;
import org.karpukhin.springmvcdemo.service.CategoryService;
import org.karpukhin.springmvcdemo.service.DisciplineService;
import org.karpukhin.springmvcdemo.service.EventService;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.ModelAndViewAssert.assertViewName;

/**
 * @author Pavel Karpukhin
 */
public class EventControllerTest {

    private static final int DISCIPLINE_ID = 123;

    private CategoryService categoryService;
    private DisciplineService disciplineService;
    private EventService eventService;
    private EventController eventController;

    @Before
    public void setUp() {
        categoryService = mock(CategoryService.class);
        disciplineService = mock(DisciplineService.class);
        eventService = mock(EventService.class);
        eventController = new EventController(categoryService, disciplineService, eventService);
    }

    @Test
    public void testGetEventList() {
        EventSearchCriteria criteria = mock(EventSearchCriteria.class);
        Event example = mock(Event.class);
        List<Event> events = mock(List.class);
        when(criteria.getExample()).thenReturn(example);
        when(eventService.getEventsBySearchCriteria(criteria)).thenReturn(events);
        ModelAndView mav = eventController.getEventList(DISCIPLINE_ID, criteria);
        assertViewName(mav, "events/list");
        verify(eventService).getEventsBySearchCriteria(criteria);
    }
}
