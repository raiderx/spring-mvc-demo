package org.karpukhin.springmvcdemo.service;

import org.karpukhin.springmvcdemo.dto.DisciplineSearchCriteria;
import org.karpukhin.springmvcdemo.model.Discipline;

import java.util.List;

/**
 * @author Pavel Karpukhin
 */
public interface DisciplineService {

    /**
     * Returns all disciplines
     * @return all disciplines
     */
	List<Discipline> getAllDisciplines();

    /**
     * Returns list of disciplines found by given search criteria
     * @param criteria discipline search criteria
     * @return list of disciplines
     */
    List<Discipline> getDisciplinesByCriteria(DisciplineSearchCriteria criteria);
}
