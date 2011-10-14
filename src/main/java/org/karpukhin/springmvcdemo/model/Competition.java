package org.karpukhin.springmvcdemo.model;

import java.util.Date;

/**
 * @author Pavel Karpukhin
 */
public class Competition extends Entity {

	private String name;
	private Date startDate;
	private Date endDate;
    private Integer classificationId;

	/**
	 * Default constructor
	 */
	public Competition() {
	}

	public Competition(int id, String name, Date startDate, Date endDate) {
		super(id, false);
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}

    public Competition(int id, String name, Date startDate, Date endDate, boolean active) {
        super(id, active);
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

    public Integer getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Integer classificationId) {
        this.classificationId = classificationId;
    }
}
