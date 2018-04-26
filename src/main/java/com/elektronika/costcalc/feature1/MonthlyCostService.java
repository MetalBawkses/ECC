package com.elektronika.costcalc.feature1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MonthlyCostService {

    @Autowired
    private CostRepository costRepository;

    @Autowired
    LedgerNumberRepository ledgerNumberRepository;


    public HashMap calculateMonthlyCostsForLedgerNumbers(Integer yearMonth) {
        List<LedgerNumber> ledgerNumbers = ledgerNumberRepository.findAll();
        HashMap<Integer, Float> monthlyCostsByLedgerNumber = new HashMap<>();
        for (LedgerNumber ledgerNumber : ledgerNumbers) {
            Float valueForMonthlyCostsByLedgerNumber = costRepository.findCostByProductIdBetweenAndYearMonth(ledgerNumber.getLeftEnd(), ledgerNumber.getRightEnd(), yearMonth);
            if (!monthlyCostsByLedgerNumber.containsKey(ledgerNumber.getLedgerNumber())) {
                monthlyCostsByLedgerNumber.put(ledgerNumber.getLedgerNumber(), valueForMonthlyCostsByLedgerNumber);
            } else {
                float updatedValueForMonthlyCostsByLedgerNumber = monthlyCostsByLedgerNumber.get(ledgerNumber.getLedgerNumber()) + valueForMonthlyCostsByLedgerNumber;
                monthlyCostsByLedgerNumber.put(ledgerNumber.getLedgerNumber(), updatedValueForMonthlyCostsByLedgerNumber);
            }
        }
        return monthlyCostsByLedgerNumber;
    }

    public void costsByType(){
        System.out.println("by type: " + costRepository.findCostsByType());
    }


}
