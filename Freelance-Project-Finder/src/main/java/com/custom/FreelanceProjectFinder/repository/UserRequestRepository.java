package com.custom.FreelanceProjectFinder.repository;

import com.custom.FreelanceProjectFinder.model.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRequestRepository extends JpaRepository<UserRequest, Long> {
}
