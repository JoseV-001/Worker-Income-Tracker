package com.josev001.worker_income_tracker.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josev001.worker_income_tracker.dto.WorkerIncomeDTO;
import com.josev001.worker_income_tracker.entities.Worker;
import com.josev001.worker_income_tracker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping(value = "/{id}/income/{year}/{month}")
    public WorkerIncomeDTO getIncome(@PathVariable Long id, @PathVariable Integer year, @PathVariable Integer month) {

        Worker worker = workerRepository.findById(id).get();

        return new WorkerIncomeDTO(worker.getName(), worker.getDepartment().getName(), worker.income(year, month));
    }
}
