package com.custom.FreelanceProjectFinder.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mentor_requests")
public class MentorRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mentor_request_id")
    private long mentorRequestId;
    @Column
    private String status;
    @Column(name = "mentor_id", insertable = false, updatable = false)
    private long mentorId;
    @Column(name = "project_id")
    private long projectId;
    @ManyToOne
    @JoinColumn(name = "mentor_id", nullable = false)
    private Mentor mentor;
}
