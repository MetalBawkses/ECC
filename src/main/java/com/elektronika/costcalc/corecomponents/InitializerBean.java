package com.elektronika.costcalc.corecomponents;

import com.elektronika.costcalc.feature1.MaterialCost;
import com.elektronika.costcalc.feature1.MaterialCostRepository;
import com.elektronika.costcalc.feature1.WorkCost;
import com.elektronika.costcalc.feature1.WorkCostService;
import com.elektronika.costcalc.model.Worker;
import com.elektronika.costcalc.model.WorkerMonthly;
import com.elektronika.costcalc.model.WorkerMonthlyService;
import com.elektronika.costcalc.model.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class InitializerBean {

    @Autowired
    ProductService productService;

    @Autowired
    WorkCostService workCostService;

    @Autowired
    WorkerService workerService;

    @Autowired
    WorkerMonthlyService workerMonthlyService;

    @Autowired
    MaterialCostRepository materialCostRepository;

    @PostConstruct
    public void init(){
//        Product product1 = new Product();
//        product1.setId(123456);
//        product1.setName("placeholderName");
//        product1.setAmount(77);
//        productService.saveProduct(product1);
//
//        Worker worker1 = new Worker();
//        worker1.setDivision("div1");
//        worker1.setName("workerName1");
//        workerService.saveWorker(worker1);
//        WorkerMonthly workerMonthly1 = new WorkerMonthly();
//        workerMonthly1.setHourlyRate(850);
//        workerMonthly1.setSocialContribution(0.27f);
//        workerMonthly1.setVocationalTrainingContribution(0.015f);
//        workerMonthly1.setYearMonth(201801);
//        workerMonthly1.setWorkerId(worker1);
//        workerMonthlyService.saveWorkerMonthly(workerMonthly1);
//
//
//        WorkCost workCost1 = new WorkCost();
//        workCost1.setHoursOfWork(15);
//        workCost1.setProductId(product1);
//        workCost1.setWorkerId(worker1);
//        workCost1.setYearMonth(201801);
//        workCostService.saveWorkCost(workCost1);

        MaterialCost m1 = new MaterialCost(21f, 201801);
        MaterialCost m2 = new MaterialCost(22f, 201802);
        MaterialCost m3 = new MaterialCost(23f, 201803);
        MaterialCost m4 = new MaterialCost(24f, 201804);
        MaterialCost m5 = new MaterialCost(25f, 201805);
        MaterialCost m6 = new MaterialCost(26f, 201801);
        MaterialCost m7 = new MaterialCost(27f, 201801);
        MaterialCost m8 = new MaterialCost(28f, 201801);

        materialCostRepository.save(m1);
        materialCostRepository.save(m2);
        materialCostRepository.save(m3);
        materialCostRepository.save(m4);
        materialCostRepository.save(m5);
        materialCostRepository.save(m6);
        materialCostRepository.save(m7);
        materialCostRepository.save(m8);

        List<MaterialCost> result = materialCostRepository.findAllByYearMonthEquals(201801);

        System.out.println(result);
    }
}

