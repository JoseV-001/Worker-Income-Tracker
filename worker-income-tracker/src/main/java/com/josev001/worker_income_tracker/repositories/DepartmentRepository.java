package com.josev001.worker_income_tracker.repositories;

import com.josev001.worker_income_tracker.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
