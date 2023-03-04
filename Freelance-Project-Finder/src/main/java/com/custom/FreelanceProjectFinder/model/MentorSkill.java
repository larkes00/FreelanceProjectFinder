package com.custom.FreelanceProjectFinder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mentor_skills")
public class MentorSkill {
    @Id
    @Column(name = "skill_id")
    private long skillId;
    @Id
    @Column(name = "mentor_id")
    private long mentorId;
}
