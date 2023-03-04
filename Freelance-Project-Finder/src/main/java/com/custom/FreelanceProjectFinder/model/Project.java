package com.custom.FreelanceProjectFinder.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private long projectId;
    @Column
    private String title;
    @Column(name = "opened_description")
    private String openedDescription;
    @Column(name = "closed_description")
    private String closedDescription;
    @Column
    private String status;
    @Column
    private BigDecimal budget;
    @Column(name = "owner_id")
    private long ownerId;
}
