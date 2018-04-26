package com.elektronika.costcalc.service;

import com.elektronika.costcalc.repository.CostRepository;
import com.elektronika.costcalc.model.LedgerNumber;
import com.elektronika.costcalc.repository.LedgerNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Service
public class MonthlyCostService {

    @Autowired
    private CostRepository costRepository;

    @Autowired
    LedgerNumberRepository ledgerNumberRepository;


    public HashMap calculateMaterialMonthlyCostsForLedgerNumbers(Integer yearMonth) {
        List<LedgerNumber> ledgerNumbers = ledgerNumberRepository.findAll();
        HashMap<Integer, Float> monthlyCostsByLedgerNumber = new HashMap<>();
        for (LedgerNumber ledgerNumber : ledgerNumbers) {
            Float valueForMonthlyCostsByLedgerNumber = costRepository.findMaterialCostByProductIdBetweenAndYearMonth(ledgerNumber.getLeftEnd(), ledgerNumber.getRightEnd(), yearMonth);
            if (!monthlyCostsByLedgerNumber.containsKey(ledgerNumber.getLedgerNumber())) {
                monthlyCostsByLedgerNumber.put(ledgerNumber.getLedgerNumber(), valueForMonthlyCostsByLedgerNumber);
            } else {
                float updatedValueForMonthlyCostsByLedgerNumber = monthlyCostsByLedgerNumber.get(ledgerNumber.getLedgerNumber()) + valueForMonthlyCostsByLedgerNumber;
                monthlyCostsByLedgerNumber.put(ledgerNumber.getLedgerNumber(), updatedValueForMonthlyCostsByLedgerNumber);
            }
        }
        return monthlyCostsByLedgerNumber;
    }

    public HashMap calculateWorkMonthlyCostsForLedgerNumbers(Integer yearMonth) {
        List<LedgerNumber> ledgerNumbers = ledgerNumberRepository.findAll();
        HashMap<Integer, Float> monthlyCostsByLedgerNumber = new HashMap<>();
        for (LedgerNumber ledgerNumber : ledgerNumbers) {
            Float valueForMonthlyCostsByLedgerNumber = costRepository.findWorkCostByProductIdBetweenAndYearMonth(ledgerNumber.getLeftEnd(), ledgerNumber.getRightEnd(), yearMonth);
            if (!monthlyCostsByLedgerNumber.containsKey(ledgerNumber.getLedgerNumber())) {
                monthlyCostsByLedgerNumber.put(ledgerNumber.getLedgerNumber(), valueForMonthlyCostsByLedgerNumber);
            } else {
                float updatedValueForMonthlyCostsByLedgerNumber = monthlyCostsByLedgerNumber.get(ledgerNumber.getLedgerNumber()) + valueForMonthlyCostsByLedgerNumber;
                monthlyCostsByLedgerNumber.put(ledgerNumber.getLedgerNumber(), updatedValueForMonthlyCostsByLedgerNumber);
            }
        }
        return monthlyCostsByLedgerNumber;
    }

    public HashMap calculateLeaseWorkMonthlyCostsForLedgerNumbers(Integer yearMonth) {
        List<LedgerNumber> ledgerNumbers = ledgerNumberRepository.findAll();
        HashMap<Integer, Float> monthlyCostsByLedgerNumber = new HashMap<>();
        for (LedgerNumber ledgerNumber : ledgerNumbers) {
            Float valueForMonthlyCostsByLedgerNumber = costRepository.findLeaseWorkCostByProductIdBetweenAndYearMonth(ledgerNumber.getLeftEnd(), ledgerNumber.getRightEnd(), yearMonth);
            if (!monthlyCostsByLedgerNumber.containsKey(ledgerNumber.getLedgerNumber())) {
                monthlyCostsByLedgerNumber.put(ledgerNumber.getLedgerNumber(), valueForMonthlyCostsByLedgerNumber);
            } else {
                float updatedValueForMonthlyCostsByLedgerNumber = monthlyCostsByLedgerNumber.get(ledgerNumber.getLedgerNumber()) + valueForMonthlyCostsByLedgerNumber;
                monthlyCostsByLedgerNumber.put(ledgerNumber.getLedgerNumber(), updatedValueForMonthlyCostsByLedgerNumber);
            }
        }
        return monthlyCostsByLedgerNumber;
    }

    public HashMap mergeCostMaps(){
        Set<Integer> ledgerNumbers = ledgerNumberRepository.getLedgerNumberToSet();
        HashMap<Integer, ArrayList<Float>> monthlyCostsByLedgerNumber = new HashMap<>();

        HashMap<Integer, Float> matCost = calculateMaterialMonthlyCostsForLedgerNumbers(201801);
        HashMap<Integer, Float> workCost = calculateWorkMonthlyCostsForLedgerNumbers(201801);
        HashMap<Integer, Float> leaseWCost = calculateLeaseWorkMonthlyCostsForLedgerNumbers(201801);

        for (Integer ledgerNumber: ledgerNumbers) {
            monthlyCostsByLedgerNumber.put(ledgerNumber, new ArrayList<>());
            monthlyCostsByLedgerNumber.get(ledgerNumber).add(matCost.get(ledgerNumber));
            monthlyCostsByLedgerNumber.get(ledgerNumber).add(workCost.get(ledgerNumber));
            monthlyCostsByLedgerNumber.get(ledgerNumber).add(leaseWCost.get(ledgerNumber));
        }

        for (Integer ledgerNumber: ledgerNumbers) {
            System.out.println("ln: " + ledgerNumber + " cost: " + monthlyCostsByLedgerNumber.get(ledgerNumber).toString());
        }

        return monthlyCostsByLedgerNumber;
    }


}
