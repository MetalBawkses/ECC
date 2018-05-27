package com.elektronika.costcalc.repository;

import com.elektronika.costcalc.TestRoot;
import com.elektronika.costcalc.model.Cost;
import com.elektronika.costcalc.model.MaterialCost;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class CostRepositoryTest extends TestRoot {

    @Autowired
    private CostRepository costRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCount() {
        long whatever = costRepository.count();
        assertEquals(29, whatever);
    }

    @Test
    public void testMonthlyCostsByProdIdAndYearMonthAndCostType(){
        BigDecimal queryResult = costRepository.monthlyCostsByProdIdAndYearMonthAndCostType(100000, 199999, 201801, MaterialCost.class, true);
        assertEquals(2, queryResult.intValue());
    }
}