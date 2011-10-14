package org.karpukhin.springmvcdemo.dto;

import java.security.KeyStore;
import java.util.List;
import java.util.Map;

/**
 * @author Pavel Karpukhin
 */
public class EditDisciplineDto {

    private Integer id;
    private String name;
    private Map<Integer, List<Integer>> eventCategories;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, List<Integer>> getEventCategories() {
        return eventCategories;
    }

    public void setEventCategories(Map<Integer, List<Integer>> eventCategories) {
        this.eventCategories = eventCategories;
    }
}
