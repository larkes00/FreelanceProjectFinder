package com.custom.FreelanceProjectFinder.repository;

import com.custom.FreelanceProjectFinder.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
