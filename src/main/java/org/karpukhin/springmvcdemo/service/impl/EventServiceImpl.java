package org.karpukhin.springmvcdemo.service.impl;

import org.karpukhin.springmvcdemo.dao.EventDao;
import org.karpukhin.springmvcdemo.dto.EventSearchCriteria;
import org.karpukhin.springmvcdemo.model.Event;
import org.karpukhin.springmvcdemo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Pavel Karpukhin
 */
@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventDao eventDao;

    /**
     * Default constructor
     */
    public EventServiceImpl() {
    }

    /**
     * Constructs object with given {@link EventDao} implementation
     * @param eventDao {@link EventDao} implementation
     */
    public EventServiceImpl(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Event> getEventsBySearchCriteria(EventSearchCriteria criteria) {
        return eventDao.getEventsBySearchCriteria(criteria);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Event> getEventsByDisciplineId(int disciplineId) {
        return eventDao.getEventsByDisciplineId(disciplineId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Event getEventById(int eventId) {
        return eventDao.getEventById(eventId);
    }
}
