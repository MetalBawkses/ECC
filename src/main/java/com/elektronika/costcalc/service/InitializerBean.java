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
        ledgerNumber1.setDirectCost(true);
        ledgerNumberRepository.save(ledgerNumber1);

        LedgerNumber ledgerNumber2 = new LedgerNumber(330000, 339999, 711);
        ledgerNumber2.setDirectCost(true);
        ledgerNumberRepository.save(ledgerNumber2);

        LedgerNumber ledgerNumber3 = new LedgerNumber(200000, 299999, 712);
        ledgerNumber3.setDirectCost(true);
        ledgerNumberRepository.save(ledgerNumber3);

        LedgerNumber ledgerNumber4 = new LedgerNumber(400000, 499999, 713);
        ledgerNumber4.setDirectCost(true);
        ledgerNumberRepository.save(ledgerNumber4);

        LedgerNumber ledgerNumber5 = new LedgerNumber(310000, 319999, 7612);
        ledgerNumber5.setDirectCost(true);
        ledgerNumberRepository.save(ledgerNumber5);

        LedgerNumber ledgerNumber6 = new LedgerNumber(683300, 683399, 65312);
        ledgerNumber6.setDirectCost(true);
        ledgerNumberRepository.save(ledgerNumber6);

        LedgerNumber ledgerNumber7 = new LedgerNumber(685000, 685099, 6533);
        ledgerNumber7.setDirectCost(true);
        ledgerNumberRepository.save(ledgerNumber7);


        LedgerNumber ledgerNumber8 = new LedgerNumber(660000, 660000, 6521);
        ledgerNumber8.setDirectCost(false);
        ledgerNumberRepository.save(ledgerNumber8);

        LedgerNumber ledgerNumber9 = new LedgerNumber(683000, 683099, 6521);
        ledgerNumber9.setDirectCost(false);
        ledgerNumberRepository.save(ledgerNumber9);

        LedgerNumber ledgerNumber10 = new LedgerNumber(631000, 631099, 6521);
        ledgerNumber10.setDirectCost(false);
        ledgerNumberRepository.save(ledgerNumber10);

        LedgerNumber ledgerNumber11 = new LedgerNumber(610000, 610099, 6531);
        ledgerNumber11.setDirectCost(false);
        ledgerNumberRepository.save(ledgerNumber11);

        LedgerNumber ledgerNumber12 = new LedgerNumber(653200, 653299, 6532);
        ledgerNumber12.setDirectCost(false);
        ledgerNumberRepository.save(ledgerNumber12);

        LedgerNumber ledgerNumber13 = new LedgerNumber(683300, 683399, 6532);
        ledgerNumber13.setDirectCost(false);
        ledgerNumberRepository.save(ledgerNumber13);

        LedgerNumber ledgerNumber14 = new LedgerNumber(999999, 999999, 6532);
        ledgerNumber14.setDirectCost(false);
        ledgerNumberRepository.save(ledgerNumber14);




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
        Product product8 = new Product(660000, "prodName6600", -1);
        productRepository.save(product8);

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


        workCostService.createWorkCostByWorkSheet(product1, 201801, BigDecimal.valueOf(10), worker1, true);
        workCostService.createWorkCostByWorkSheet(product2, 201801, BigDecimal.valueOf(20), worker1, true);
        workCostService.createWorkCostByWorkSheet(product3, 201801, BigDecimal.valueOf(20), worker2, true);
        workCostService.createWorkCostByWorkSheet(product4, 201801, BigDecimal.valueOf(30), worker2, true);
        workCostService.createWorkCostByWorkSheet(product5, 201801, BigDecimal.valueOf(30), worker3, true);
        workCostService.createWorkCostByWorkSheet(product6, 201801, BigDecimal.valueOf(40), worker3, true);
        workCostService.createWorkCostByWorkSheet(product6, 201801, BigDecimal.valueOf(40), worker1, false);
        workCostService.createWorkCostByWorkSheet(product7, 201801, BigDecimal.valueOf(50), worker4, true);
        workCostService.createWorkCostByWorkSheet(product4, 201801, BigDecimal.valueOf(40), worker4, true);
        workCostService.createWorkCostByWorkSheet(product1, 201801, BigDecimal.valueOf(40), worker1, true);
        workCostService.createWorkCostByWorkSheet(product8, 201801, BigDecimal.valueOf(100), worker1, false);


        LeaseWorkCost l1 = new LeaseWorkCost(product1, BigDecimal.valueOf(1), 201801,"K1234", true);
        LeaseWorkCost l2 = new LeaseWorkCost(product2, BigDecimal.valueOf(1), 201801,"K1234", true);
        LeaseWorkCost l3 = new LeaseWorkCost(product3, BigDecimal.valueOf(1), 201801,"K1234", true);
        LeaseWorkCost l4 = new LeaseWorkCost(product4, BigDecimal.valueOf(1), 201801,"K1234", true);
        LeaseWorkCost l5 = new LeaseWorkCost(product1, BigDecimal.valueOf(1), 201801,"K1234", true);
        LeaseWorkCost l6 = new LeaseWorkCost(product5, BigDecimal.valueOf(1), 201801,"K1234", true);
        LeaseWorkCost l7 = new LeaseWorkCost(product6, BigDecimal.valueOf(1), 201801,"K1234", true);
        LeaseWorkCost l8 = new LeaseWorkCost(product7, BigDecimal.valueOf(1), 201801,"K1234", true);
        LeaseWorkCost l9 = new LeaseWorkCost(product8, BigDecimal.valueOf(1), 201801,"K1234", false);


        costRepository.save(l1);
        costRepository.save(l2);
        costRepository.save(l3);
        costRepository.save(l4);
        costRepository.save(l5);
        costRepository.save(l6);
        costRepository.save(l7);
        costRepository.save(l8);
        costRepository.save(l9);

        MaterialCost m1 = new MaterialCost(product2,BigDecimal.valueOf(1), 201801,BigDecimal.ZERO , true);
        MaterialCost m2 = new MaterialCost(product3,BigDecimal.valueOf(1), 201801,BigDecimal.ZERO , true);
        MaterialCost m3 = new MaterialCost(product4,BigDecimal.valueOf(1), 201801,BigDecimal.ZERO , true);
        MaterialCost m4 = new MaterialCost(product5,BigDecimal.valueOf(1), 201801,BigDecimal.ZERO , true);
        MaterialCost m5 = new MaterialCost(product6,BigDecimal.valueOf(1), 201801,BigDecimal.ZERO , true);
        MaterialCost m6 = new MaterialCost(product7,BigDecimal.valueOf(1), 201801,BigDecimal.ZERO , true);
        MaterialCost m7 = new MaterialCost(product1,BigDecimal.valueOf(1), 201801,BigDecimal.ZERO , true);
        MaterialCost m8 = new MaterialCost(product1,BigDecimal.valueOf(1), 201801,BigDecimal.ZERO , true);
        MaterialCost m9 = new MaterialCost(product8,BigDecimal.valueOf(1), 201801,BigDecimal.ZERO , false);


        costRepository.save(m1);
        costRepository.save(m2);
        costRepository.save(m3);
        costRepository.save(m4);
        costRepository.save(m5);
        costRepository.save(m6);
        costRepository.save(m7);
        costRepository.save(m8);
        costRepository.save(m9);

    }
}

