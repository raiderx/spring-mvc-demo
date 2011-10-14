package org.karpukhin.springmvcdemo.service;

import org.karpukhin.springmvcdemo.dto.CompetitionSearchCriteria;
import org.karpukhin.springmvcdemo.model.Competition;

import java.util.List;

/**
 * @author Pavel Karpukhin
 */
public interface CompetitionService {

	/**
	 * Creates new competition
	 * @param competition competition data
	 * @return
	 */
	Competition createCompetitionWithApplicants(Competition competition, String[] applicantNames);

    /**
     * Returns list of competitions found by given search criteria
     * @param criteria competition search criteria
     * @return list of competitions
     */
	List<Competition> getCompetitionsByCriteria(CompetitionSearchCriteria criteria);
}
