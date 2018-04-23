package com.elektronika.costcalc.feature1;

import com.elektronika.costcalc.corecomponents.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoreCostCalcService {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MaterialCostRepository materialCostRepository;

    @Autowired
    private LeaseWorkCostRepository leaseWorkCostRepository;

    @Autowired
    private WorkCostRepository workCostRepository;


    public Float placeholder(){
        Float returnValue;
//        returnValue =
//        materialCostRepository.findAllByYearMonthEquals(201801)
//        for (MaterialCost materialCost: materialCostRepository.findAllByYearMonthEquals(201801)
//             ) {
//
//        }
//        leaseWorkCostRepository.findAllByYearMonthEquals(201801);
//        workCostRepository.findAllByYearMonthEquals(201801);

        materialCostRepository.findAllCost(201801);

        return null;
    }



}
