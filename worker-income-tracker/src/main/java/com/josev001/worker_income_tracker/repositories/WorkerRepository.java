package com.josev001.worker_income_tracker.repositories;

import com.josev001.worker_income_tracker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
