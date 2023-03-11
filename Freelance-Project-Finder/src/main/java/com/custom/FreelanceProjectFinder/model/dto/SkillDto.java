package com.custom.FreelanceProjectFinder.model.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class SkillDto {
    private long skillId;
    private String type;
    private String name;
}
