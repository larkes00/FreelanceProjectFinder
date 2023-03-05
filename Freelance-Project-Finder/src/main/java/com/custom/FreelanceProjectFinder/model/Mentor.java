package com.custom.FreelanceProjectFinder.model;

import javax.persistence.*;

@Entity
@Table(name = "mentors")
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentor_id")
    private long mentorId;
    @Column
    private String description;
    @Column(name = "user_id")
    private long userId;
}
