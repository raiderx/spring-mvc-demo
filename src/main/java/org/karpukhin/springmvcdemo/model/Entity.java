package org.karpukhin.springmvcdemo.model;

/**
 * @author Pavel Karpukhin
 */
public class Entity {

	private Integer id;
    private Boolean active;

	/**
	 * Default constructor
	 */
	public Entity() {
	}

    /**
     * Constructs entity with given id and activity flag
     * @param id id
     * @param active activity flag
     */
    public Entity(int id, boolean active) {
        this.id = id;
        this.active = active;
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
