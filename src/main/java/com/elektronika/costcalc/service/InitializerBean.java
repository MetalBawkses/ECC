package com.elektronika.costcalc.service;

import com.elektronika.costcalc.model.*;
import com.elektronika.costcalc.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

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

    @Autowired
    LedgerNumberRepository ledgerNumberRepository;

    @Autowired
    WorkCostService workCostService;

    @PostConstruct
    public void init(){
        LedgerNumber ledgerNumber1 = new LedgerNumber(100000, 199999, 711);
        ledgerNumberRepository.save(ledgerNumber1);
        LedgerNumber ledgerNumber2 = new LedgerNumber(330000, 339999, 711);
        ledgerNumberRepository.save(ledgerNumber2);
        LedgerNumber ledgerNumber3 = new LedgerNumber(200000, 299999, 712);
        ledgerNumberRepository.save(ledgerNumber3);
        LedgerNumber ledgerNumber4 = new LedgerNumber(400000, 499999, 713);
        ledgerNumberRepository.save(ledgerNumber4);
        LedgerNumber ledgerNumber5 = new LedgerNumber(310000, 319999, 7612);
        ledgerNumberRepository.save(ledgerNumber5);
        LedgerNumber ledgerNumber6 = new LedgerNumber(683300, 683399, 65312);
        ledgerNumberRepository.save(ledgerNumber6);
        LedgerNumber ledgerNumber7 = new LedgerNumber(685000, 685099, 6533);
        ledgerNumberRepository.save(ledgerNumber7);

        Product product1 = new Product(123456, "prodName1", 200);
        productRepository.save(product1);
        Product product2 = new Product(333456, "prodName33", 200);
        productRepository.save(product2);
        Product product3 = new Product(223456, "prodName2", 200);
        productRepository.save(product3);
        Product product4 = new Product(403456, "prodName4", 200);
        productRepository.save(product4);
        Product product5 = new Product(313456, "prodName31", 200);
        productRepository.save(product5);
        Product product6 = new Product(683356, "prodName6833", 200);
        productRepository.save(product6);
        Product product7 = new Product(685000, "prodName6850", 200);
        productRepository.save(product7);

        Worker worker1 = new Worker("worker1", "div1");
        Worker worker2 = new Worker("worker2", "div1");
        Worker worker3 = new Worker("worker3", "div1");
        Worker worker4 = new Worker("worker4", "div1");

        workerRepository.save(worker1);
        workerRepository.save(worker2);
        workerRepository.save(worker3);
        workerRepository.save(worker4);

        WorkerMonthly wm1 = new WorkerMonthly(worker1, BigDecimal.valueOf(0.27), BigDecimal.valueOf(0.015), 201801, 1150, BigDecimal.valueOf(0.21));
        WorkerMonthly wm2 = new WorkerMonthly(worker2, BigDecimal.valueOf(0.27), BigDecimal.valueOf(0.015), 201801, 1250, BigDecimal.valueOf(0.21));
        WorkerMonthly wm3 = new WorkerMonthly(worker3, BigDecimal.valueOf(0.27), BigDecimal.valueOf(0.015), 201801, 1350, BigDecimal.valueOf(0.21));
        WorkerMonthly wm4 = new WorkerMonthly(worker4, BigDecimal.valueOf(0.27), BigDecimal.valueOf(0.015), 201801, 1450, BigDecimal.valueOf(0.21));

        workerMonthlyRepository.save(wm1);
        workerMonthlyRepository.save(wm2);
        workerMonthlyRepository.save(wm3);
        workerMonthlyRepository.save(wm4);

/*        WorkCost wc1 = new WorkCost(product1, BigDecimal.valueOf(1), 201801, BigDecimal.valueOf(77), worker1, true);
        WorkCost wc2 = new WorkCost(product2, BigDecimal.valueOf(1), 201801, BigDecimal.valueOf(77), worker1, true);
        WorkCost wc3 = new WorkCost(product3, BigDecimal.valueOf(1), 201801, BigDecimal.valueOf(77), worker2, true);
        WorkCost wc4 = new WorkCost(product4, BigDecimal.valueOf(1), 201801, BigDecimal.valueOf(77), worker2, true);
        WorkCost wc5 = new WorkCost(product5, BigDecimal.valueOf(1), 201801, BigDecimal.valueOf(77), worker3, true);
        WorkCost wc6 = new WorkCost(product6, BigDecimal.valueOf(1), 201801, BigDecimal.valueOf(77), worker3, true);
        WorkCost wc7 = new WorkCost(product7, BigDecimal.valueOf(1), 201801, BigDecimal.valueOf(77), worker4, true);
        WorkCost wc8 = new WorkCost(product1, BigDecimal.valueOf(1), 201801, BigDecimal.valueOf(77), worker4, true);*/

        workCostService.createWorkCostByWorkSheet(product1, 201801, BigDecimal.valueOf(10), worker1, true);
        workCostService.createWorkCostByWorkSheet(product2, 201801, BigDecimal.valueOf(20), worker1, true);
        workCostService.createWorkCostByWorkSheet(product3, 201801, BigDecimal.valueOf(20), worker2, true);
        workCostService.createWorkCostByWorkSheet(product4, 201801, BigDecimal.valueOf(30), worker2, true);
        workCostService.createWorkCostByWorkSheet(product5, 201801, BigDecimal.valueOf(30), worker3, true);
        workCostService.createWorkCostByWorkSheet(product6, 201801, BigDecimal.valueOf(40), worker3, true);
        workCostService.createWorkCostByWorkSheet(product7, 201801, BigDecimal.valueOf(50), worker4, true);
        workCostService.createWorkCostByWorkSheet(product4, 201801, BigDecimal.valueOf(40), worker4, true);
        workCostService.createWorkCostByWorkSheet(product1, 201801, BigDecimal.valueOf(40), worker1, true);


  /*      costRepository.save(wc1);
        costRepository.save(wc2);
        costRepository.save(wc3);
        costRepository.save(wc4);
        costRepository.save(wc5);
        costRepository.save(wc6);
        costRepository.save(wc7);
        costRepository.save(wc8);*/


        LeaseWorkCost l1 = new LeaseWorkCost(product1, BigDecimal.valueOf(1), 201801,"K1234", true);
        LeaseWorkCost l2 = new LeaseWorkCost(product2, BigDecimal.valueOf(1), 201801,"K1234", true);
        LeaseWorkCost l3 = new LeaseWorkCost(product3, BigDecimal.valueOf(1), 201801,"K1234", true);
        LeaseWorkCost l4 = new LeaseWorkCost(product4, BigDecimal.valueOf(1), 201801,"K1234", true);
        LeaseWorkCost l5 = new LeaseWorkCost(product1, BigDecimal.valueOf(1), 201801,"K1234", true);
        LeaseWorkCost l6 = new LeaseWorkCost(product5, BigDecimal.valueOf(1), 201801,"K1234", true);
        LeaseWorkCost l7 = new LeaseWorkCost(product6, BigDecimal.valueOf(1), 201801,"K1234", true);
        LeaseWorkCost l8 = new LeaseWorkCost(product7, BigDecimal.valueOf(1), 201801,"K1234", true);


        costRepository.save(l1);
        costRepository.save(l2);
        costRepository.save(l3);
        costRepository.save(l4);
        costRepository.save(l5);
        costRepository.save(l6);
        costRepository.save(l7);
        costRepository.save(l8);

        MaterialCost m1 = new MaterialCost(product2,BigDecimal.valueOf(1), 201801,BigDecimal.ZERO , true);
        MaterialCost m2 = new MaterialCost(product3,BigDecimal.valueOf(1), 201801,BigDecimal.ZERO , true);
        MaterialCost m3 = new MaterialCost(product4,BigDecimal.valueOf(1), 201801,BigDecimal.ZERO , true);
        MaterialCost m4 = new MaterialCost(product5,BigDecimal.valueOf(1), 201801,BigDecimal.ZERO , true);
        MaterialCost m5 = new MaterialCost(product6,BigDecimal.valueOf(1), 201801,BigDecimal.ZERO , true);
        MaterialCost m6 = new MaterialCost(product7,BigDecimal.valueOf(1), 201801,BigDecimal.ZERO , true);
        MaterialCost m7 = new MaterialCost(product1,BigDecimal.valueOf(1), 201801,BigDecimal.ZERO , true);
        MaterialCost m8 = new MaterialCost(product1,BigDecimal.valueOf(1), 201801,BigDecimal.ZERO , true);


        costRepository.save(m1);
        costRepository.save(m2);
        costRepository.save(m3);
        costRepository.save(m4);
        costRepository.save(m5);
        costRepository.save(m6);
        costRepository.save(m7);
        costRepository.save(m8);

    }
}

