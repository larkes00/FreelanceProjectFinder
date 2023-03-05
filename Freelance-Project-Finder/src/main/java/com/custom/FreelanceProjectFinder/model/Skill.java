package com.custom.FreelanceProjectFinder.model;

import javax.persistence.*;

@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private long skillId;
    @Column
    private String type;
    @Column
    private String name;
}
