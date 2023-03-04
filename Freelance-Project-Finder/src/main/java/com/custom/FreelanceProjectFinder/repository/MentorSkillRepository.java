package com.custom.FreelanceProjectFinder.repository;

import com.custom.FreelanceProjectFinder.model.MentorSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorSkillRepository extends JpaRepository<MentorSkill, Long> {
}
