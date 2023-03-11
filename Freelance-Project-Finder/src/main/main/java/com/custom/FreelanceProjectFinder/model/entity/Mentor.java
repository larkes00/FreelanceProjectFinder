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
@Table(name = "mentors")
public class Mentor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentor_id")
    private long mentorId;
    @Column(columnDefinition = "text")
    private String description;
    @Column(name = "user_id")
    private long userId;
    @OneToOne(mappedBy = "mentor")
    private User user;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "mentor_skills",
            joinColumns = { @JoinColumn(name = "mentor_id") },
            inverseJoinColumns = { @JoinColumn(name = "skill_id") }
    )
    private Set<Skill> skills = new HashSet<>();
    @OneToMany(mappedBy = "mentor")
    private Set<MentorRequest> userRequests = new HashSet<>();
}
