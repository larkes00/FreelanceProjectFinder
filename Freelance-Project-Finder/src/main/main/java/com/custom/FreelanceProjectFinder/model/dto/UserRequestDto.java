package com.custom.FreelanceProjectFinder.model.dto;

import lombok.Data;

@Data
public class UserRequestDto {
    private long userRequestId;
    private String status;
    private String description;
    private long userId;
    private long projectId;
}
