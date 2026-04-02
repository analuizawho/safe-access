package com.analuizawho.safe_access.user_service.repository;

import com.analuizawho.safe_access.user_service.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    List<Admin> findAllByUserActive();
}
