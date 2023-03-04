package com.custom.FreelanceProjectFinder.model;

import javax.persistence.*;

@Entity
@Table(name = "mentor_requests")
public class MentorRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentor_request_id")
    private long mentorRequestId;
    @Column
    private String status;
    @Column(name = "mentor_id")
    private long mentorId;
    @Column(name = "project_id")
    private long projectId;
}
