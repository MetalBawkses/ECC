package com.elektronika.costcalc.repository;

import com.elektronika.costcalc.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository  extends JpaRepository<Worker, Long> {
}
