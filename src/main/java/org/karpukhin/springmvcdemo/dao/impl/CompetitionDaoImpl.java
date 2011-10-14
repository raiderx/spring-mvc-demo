package org.karpukhin.springmvcdemo.dao.impl;

import org.karpukhin.springmvcdemo.dao.CompetitionDao;
import org.karpukhin.springmvcdemo.dto.CompetitionSearchCriteria;
import org.karpukhin.springmvcdemo.dto.SearchCriteria;
import org.karpukhin.springmvcdemo.model.Competition;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @author Pavel Karpukhin
 */
@Repository
public class CompetitionDaoImpl extends AbstractEntityDaoImpl<Competition> implements CompetitionDao {

    /**
     * {@inheritDoc}
     */
	@Override
	public Competition createCompetition(Competition competition) {
		return null;
	}

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Competition> getCompetitionsByCriteria(CompetitionSearchCriteria criteria) {
        List<Competition> competitions = getAllEntities();
        List<Competition> result = new ArrayList<Competition>();
        for (Competition competition : competitions) {
            if (doesCompetitionSatisfyCriteria(competition, criteria)) {
                result.add(competition);
            }

        }

        return sortEntities(result, criteria);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected List<Competition> getAllEntities() {
        Calendar calendar = Calendar.getInstance();
        List<Competition> result = new ArrayList<Competition>();
        result.add(new Competition(1, "Some competition", getDate(calendar, 2011, 9, 19), getDate(calendar, 2011, 9, 23), true));
        result.add(new Competition(2, "Some other competition", getDate(calendar, 2011, 9, 26), getDate(calendar, 2011, 9, 30), true));
        result.add(new Competition(3, "Deleted competition", getDate(calendar, 2011, 9, 26), getDate(calendar, 2011, 9, 30), false));
        result.add(new Competition(4, "January competition", getDate(calendar, 2011, 1, 10), getDate(calendar, 2011, 1, 17), true));
        result.add(new Competition(5, "February competition", getDate(calendar, 2011, 2, 1), getDate(calendar, 2011, 2, 8), true));
        result.add(new Competition(6, "March competition", getDate(calendar, 2011, 3, 1), getDate(calendar, 2011, 3, 8), true));
        result.add(new Competition(7, "April competition", getDate(calendar, 2011, 4, 1), getDate(calendar, 2011, 4, 8), true));
        result.add(new Competition(8, "May competition", getDate(calendar, 2011, 5, 1), getDate(calendar, 2011, 5, 8), true));
        result.add(new Competition(9, "June competition", getDate(calendar, 2011, 6, 1), getDate(calendar, 2011, 6, 8), true));
        result.add(new Competition(10, "July competition", getDate(calendar, 2011, 7, 1), getDate(calendar, 2011, 7, 8), true));
        result.add(new Competition(11, "August competition", getDate(calendar, 2011, 8, 1), getDate(calendar, 2011, 8, 8), true));
        result.add(new Competition(12, "September competition", getDate(calendar, 2011, 9, 1), getDate(calendar, 2011, 9, 8), true));
        result.add(new Competition(13, "October competition", getDate(calendar, 2011, 10, 1), getDate(calendar, 2011, 10, 8), true));
        result.add(new Competition(13, "November competition", getDate(calendar, 2011, 11, 1), getDate(calendar, 2011, 11, 8), true));
        result.add(new Competition(15, "December competition", getDate(calendar, 2011, 12, 1), getDate(calendar, 2011, 12, 8), true));
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Comparator<Competition> createComparator(SearchCriteria<Competition> criteria) {
        final boolean sortById = "id".equals(criteria.getSortColumn().toLowerCase());
        final boolean sortByName = "name".equals(criteria.getSortColumn().toLowerCase());
        final int multiplier = "asc".equals(criteria.getSortOrder().toLowerCase()) ? 1 : -1;
        Comparator<Competition> comparator = new Comparator<Competition>() {
            @Override
            public int compare(Competition c1, Competition c2) {
                if (sortById) {
                    return c1.getId().compareTo(c2.getId()) * multiplier;
                }
                if (sortByName) {
                    return c1.getName().compareTo(c2.getName()) * multiplier;
                }
                return 0;
            }
        };
        return comparator;
    }

    private static boolean doesCompetitionSatisfyCriteria(Competition competition, CompetitionSearchCriteria criteria) {
        if (competition != null && criteria != null) {
            if (criteria.getExample().getActive() != null && competition.getActive() != criteria.getExample().getActive()) {
                return false;
            }
            if (criteria.getExample().getName() != null && !criteria.getExample().getName().isEmpty() && !competition.getName().contains(criteria.getExample().getName())) {
                return false;
            }
        }
        return true;
    }

    private static Date getDate(Calendar calendar, int year, int month, int day) {
        calendar.set(year, month, day);
        return calendar.getTime();
    }
}
