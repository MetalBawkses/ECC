package com.elektronika.costcalc.service;

import com.elektronika.costcalc.model.*;
import com.elektronika.costcalc.repository.CostRepository;
import com.elektronika.costcalc.repository.LedgerNumberRepository;
import com.elektronika.costcalc.repository.WorkCostRepository;
import com.elektronika.costcalc.util.CostList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.elektronika.costcalc.util.BigDecimalUtil.scaleIfNotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

@Service
public class MonthlyCostService{

    @Autowired
    private CostRepository costRepository;

    @Autowired
    private WorkCostRepository workCostRepository;

    @Autowired
    LedgerNumberRepository ledgerNumberRepository;

    public List createMapOfCostList(int yearMonth){
        List<LedgerNumber> ledgerNumbersList = ledgerNumberRepository.findAll();
        HashMap<Integer, CostList> monthlyCostsByLedgerNumber = new HashMap<>();
        List<CostList> listForReturn = new ArrayList<>();

        for (LedgerNumber ledgerNumber : ledgerNumbersList){
            boolean ifLedgerNumberExistsInHashMap = monthlyCostsByLedgerNumber.containsKey(ledgerNumber.getLedgerNumber());
            if (!ifLedgerNumberExistsInHashMap){
                monthlyCostsByLedgerNumber.put(ledgerNumber.getLedgerNumber(), fillCostList(ledgerNumber, yearMonth));
            } else {
                updateCostList(monthlyCostsByLedgerNumber.get(ledgerNumber.getLedgerNumber()), yearMonth, ledgerNumber);
            }
        }
        List<Integer> keyList = new ArrayList<>(monthlyCostsByLedgerNumber.keySet());
        System.out.println(keyList);
        for (Integer key: keyList) {
            listForReturn.add(monthlyCostsByLedgerNumber.get(key));
        }

        return listForReturn;


    }

    private CostList fillCostList(LedgerNumber ledgerNumber, int yearMonth){

        int ledgerNumberForCostList = ledgerNumber.getLedgerNumber();
        BigDecimal matCost = scaleIfNotNull(costRepository.monthlyCostsByProdIdAndYearMonthAndCostType(ledgerNumber.getLeftEnd(), ledgerNumber.getRightEnd(), yearMonth, MaterialCost.class, ledgerNumber.isDirectCost()));
        BigDecimal leaseWorkCost = scaleIfNotNull(costRepository.monthlyCostsByProdIdAndYearMonthAndCostType(ledgerNumber.getLeftEnd(), ledgerNumber.getRightEnd(), yearMonth, LeaseWorkCost.class, ledgerNumber.isDirectCost()));
        BigDecimal workCost = scaleIfNotNull(costRepository.monthlyCostsByProdIdAndYearMonthAndCostType(ledgerNumber.getLeftEnd(), ledgerNumber.getRightEnd(), yearMonth, WorkCost.class, ledgerNumber.isDirectCost()));
        WorkCostExtensions workCostExtensions = workCostRepository.allMonthlyCost(ledgerNumber.getLeftEnd(), ledgerNumber.getRightEnd(), yearMonth, ledgerNumber.isDirectCost());

        return new CostList(ledgerNumberForCostList,
                matCost,
                leaseWorkCost,
                workCost,
                workCostExtensions);
    }

    private CostList updateCostList(CostList costListToUpdate, int yearMonth, LedgerNumber ledgerNumber){

        BigDecimal matCost = scaleIfNotNull(costRepository.monthlyCostsByProdIdAndYearMonthAndCostType(ledgerNumber.getLeftEnd(), ledgerNumber.getRightEnd(), yearMonth, MaterialCost.class, ledgerNumber.isDirectCost()));
        BigDecimal leaseWorkCost = scaleIfNotNull(costRepository.monthlyCostsByProdIdAndYearMonthAndCostType(ledgerNumber.getLeftEnd(), ledgerNumber.getRightEnd(), yearMonth, LeaseWorkCost.class, ledgerNumber.isDirectCost()));
        BigDecimal workCost = scaleIfNotNull(costRepository.monthlyCostsByProdIdAndYearMonthAndCostType(ledgerNumber.getLeftEnd(), ledgerNumber.getRightEnd(), yearMonth, WorkCost.class, ledgerNumber.isDirectCost()));
        WorkCostExtensions workCostExtensions = workCostRepository.allMonthlyCost(ledgerNumber.getLeftEnd(), ledgerNumber.getRightEnd(), yearMonth, ledgerNumber.isDirectCost());

        costListToUpdate.updateExistingValues(matCost, leaseWorkCost, workCost, workCostExtensions);
        return costListToUpdate;

    }
}
