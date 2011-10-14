package org.karpukhin.springmvcdemo.model;

/**
 * @author Pavel Karpukhin
 */
public class Event extends Entity {

    private String name;
    private Integer disciplineId;

    public Event() {
    }

    public Event(int id, String name, int disciplineId, boolean active) {
        super(id, active);
        this.name = name;
        this.disciplineId = disciplineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(Integer disciplineId) {
        this.disciplineId = disciplineId;
    }
}
