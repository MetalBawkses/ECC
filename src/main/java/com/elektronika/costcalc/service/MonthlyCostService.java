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


    public HashMap monthlyCostCalculator(Integer yearMonth, List<Object> costClassList) {
        List<LedgerNumber> ledgerNumbers = ledgerNumberRepository.findAll();
        HashMap<Integer, ArrayList<Float>> monthlyCostsByLedgerNumber = new HashMap<>();
        for (LedgerNumber ledgerNumber : ledgerNumbers) {
            boolean ifLedgerNumberExistsInHashMap = monthlyCostsByLedgerNumber.containsKey(ledgerNumber.getLedgerNumber());
            if (!ifLedgerNumberExistsInHashMap) {
                monthlyCostsByLedgerNumber.put(ledgerNumber.getLedgerNumber(), new ArrayList<>());
                for (Object costClass : costClassList) {
                    Float valueForMonthlyCostsByLedgerNumber = costRepository.dummySearch2(ledgerNumber.getLeftEnd(), ledgerNumber.getRightEnd(), yearMonth, costClass);
                    monthlyCostsByLedgerNumber.get(ledgerNumber.getLedgerNumber()).add(valueForMonthlyCostsByLedgerNumber);
                }
            } else {
                int costCounter = 0;
                for (Object costClass : costClassList) {
                    float valueToUpdateForMonthlyCostsByLedgerNumber = monthlyCostsByLedgerNumber.get(ledgerNumber.getLedgerNumber()).get(costCounter);
                    float valueToAddForMonthlyCostsByLedgerNumber = costRepository.dummySearch2(ledgerNumber.getLeftEnd(), ledgerNumber.getRightEnd(), yearMonth, costClass);
                    monthlyCostsByLedgerNumber.get(ledgerNumber.getLedgerNumber()).set(costCounter, valueToUpdateForMonthlyCostsByLedgerNumber + valueToAddForMonthlyCostsByLedgerNumber);
                    costCounter += 1;
                }
            }
        }
        return monthlyCostsByLedgerNumber;
    }

}
