package com.custom.FreelanceProjectFinder.model.dto;

import com.custom.FreelanceProjectFinder.model.entity.Project;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProjectDto {
    private long projectId;
    private String title;
    private String openedDescription;
    private String closedDescription;
    private String status;
    private BigDecimal budget;
    private long ownerId;

    public Project convertDtoToEntity() {
        return new Project(getProjectId(), getTitle(), getOpenedDescription(), getClosedDescription(), getStatus(), getBudget(), getOwnerId(), null, null, null, null);
    }
}
