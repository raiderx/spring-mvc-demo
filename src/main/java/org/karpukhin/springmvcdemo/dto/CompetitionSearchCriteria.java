package org.karpukhin.springmvcdemo.dto;

import org.karpukhin.springmvcdemo.model.Competition;

import java.util.Date;
import java.util.List;

/**
 * @author Pavel Karpukhin
 */
public class CompetitionSearchCriteria extends SearchCriteria<Competition> {

	private Date fromStartDate;
	private Date toStartDate;
	private Date fromEndDate;
	private Date toEndDate;
	private List<Integer> disciplineIds;
	private List<String> statuses;

	public CompetitionSearchCriteria() {
		super(new Competition(), "name", "asc");
	}

	public Date getFromStartDate() {
		return fromStartDate;
	}

	public void setFromStartDate(Date fromStartDate) {
		this.fromStartDate = fromStartDate;
	}

	public Date getToStartDate() {
		return toStartDate;
	}

	public void setToStartDate(Date toStartDate) {
		this.toStartDate = toStartDate;
	}

	public Date getFromEndDate() {
		return fromEndDate;
	}

	public void setFromEndDate(Date fromEndDate) {
		this.fromEndDate = fromEndDate;
	}

	public Date getToEndDate() {
		return toEndDate;
	}

	public void setToEndDate(Date toEndDate) {
		this.toEndDate = toEndDate;
	}

	public List<Integer> getDisciplineIds() {
		return disciplineIds;
	}

	public void setDisciplineIds(List<Integer> disciplineIds) {
		this.disciplineIds = disciplineIds;
	}

	public List<String> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<String> statuses) {
		this.statuses = statuses;
	}
}
