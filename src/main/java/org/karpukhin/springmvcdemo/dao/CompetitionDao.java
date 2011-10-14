package org.karpukhin.springmvcdemo.dao;

import org.karpukhin.springmvcdemo.dto.CompetitionSearchCriteria;
import org.karpukhin.springmvcdemo.model.Competition;

import java.util.List;

/**
 * @author Pavel Karpukhin
 */
public interface CompetitionDao {

	/**
	 * Creates new competition
	 * @param competition competition
	 * @return created competition
	 */
	Competition createCompetition(Competition competition);

    /**
     * Returns list of competitions found by given search criteria
     * @param criteria competition search criteria
     * @return list of competitions
     */
    List<Competition> getCompetitionsByCriteria(CompetitionSearchCriteria criteria);
}
