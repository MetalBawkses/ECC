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
    CostRepository costRepository;

    @Autowired
    WorkerRepository workerRepository;

    @Autowired
    WorkerMonthlyRepository workerMonthlyRepository;

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

        WorkCost wc1 = new WorkCost(product1, 123f, 201801, 77f, worker1, true);
        WorkCost wc2 = new WorkCost(product1, 123f, 201801, 77f, worker1, true);
        WorkCost wc3 = new WorkCost(product1, 123f, 201801, 77f, worker2, true);
        WorkCost wc4 = new WorkCost(product1, 123f, 201801, 77f, worker2, true);
        WorkCost wc5 = new WorkCost(product1, 123f, 201801, 77f, worker3, true);
        WorkCost wc6 = new WorkCost(product1, 123f, 201801, 77f, worker3, true);
        WorkCost wc7 = new WorkCost(product1, 123f, 201801, 77f, worker4, true);
        WorkCost wc8 = new WorkCost(product1, 123f, 201801, 77f, worker4, true);


        costRepository.save(wc1);
        costRepository.save(wc2);
        costRepository.save(wc3);
        costRepository.save(wc4);
        costRepository.save(wc5);
        costRepository.save(wc6);
        costRepository.save(wc7);
        costRepository.save(wc8);


        LeaseWorkCost l1 = new LeaseWorkCost(product1, 31f, 201801,"K1234", true);
        LeaseWorkCost l2 = new LeaseWorkCost(product1, 31f, 201801,"K1234", true);
        LeaseWorkCost l3 = new LeaseWorkCost(product1, 31f, 201801,"K1234", true);
        LeaseWorkCost l4 = new LeaseWorkCost(product1, 31f, 201801,"K1234", true);
        LeaseWorkCost l5 = new LeaseWorkCost(product1, 31f, 201801,"K1234", true);
        LeaseWorkCost l6 = new LeaseWorkCost(product1, 31f, 201801,"K1234", true);
        LeaseWorkCost l7 = new LeaseWorkCost(product1, 31f, 201801,"K1234", true);
        LeaseWorkCost l8 = new LeaseWorkCost(product1, 31f, 201801,"K1234", true);


        costRepository.save(l1);
        costRepository.save(l2);
        costRepository.save(l3);
        costRepository.save(l4);
        costRepository.save(l5);
        costRepository.save(l6);
        costRepository.save(l7);
        costRepository.save(l8);

        MaterialCost m1 = new MaterialCost(product1,21f, 201801,0f , true);
        MaterialCost m2 = new MaterialCost(product1,22f, 201801,0f , true);
        MaterialCost m3 = new MaterialCost(product1,23f, 201803,0f , true);
        MaterialCost m4 = new MaterialCost(product1,24f, 201801,0f , true);
        MaterialCost m5 = new MaterialCost(product1,25f, 201804,0f , true);
        MaterialCost m6 = new MaterialCost(product1,26f, 201807,0f , true);
        MaterialCost m7 = new MaterialCost(product1,28f, 201801,0f , true);
        MaterialCost m8 = new MaterialCost(product1,29f, 201803,0f , true);


        costRepository.save(m1);
        costRepository.save(m2);
        costRepository.save(m3);
        costRepository.save(m4);
        costRepository.save(m5);
        costRepository.save(m6);
        costRepository.save(m7);
        costRepository.save(m8);

        List<Cost> lista = costRepository.findAllCost(201801);
        System.out.println(lista.toString());

    }
}

