package com.custom.FreelanceProjectFinder.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "skills")
@Embeddable
public class Skill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private long skillId;
    @Column
    private String type;
    @Column
    private String name;
    @ManyToMany(mappedBy = "skills")
    private Set<Mentor> mentors = new HashSet<>();
    @ManyToMany(mappedBy = "skills")
    private Set<Project> projects = new HashSet<>();
}
