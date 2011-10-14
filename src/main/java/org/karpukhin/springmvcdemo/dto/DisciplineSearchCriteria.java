package org.karpukhin.springmvcdemo.dto;

import org.karpukhin.springmvcdemo.model.Discipline;

/**
 * @author Pavel Karpukhin
 */
public class DisciplineSearchCriteria  extends SearchCriteria<Discipline> {

    /**
     * Default constructor
     */
    public DisciplineSearchCriteria() {
        super(new Discipline(), "name", "asc");
    }
}
