package com.custom.FreelanceProjectFinder.repository;

import com.custom.FreelanceProjectFinder.model.entity.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
}
