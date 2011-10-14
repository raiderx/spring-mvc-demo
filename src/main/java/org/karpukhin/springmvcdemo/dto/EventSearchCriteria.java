package org.karpukhin.springmvcdemo.dto;

import org.karpukhin.springmvcdemo.model.Event;

/**
 * @author Pavel Karpukhin
 */
public class EventSearchCriteria extends SearchCriteria<Event> {

    /**
     * Default constructor
     */
    public EventSearchCriteria() {
        super(new Event(), "name", "asc");
    }
}
