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
    public List<Event> getEventByDisciplineId(int disciplineId) {
        EventSearchCriteria criteria = new EventSearchCriteria();
        criteria.getExample().setDisciplineId(disciplineId);
        return eventDao.getEventsBySearchCriteria(criteria);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Event getEventById(int eventId) {
        return eventDao.getEventById(eventId);
    }
}
