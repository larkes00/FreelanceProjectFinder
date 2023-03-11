package com.custom.FreelanceProjectFinder.repository;

import com.custom.FreelanceProjectFinder.model.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
}
