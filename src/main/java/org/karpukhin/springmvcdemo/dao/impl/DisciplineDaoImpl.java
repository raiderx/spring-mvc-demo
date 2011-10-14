package org.karpukhin.springmvcdemo.dao.impl;

import org.karpukhin.springmvcdemo.dao.DisciplineDao;
import org.karpukhin.springmvcdemo.dto.DisciplineSearchCriteria;
import org.karpukhin.springmvcdemo.dto.SearchCriteria;
import org.karpukhin.springmvcdemo.model.Discipline;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @author Pavel Karpukhin
 */
@Repository
public class DisciplineDaoImpl extends AbstractEntityDaoImpl<Discipline> implements DisciplineDao {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Discipline> getDisciplinesByCriteria(DisciplineSearchCriteria criteria) {
        List<Discipline> disciplines = getAllDisciplines();
        List<Discipline> result = new ArrayList<Discipline>();
        for (Discipline discipline : disciplines) {
            if (doesDisciplineSatisfyCriteria(discipline, criteria)) {
                result.add(discipline);
            }
        }

        return sortEntities(result, criteria);
    }

    private static List<Discipline> getAllDisciplines() {
        List<Discipline> disciplines = new ArrayList<Discipline>();
        disciplines.add(new Discipline(1, "Rifle", true));
        disciplines.add(new Discipline(2, "Pistol", true));
        disciplines.add(new Discipline(3, "Shotgun", true));
        disciplines.add(new Discipline(4, "Deleted discipline", false));
        disciplines.add(new Discipline(5, "Practical", true));
        disciplines.add(new Discipline(6, "Silhouette", true));
        disciplines.add(new Discipline(7, "Benchrest Shooting", true));
        disciplines.add(new Discipline(8, "Black Powder", true));
        return disciplines;
    }

    private static boolean doesDisciplineSatisfyCriteria(Discipline discipline, DisciplineSearchCriteria criteria) {
        if (discipline != null && criteria != null) {
            if (criteria.getExample().getActive() != null && discipline.getActive() != criteria.getExample().getActive()) {
                return false;
            }
            if (criteria.getExample().getName() != null && !criteria.getExample().getName().isEmpty() && !discipline.getName().contains(criteria.getExample().getName())) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected Comparator<Discipline> createComparator(SearchCriteria criteria) {
        final boolean sortByName = "name".equals(criteria.getSortColumn().toLowerCase());
        final int multiplier = "asc".equals(criteria.getSortOrder().toLowerCase()) ? 1 : -1;
        Comparator<Discipline> comparator = new Comparator<Discipline>() {
            @Override
            public int compare(Discipline d1, Discipline d2) {
                if (sortByName) {
                    return d1.getName().compareTo(d2.getName()) * multiplier;
                }
                return 0;
            }
        };
        return comparator;
    }
}
