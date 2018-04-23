package com.elektronika.costcalc.corecomponents;

import com.elektronika.costcalc.feature1.*;
import com.elektronika.costcalc.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class InitializerBean {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    WorkCostRepository workCostRepository;

    @Autowired
    WorkerRepository workerRepository;

    @Autowired
    WorkerMonthlyRepository workerMonthlyRepository;

    @Autowired
    MaterialCostRepository materialCostRepository;

    @Autowired
    LeaseWorkCostRepository leaseWorkCostRepository;

    @PostConstruct
    public void init(){
        Product product1 = new Product(123456, "prodName", 200);
        productRepository.save(product1);

        Worker worker1 = new Worker("worker1", "div1");
        Worker worker2 = new Worker("worker2", "div1");
        Worker worker3 = new Worker("worker3", "div1");
        Worker worker4 = new Worker("worker4", "div1");

        workerRepository.save(worker1);
        workerRepository.save(worker2);
        workerRepository.save(worker3);
        workerRepository.save(worker4);

        WorkerMonthly wm1 = new WorkerMonthly(worker1, 0.27f, 0.015f, 201801, 1150);
        WorkerMonthly wm2 = new WorkerMonthly(worker2, 0.27f, 0.015f, 201801, 1250);
        WorkerMonthly wm3 = new WorkerMonthly(worker3, 0.27f, 0.015f, 201801, 1350);
        WorkerMonthly wm4 = new WorkerMonthly(worker4, 0.27f, 0.015f, 201801, 1450);

        workerMonthlyRepository.save(wm1);
        workerMonthlyRepository.save(wm2);
        workerMonthlyRepository.save(wm3);
        workerMonthlyRepository.save(wm4);

        WorkCost wc1 = new WorkCost(product1, 110, worker1, 201801);
        WorkCost wc2 = new WorkCost(product1, 120, worker1, 201801);
        WorkCost wc3 = new WorkCost(product1, 130, worker2, 201801);
        WorkCost wc4 = new WorkCost(product1, 140, worker2, 201801);
        WorkCost wc5 = new WorkCost(product1, 150, worker3, 201801);
        WorkCost wc6 = new WorkCost(product1, 160, worker3, 201801);
        WorkCost wc7 = new WorkCost(product1, 170, worker4, 201801);
        WorkCost wc8 = new WorkCost(product1, 180, worker4, 201801);

        workCostRepository.save(wc1);
        workCostRepository.save(wc2);
        workCostRepository.save(wc3);
        workCostRepository.save(wc4);
        workCostRepository.save(wc5);
        workCostRepository.save(wc6);
        workCostRepository.save(wc7);
        workCostRepository.save(wc8);


        LeaseWorkCost l1 = new LeaseWorkCost(product1, 31f, "K1234", 201801);
        LeaseWorkCost l2 = new LeaseWorkCost(product1, 31f, "K1234", 201802);
        LeaseWorkCost l3 = new LeaseWorkCost(product1, 31f, "K1234", 201803);
        LeaseWorkCost l4 = new LeaseWorkCost(product1, 31f, "K1234", 201804);
        LeaseWorkCost l5 = new LeaseWorkCost(product1, 31f, "K1234", 201805);
        LeaseWorkCost l6 = new LeaseWorkCost(product1, 31f, "K1234", 201801);
        LeaseWorkCost l7 = new LeaseWorkCost(product1, 31f, "K1234", 201801);
        LeaseWorkCost l8 = new LeaseWorkCost(product1, 31f, "K1234", 201801);

        leaseWorkCostRepository.save(l1);
        leaseWorkCostRepository.save(l2);
        leaseWorkCostRepository.save(l3);
        leaseWorkCostRepository.save(l4);
        leaseWorkCostRepository.save(l5);
        leaseWorkCostRepository.save(l6);
        leaseWorkCostRepository.save(l7);
        leaseWorkCostRepository.save(l8);

        MaterialCost m1 = new MaterialCost(product1,21f, 0, 201801);
        MaterialCost m2 = new MaterialCost(product1,22f, 0, 201802);
        MaterialCost m3 = new MaterialCost(product1,23f, 0, 201803);
        MaterialCost m4 = new MaterialCost(product1,24f, 0, 201804);
        MaterialCost m5 = new MaterialCost(product1,25f, 0, 201805);
        MaterialCost m6 = new MaterialCost(product1,26f, 0, 201801);
        MaterialCost m7 = new MaterialCost(product1,27f, 0, 201801);
        MaterialCost m8 = new MaterialCost(product1,28f, 0, 201801);

        materialCostRepository.save(m1);
        materialCostRepository.save(m2);
        materialCostRepository.save(m3);
        materialCostRepository.save(m4);
        materialCostRepository.save(m5);
        materialCostRepository.save(m6);
        materialCostRepository.save(m7);
        materialCostRepository.save(m8);
        Float lista = materialCostRepository.findAllCost2(201801);
        System.out.println("Lista: " + lista);
    }
}

