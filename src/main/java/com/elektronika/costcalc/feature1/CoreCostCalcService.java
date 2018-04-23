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


    public void placeholder(){
        materialCostRepository.findAllByYearMonthEquals(201801);
    }



}
