package org.karpukhin.springmvcdemo.dao;

import org.karpukhin.springmvcdemo.dto.EventSearchCriteria;
import org.karpukhin.springmvcdemo.model.Event;

import java.util.List;

/**
 * @author Pavel Karpukhin
 */
public interface EventDao {

    /**
     * Returns list of events found by given search criteria
     * @param criteria event search criteria
     * @return list of events
     */
    List<Event> getEventsBySearchCriteria(EventSearchCriteria criteria);

    /**
     * Returns event found by given id
     * @param eventId event id
     * @return event
     */
    Event getEventById(int eventId);
}
