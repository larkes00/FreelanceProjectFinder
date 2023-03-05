package com.custom.FreelanceProjectFinder.repository;

import com.custom.FreelanceProjectFinder.model.MentorRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRequestRepository extends JpaRepository<MentorRequest, Long> {
}
