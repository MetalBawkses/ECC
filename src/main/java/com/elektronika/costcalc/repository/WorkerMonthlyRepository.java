package com.elektronika.costcalc.repository;

import com.elektronika.costcalc.model.Worker;
import com.elektronika.costcalc.model.WorkerMonthly;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerMonthlyRepository extends JpaRepository<WorkerMonthly, Long> {
    WorkerMonthly getAllByWorkerAndYearMonth(Worker worker, Integer yearMonth);

}
