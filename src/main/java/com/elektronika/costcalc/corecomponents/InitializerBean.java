package com.elektronika.costcalc.corecomponents;

import com.elektronika.costcalc.feature1.WorkCost;
import com.elektronika.costcalc.feature1.WorkCostService;
import com.elektronika.costcalc.model.Worker;
import com.elektronika.costcalc.model.WorkerMonthly;
import com.elektronika.costcalc.model.WorkerMonthlyService;
import com.elektronika.costcalc.model.WorkerService;
import org.springframework.stereotype.Component;

@Component
public class InitializerBean {
    public InitializerBean(ProductService productService, WorkCostService workCostService, WorkerService workerService, WorkerMonthlyService workerMonthlyService){
        Product product1 = new Product();
        product1.setId(123456);
        product1.setName("placeholderName");
        product1.setAmount(77);
        productService.saveProduct(product1);

        Worker worker1 = new Worker();
        worker1.setDivision("div1");
        worker1.setName("workerName1");
        workerService.saveWorker(worker1);
        WorkerMonthly workerMonthly1 = new WorkerMonthly();
        workerMonthly1.setHourlyRate(850);
        workerMonthly1.setSocialContribution(0.27f);
        workerMonthly1.setVocationalTrainingContribution(0.015f);
        workerMonthly1.setYearMonth(201801);
        workerMonthly1.setWorkerId(worker1);
        workerMonthlyService.saveWorkerMonthly(workerMonthly1);


        WorkCost workCost1 = new WorkCost();
        workCost1.setHoursOfWork(15);
        workCost1.setProductId(product1);
        workCost1.setWorkerId(worker1);
        workCost1.setYearMonth(201801);
        workCostService.saveWorkCost(workCost1);



    }
}

