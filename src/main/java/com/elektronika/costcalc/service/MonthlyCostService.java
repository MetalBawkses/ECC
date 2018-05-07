package com.elektronika.costcalc.service;

import com.elektronika.costcalc.model.*;
import com.elektronika.costcalc.repository.CostRepository;
import com.elektronika.costcalc.repository.LedgerNumberRepository;
import com.elektronika.costcalc.repository.WorkCostRepository;
import com.elektronika.costcalc.util.CostList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class MonthlyCostService {

    @Autowired
    private CostRepository costRepository;

    @Autowired
    private WorkCostRepository workCostRepository;

    @Autowired
    LedgerNumberRepository ledgerNumberRepository;

    public HashMap createMapOfCostList(int yearMonth){
        List<LedgerNumber> ledgerNumbersList = ledgerNumberRepository.findAll();
        HashMap<Integer, CostList> monthlyCostsByLedgerNumber = new HashMap<>();

        for (LedgerNumber ledgerNumber : ledgerNumbersList){
            boolean ifLedgerNumberExistsInHashMap = monthlyCostsByLedgerNumber.containsKey(ledgerNumber.getLedgerNumber());
            if (!ifLedgerNumberExistsInHashMap){
                monthlyCostsByLedgerNumber.put(ledgerNumber.getLedgerNumber(), fillCostList(ledgerNumber, yearMonth));
            } else {
                updateCostList(monthlyCostsByLedgerNumber.get(ledgerNumber.getLedgerNumber()), yearMonth, ledgerNumber);
            }
        }
        return monthlyCostsByLedgerNumber;
    }

    private CostList fillCostList(LedgerNumber ledgerNumber, int yearMonth){

        int ledgerNumberForCostList = ledgerNumber.getLedgerNumber();
        BigDecimal matCost = costRepository.monthlyCostsByProdIdAndYearMonthAndCostType(ledgerNumber.getLeftEnd(), ledgerNumber.getRightEnd(), yearMonth, MaterialCost.class);
        BigDecimal leaseWorkCost = costRepository.monthlyCostsByProdIdAndYearMonthAndCostType(ledgerNumber.getLeftEnd(), ledgerNumber.getRightEnd(), yearMonth, LeaseWorkCost.class);
        BigDecimal workCost = costRepository.monthlyCostsByProdIdAndYearMonthAndCostType(ledgerNumber.getLeftEnd(), ledgerNumber.getRightEnd(), yearMonth, WorkCost.class);
        CostHolder costHolder = workCostRepository.allMonthlyCost(ledgerNumber.getLeftEnd(), ledgerNumber.getRightEnd(), yearMonth);

        return new CostList(ledgerNumberForCostList,
                matCost,
                leaseWorkCost,
                workCost,
                costHolder);
    }

    private CostList updateCostList(CostList costListToUpdate, int yearMonth, LedgerNumber ledgerNumber){

        BigDecimal matCost = costRepository.monthlyCostsByProdIdAndYearMonthAndCostType(ledgerNumber.getLeftEnd(), ledgerNumber.getRightEnd(), yearMonth, MaterialCost.class);
        BigDecimal leaseWorkCost = costRepository.monthlyCostsByProdIdAndYearMonthAndCostType(ledgerNumber.getLeftEnd(), ledgerNumber.getRightEnd(), yearMonth, LeaseWorkCost.class);
        BigDecimal workCost = costRepository.monthlyCostsByProdIdAndYearMonthAndCostType(ledgerNumber.getLeftEnd(), ledgerNumber.getRightEnd(), yearMonth, WorkCost.class);
        CostHolder costHolder = workCostRepository.allMonthlyCost(ledgerNumber.getLeftEnd(), ledgerNumber.getRightEnd(), yearMonth);

        costListToUpdate.updateExistingValues(matCost, leaseWorkCost, workCost, costHolder);
        return costListToUpdate;

    }

    public HashMap monthlyCostCalculator(Integer yearMonth, List<Object> costClassList) {
        List<LedgerNumber> ledgerNumbers = ledgerNumberRepository.findAll();
        HashMap<Integer, ArrayList<BigDecimal>> monthlyCostsByLedgerNumber = new HashMap<>();
        for (LedgerNumber ledgerNumber : ledgerNumbers) {
            boolean ifLedgerNumberExistsInHashMap = monthlyCostsByLedgerNumber.containsKey(ledgerNumber.getLedgerNumber());
            if (!ifLedgerNumberExistsInHashMap) {
                monthlyCostsByLedgerNumber.put(ledgerNumber.getLedgerNumber(), new ArrayList<>());
                for (Object costClass : costClassList) {
                    BigDecimal valueForMonthlyCostsByLedgerNumber = costRepository.monthlyCostsByProdIdAndYearMonthAndCostType(ledgerNumber.getLeftEnd(), ledgerNumber.getRightEnd(), yearMonth, costClass);
                    monthlyCostsByLedgerNumber.get(ledgerNumber.getLedgerNumber()).add(valueForMonthlyCostsByLedgerNumber);
                }
            } else {
                int costCounter = 0;
                for (Object costClass : costClassList) {
                    BigDecimal valueToUpdateForMonthlyCostsByLedgerNumber = monthlyCostsByLedgerNumber.get(ledgerNumber.getLedgerNumber()).get(costCounter);
                    BigDecimal valueToAddForMonthlyCostsByLedgerNumber = costRepository.monthlyCostsByProdIdAndYearMonthAndCostType(ledgerNumber.getLeftEnd(), ledgerNumber.getRightEnd(), yearMonth, costClass);
                    monthlyCostsByLedgerNumber.get(ledgerNumber.getLedgerNumber()).set(costCounter, valueToUpdateForMonthlyCostsByLedgerNumber.add(valueToAddForMonthlyCostsByLedgerNumber));
                    costCounter += 1;
                }
            }
        }
        return monthlyCostsByLedgerNumber;
    }
}
