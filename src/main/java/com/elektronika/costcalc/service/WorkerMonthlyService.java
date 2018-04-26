package com.elektronika.costcalc.service;

import com.elektronika.costcalc.model.WorkerMonthly;
import com.elektronika.costcalc.repository.WorkerMonthlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerMonthlyService {

    @Autowired
    private WorkerMonthlyRepository workerMonthlyRepository;

    public void saveWorkerMonthly(WorkerMonthly entity){
        workerMonthlyRepository.save(entity);
    }
}
