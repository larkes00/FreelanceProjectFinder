package com.custom.FreelanceProjectFinder.model.dto;

import lombok.Data;

@Data
public class MentorRequestDto {
    private long mentorRequestId;
    private String status;
    private long mentorId;
    private long projectId;
}
