package org.karpukhin.springmvcdemo.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.karpukhin.springmvcdemo.dao.EventDao;
import org.karpukhin.springmvcdemo.dto.EventSearchCriteria;
import org.karpukhin.springmvcdemo.model.Event;
import org.karpukhin.springmvcdemo.service.EventService;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author Pavel Karpukhin
 */
public class EventServiceImplTest {

    private static final int DISCIPLINE_ID = 123;
    private static final int EVENT_ID = 123;

    private EventDao eventDao;
    private EventService eventService;

    @Before
    public void setUp() {
        eventDao = mock(EventDao.class);
        eventService = new EventServiceImpl(eventDao);
    }

    @Test
    public void testGetEventsBySearchCriteria() {
        EventSearchCriteria criteria = mock(EventSearchCriteria.class);
        List<Event> events = mock(List.class);
        when(eventDao.getEventsBySearchCriteria(criteria)).thenReturn(events);
        List<Event> result = eventService.getEventsBySearchCriteria(criteria);
        assertNotNull(result);
        verify(eventDao).getEventsBySearchCriteria(criteria);
    }

    @Test
    public void testGetEventsByDisciplineId() {
        List<Event> events = mock(List.class);
        when(eventDao.getEventsByDisciplineId(DISCIPLINE_ID)).thenReturn(events);
        List<Event> result = eventService.getEventsByDisciplineId(DISCIPLINE_ID);
        assertNotNull(result);
        verify(eventDao).getEventsByDisciplineId(DISCIPLINE_ID);
    }

    @Test
    public void testGetEventById() {
        Event event = mock(Event.class);
        when(eventDao.getEventById(EVENT_ID)).thenReturn(event);
        Event result = eventService.getEventById(EVENT_ID);
        assertNotNull(result);
        verify(eventDao).getEventById(EVENT_ID);
    }
}
