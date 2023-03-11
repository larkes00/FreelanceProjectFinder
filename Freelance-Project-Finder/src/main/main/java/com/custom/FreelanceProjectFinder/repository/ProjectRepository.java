package com.custom.FreelanceProjectFinder.repository;

import com.custom.FreelanceProjectFinder.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
