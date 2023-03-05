package com.custom.FreelanceProjectFinder.model;

import javax.persistence.*;

@Entity
@Table(name = "user_requests")
public class UserRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long userRequestId;
    @Column
    private String status;
    @Column
    private String description;
    @Column(name = "user_id")
    private long userId;
    @Column(name = "project_id")
    private long projectId;
}
