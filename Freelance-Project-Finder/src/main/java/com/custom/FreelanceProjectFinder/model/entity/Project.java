package com.custom.FreelanceProjectFinder.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "projects")
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private long projectId;
    @Column
    private String title;
    @Column(name = "opened_description", columnDefinition = "text")
    private String openedDescription;
    @Column(name = "closed_description", columnDefinition = "text")
    private String closedDescription;
    @Column
    private String status;
    @Column
    private BigDecimal budget;
    @Column(name = "owner_id", insertable = false, updatable = false)
    private long ownerId;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "project_skills",
            joinColumns = { @JoinColumn(name = "project_id") },
            inverseJoinColumns = { @JoinColumn(name = "skill_id") }
    )
    private Set<Skill> skills = new HashSet<>();
    @OneToMany(mappedBy = "user")
    private Set<UserRequest> userRequests = new HashSet<>();
    @OneToMany(mappedBy = "mentor")
    private Set<MentorRequest> mentorRequests = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;
}
