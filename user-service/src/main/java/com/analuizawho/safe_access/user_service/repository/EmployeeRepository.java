package com.analuizawho.safe_access.user_service.repository;

import com.analuizawho.safe_access.user_service.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
