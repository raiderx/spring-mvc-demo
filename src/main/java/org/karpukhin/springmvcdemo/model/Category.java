package org.karpukhin.springmvcdemo.model;

/**
 * @author Pavel Karpukhin
 */
public class Category extends Entity {

    private String name;
    private String description;

    /**
     * Default constructor
     */
    public Category() {
    }

    /**
     * Constructs Category with given id, name, description and activity flag
     * @param id
     * @param name
     * @param description
     * @param active
     */
    public Category(int id, String name, String description, boolean active) {
        super(id, active);
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
