package org.karpukhin.springmvcdemo.dao;

import org.karpukhin.springmvcdemo.dto.DisciplineSearchCriteria;
import org.karpukhin.springmvcdemo.model.Discipline;

import java.util.List;

/**
 * @author Pavel Karpukhin
 */
public interface DisciplineDao {

    /**
     * Returns list of disciplines found by given search criteria
     * @param criteria discipline search criteria
     * @return list of disciplines
     */
    List<Discipline> getDisciplinesByCriteria(DisciplineSearchCriteria criteria);
}
