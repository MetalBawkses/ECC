package com.elektronika.costcalc.model;

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
