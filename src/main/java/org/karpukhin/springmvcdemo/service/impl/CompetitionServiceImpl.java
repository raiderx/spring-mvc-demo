package org.karpukhin.springmvcdemo.service.impl;

import org.karpukhin.springmvcdemo.dao.CompetitionDao;
import org.karpukhin.springmvcdemo.dto.CompetitionSearchCriteria;
import org.karpukhin.springmvcdemo.model.Competition;
import org.karpukhin.springmvcdemo.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Pavel Karpukhin
 */
@Service
public class CompetitionServiceImpl implements CompetitionService {

	@Autowired
	private CompetitionDao competitionDao;

	@Override
	public Competition createCompetitionWithApplicants(Competition competition, String[] applicantNames) {
		Competition created = competitionDao.createCompetition(competition);
		return created;
	}

	@Override
	public List<Competition> getCompetitionsByCriteria(CompetitionSearchCriteria criteria) {
        return competitionDao.getCompetitionsByCriteria(criteria);
	}
}
