package com.josev001.worker_income_tracker.config;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import com.josev001.worker_income_tracker.entities.Department;
import com.josev001.worker_income_tracker.entities.HourContract;
import com.josev001.worker_income_tracker.entities.Worker;
import com.josev001.worker_income_tracker.entities.WorkerLevel;
import com.josev001.worker_income_tracker.repositories.DepartmentRepository;
import com.josev001.worker_income_tracker.repositories.WorkerRepository;

@Configuration
public class SeedingConfig implements CommandLineRunner {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private WorkerRepository workerRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        Department dept = new Department("Design");

        dept = departmentRepository.save(dept);

        Worker worker = new Worker("Alex", WorkerLevel.MID_LEVEL, 1200.0, dept);

        worker = workerRepository.save(worker);

        HourContract contract1 = new HourContract(LocalDate.of(2018, 8, 20), 50.0, 20);
        HourContract contract2 = new HourContract(LocalDate.of(2018, 6, 13), 30.0, 18);
        HourContract contract3 = new HourContract(LocalDate.of(2018, 8, 25), 80.0, 10);

        worker.addContract(contract1);
        worker.addContract(contract2);
        worker.addContract(contract3);

        // nao precisa chamar save para contratos por causa do CascadeType.ALL e @Transactional
    }
}
