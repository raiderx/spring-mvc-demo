package org.karpukhin.springmvcdemo.dto;

import org.karpukhin.springmvcdemo.model.Entity;

/**
 * Base class for search criteria
 * @author Pavel Karpukhin
 */
public abstract class SearchCriteria<T extends Entity> {

    private T example;
	private String sortColumn;
	private String sortOrder;
    private int page = 0;

	protected SearchCriteria(T example, String sortColumn, String sortOrder) {
        this.example = example;
		this.sortColumn = sortColumn;
		this.sortOrder = sortOrder;
        example.setActive(true);
	}

    public T getExample() {
        return example;
    }

    public void setExample(T example) {
        this.example = example;
    }

    /**
	 * Returns name of sort column
	 * It's equals to SQL table column in database
	 * @return name of sort column
	 */
    public String getSortColumn() {
		return sortColumn;
	}

    /**
     * Sets name of sort column
     * It's equals to SQL table column in database
     * @param sortColumn sort column
     */
	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}

    /**
     * Returns sort order
     * @return sort order
     */
	public String getSortOrder() {
		return sortOrder;
	}

    /**
     * Sets sort order
     * @param sortOrder sort order
     */
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
