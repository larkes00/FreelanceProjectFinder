package com.custom.FreelanceProjectFinder.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @Column(name = "user_id",  insertable = false, updatable = false)
    private long userId;
    @Column(name = "project_id")
    private long projectId;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
