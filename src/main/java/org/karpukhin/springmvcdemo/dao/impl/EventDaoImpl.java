package org.karpukhin.springmvcdemo.dao.impl;

import org.karpukhin.springmvcdemo.dao.EventDao;
import org.karpukhin.springmvcdemo.dto.EventSearchCriteria;
import org.karpukhin.springmvcdemo.model.Event;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Pavel Karpukhin
 */
@Repository
public class EventDaoImpl implements EventDao {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Event> getEventsBySearchCriteria(EventSearchCriteria criteria) {
        List<Event> events = getAllEvents();
        List<Event> result = new ArrayList<Event>();
        for (Event event : events) {
            if (doesDisciplineSatisfyCriteria(event, criteria)) {
                result.add(event);
            }
        }

        return sortEvents(result, criteria);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Event getEventById(int eventId) {
        List<Event> events = getAllEvents();
        for (Event event : events) {
            if (event.getId() == eventId) {
                return event;
            }
        }
        return null;
    }

    private List<Event> getAllEvents() {
        List<Event> events = new ArrayList<Event>();
        events.add(new Event(1, "Air rifle 60 shots", 1, true));
        events.add(new Event(2, "Air rifle 40 shots", 1, true));
        events.add(new Event(3, "Rifle 40 shots", 1, true));
        events.add(new Event(4, "Removed event", 1, false));
        events.add(new Event(5, "Air Pistol 60 shots", 2, true));
        events.add(new Event(6, "Air Pistol 40 shots", 2, true));
        events.add(new Event(7, "Removed event", 2, false));
        events.add(new Event(8, "Skeet 75 shots + 25 shots", 3, true));
        events.add(new Event(9, "Trap 75 shots + 25 shots", 3, true));
        events.add(new Event(10, "Removed event", 3, false));
        events.add(new Event(11, "Pistol", 5, true));
        events.add(new Event(12, "Rifle", 5, true));
        events.add(new Event(13, "Removed event", 5, false));
        events.add(new Event(14, "Pistol 40 shots", 6, true));
        events.add(new Event(15, "Rifle 40 shots", 6, true));
        events.add(new Event(16, "Removed event", 6, false));
        events.add(new Event(17, "Light Class 100 m", 7, true));
        events.add(new Event(18, "Heavy Class 300 m", 7, true));
        events.add(new Event(19, "Free Class 600 m", 7, true));
        events.add(new Event(20, "Removed event", 7, false));
        events.add(new Event(21, "No. 1 Miquel", 8, true));
        events.add(new Event(22, "No. 3 Minié", 8, true));
        events.add(new Event(23, "No. 2 Maximilian", 8, true));
        events.add(new Event(24, "Removed event", 8, false));
        return events;
    }

    private boolean doesDisciplineSatisfyCriteria(Event event, EventSearchCriteria criteria) {
        if (event != null && criteria != null) {
            if (criteria.getExample().getActive() != null && event.getActive() != criteria.getExample().getActive()) {
                return false;
            }
            if (criteria.getExample().getName() != null && !criteria.getExample().getName().isEmpty() && !event.getName().contains(criteria.getExample().getName())) {
                return false;
            }
            if (criteria.getExample().getDisciplineId() != null && event.getDisciplineId() != criteria.getExample().getDisciplineId()) {
                return false;
            }
        }
        return true;
    }

    private List<Event> sortEvents(List<Event> events, EventSearchCriteria criteria) {
        if (criteria == null || criteria.getSortColumn() == null) {
            return events;
        }
        final boolean sortByName = "name".equals(criteria.getSortColumn().toLowerCase());
        final int multiplier = "asc".equals(criteria.getSortOrder().toLowerCase()) ? 1 : -1;
        Comparator<Event> comparator = new Comparator<Event>() {
            @Override
            public int compare(Event d1, Event d2) {
                if (sortByName) {
                    return d1.getName().compareTo(d2.getName()) * multiplier;
                }
                return multiplier;
            }
        };
        Collections.sort(events, comparator);
        return events;
    }
}
