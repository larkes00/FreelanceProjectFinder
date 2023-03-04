package com.custom.FreelanceProjectFinder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project_skills")
public class ProjectSkill {
    @Id
    @Column(name = "skill_id")
    private long skillId;
    @Id
    @Column(name = "project_id")
    private long projectId;
}
