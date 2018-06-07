package com.elektronika.costcalc.service;

import com.elektronika.costcalc.model.MaterialCost;
import com.elektronika.costcalc.repository.CostRepository;
import com.elektronika.costcalc.repository.MaterialCostRepository;
import com.elektronika.costcalc.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MaterialCostService {

    @Autowired
    private CostRepository costRepository;

    @Autowired
    private MaterialCostRepository materialCostRepository;

    @Autowired
    private ProductRepository productRepository;

    public boolean createMaterialCost(Integer productId, BigDecimal cost, Integer yearMonth, BigDecimal selfProducedMaterialCost){
//        if (productRepository.getOne(productId))
        MaterialCost materialCost = new MaterialCost(productRepository.getOne(productId), cost, yearMonth, selfProducedMaterialCost, true);
        materialCostRepository.save(materialCost);
        return true;
    }
}
