package org.karpukhin.springmvcdemo.service;

import org.karpukhin.springmvcdemo.dto.EventSearchCriteria;
import org.karpukhin.springmvcdemo.model.Event;

import java.util.List;

/**
 * @author Pavel Karpukhin
 */
public interface EventService {

    /**
     * Returns list of events found by given search criteria
     * @param criteria event search criteria
     * @return list of events
     */
    List<Event> getEventsBySearchCriteria(EventSearchCriteria criteria);

    /**
     * Returns list of events found by given discipline id
     * @param disciplineId discipline id
     * @return list of events
     */
    List<Event> getEventsByDisciplineId(int disciplineId);

    /**
     * Returns event found by given id
     * @param eventId event id
     * @return event
     */
    Event getEventById(int eventId);
}
