package org.karpukhin.springmvcdemo.dao;

import org.karpukhin.springmvcdemo.dto.EventSearchCriteria;
import org.karpukhin.springmvcdemo.model.Event;

import java.util.List;

/**
 * @author Pavel Karpukhin
 */
public interface EventDao extends EntityDao<Event> {

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
}
