package com.elektronika.costcalc.service;

import com.elektronika.costcalc.model.Worker;
import com.elektronika.costcalc.repository.WorkerRepository;
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
