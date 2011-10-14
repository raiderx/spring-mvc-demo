package org.karpukhin.springmvcdemo.model;

/**
 * @author Pavel Karpukhin
 */
public class Discipline extends Entity {

	private String name;

    /**
     * Default constructor
     */
	public Discipline() {
	}

    /**
     * Constructs discipline with given id, name and activity flag
     * @param id     id
     * @param name   name
     * @param active activity flag
     */
	public Discipline(int id, String name, boolean active) {
        super(id, active);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
