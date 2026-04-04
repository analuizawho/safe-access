package com.analuizawho.safe_access.user_service.repository;

import com.analuizawho.safe_access.user_service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByUserActivateTrue();
}
