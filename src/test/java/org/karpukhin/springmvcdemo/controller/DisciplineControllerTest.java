package org.karpukhin.springmvcdemo.controller;

import org.junit.Before;
import org.junit.Test;
import org.karpukhin.springmvcdemo.dto.DisciplineSearchCriteria;
import org.karpukhin.springmvcdemo.model.Discipline;
import org.karpukhin.springmvcdemo.service.DisciplineService;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.ModelAndViewAssert.assertViewName;

/**
 * @author Pavel Karpukhin
 */
public class DisciplineControllerTest {

    private DisciplineService disciplineService;
    private DisciplineController disciplineController;

    @Before
    public void setUp() {
        disciplineService = mock(DisciplineService.class);
        disciplineController = new DisciplineController(disciplineService);
    }

    @Test
    public void testGetDisciplineList() {
        DisciplineSearchCriteria criteria = mock(DisciplineSearchCriteria.class);
        List<Discipline> disciplines = mock(List.class);
        when(disciplineService.getDisciplinesByCriteria(criteria)).thenReturn(disciplines);
        ModelAndView mav = disciplineController.getDisciplineList(criteria);
        assertViewName(mav, "disciplines/list");
        verify(disciplineService).getDisciplinesByCriteria(criteria);
    }
}
