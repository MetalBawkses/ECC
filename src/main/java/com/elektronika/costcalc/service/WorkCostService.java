package com.elektronika.costcalc.service;

import com.elektronika.costcalc.model.Product;
import com.elektronika.costcalc.model.WorkCost;
import com.elektronika.costcalc.model.Worker;
import com.elektronika.costcalc.repository.WorkCostRepository;
import com.elektronika.costcalc.repository.WorkerMonthlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WorkCostService {

    @Autowired
    WorkerMonthlyRepository workerMonthlyRepository;

    @Autowired
    WorkCostRepository workCostRepository;


    private BigDecimal calculateWorkCost(Worker worker, Integer yearMonth, BigDecimal hoursOfWork){
        Integer hourlyRate = workerMonthlyRepository.getAllByWorkerAndYearMonth(worker, yearMonth).getHourlyRate();
        return hoursOfWork.multiply(BigDecimal.valueOf(hourlyRate));
    }

    private BigDecimal calculateWorkCostExtra(Worker worker, Integer yearMonth, BigDecimal workCostTotal, Boolean directCost){
        if (!directCost){
            return BigDecimal.ZERO;
        }
        BigDecimal workCostExtraPercentage = workerMonthlyRepository.getAllByWorkerAndYearMonth(worker, yearMonth).getWorkCostExtra();
        return workCostTotal.multiply(workCostExtraPercentage);
    }

    private BigDecimal calculateSocialContributionCost(Worker worker, Integer yearMonth, BigDecimal workCostTotal){
        BigDecimal socContrPercentage = workerMonthlyRepository.getAllByWorkerAndYearMonth(worker, yearMonth).getSocialContribution();
        return workCostTotal.multiply(socContrPercentage);
    }

    private BigDecimal calculateVocationalTrainingContributionCost(Worker worker, Integer yearMonth, BigDecimal workCostTotal){
        BigDecimal vocTrainingContrPercentage = workerMonthlyRepository.getAllByWorkerAndYearMonth(worker, yearMonth).getVocationalTrainingContribution();
        return workCostTotal.multiply(vocTrainingContrPercentage);
    }

    public void createWorkCostByWorkSheet(Product productId, Integer yearMonth, BigDecimal hoursOfWork, Worker worker, boolean directCost){
        BigDecimal workCostTotal = calculateWorkCost(worker, yearMonth, hoursOfWork);
        WorkCost workCost = new WorkCost(productId,
                workCostTotal,
                yearMonth,
                hoursOfWork,
                worker,
                directCost,
                calculateSocialContributionCost(worker,yearMonth,workCostTotal),
                calculateVocationalTrainingContributionCost(worker,yearMonth,workCostTotal),
                calculateWorkCostExtra(worker, yearMonth, workCostTotal, directCost) );
        workCostRepository.save(workCost);

    }

}
