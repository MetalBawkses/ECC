package com.elektronika.costcalc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    public void saveWorker (Worker entity){
        workerRepository.save(entity);
    }
}
