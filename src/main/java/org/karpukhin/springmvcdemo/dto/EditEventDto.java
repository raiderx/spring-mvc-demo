package org.karpukhin.springmvcdemo.dto;

import java.util.List;

/**
 * @author Pavel Karpukhin
 */
public class EditEventDto {

    private String name;
    private Integer disciplineId;
    private List<Integer> categoryIds;

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

    public List<Integer> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Integer> categoryIds) {
        this.categoryIds = categoryIds;
    }
}
