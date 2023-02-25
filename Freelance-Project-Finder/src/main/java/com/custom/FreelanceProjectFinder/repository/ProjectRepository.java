package com.custom.FreelanceProjectFinder.repository;

import com.custom.FreelanceProjectFinder.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
