package org.karpukhin.springmvcdemo.dto;

import org.karpukhin.springmvcdemo.model.Entity;

/**
 * @author Pavel Karpukhin
 */
public abstract class SearchCriteria<T extends Entity> {

    private T example;
	private String sortColumn;
	private String sortOrder;
    private int page = 0;

	public SearchCriteria(T example, String sortColumn, String sortOrder) {
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

    public String getSortColumn() {
		return sortColumn;
	}

	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}

	public String getSortOrder() {
		return sortOrder;
	}

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
