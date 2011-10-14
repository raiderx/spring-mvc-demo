package org.karpukhin.springmvcdemo.service.impl;

import org.karpukhin.springmvcdemo.dao.DisciplineDao;
import org.karpukhin.springmvcdemo.dto.DisciplineSearchCriteria;
import org.karpukhin.springmvcdemo.model.Discipline;
import org.karpukhin.springmvcdemo.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Pavel Karpukhin
 */
@Service
public class DisciplineServiceImpl implements DisciplineService {

    @Autowired
    private DisciplineDao disciplineDao;

    /**
     * {@inheritDoc}
     */
	@Override
	public List<Discipline> getAllDisciplines() {
        DisciplineSearchCriteria criteria = new DisciplineSearchCriteria();
		return disciplineDao.getDisciplinesByCriteria(criteria);
	}

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Discipline> getDisciplinesByCriteria(DisciplineSearchCriteria criteria) {
        return disciplineDao.getDisciplinesByCriteria(criteria);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Discipline getDisciplineById(int disciplineId) {
        return disciplineDao.getById(disciplineId);
    }
}
