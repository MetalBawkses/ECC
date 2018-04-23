package com.elektronika.costcalc.feature1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkCostRepository extends JpaRepository <WorkCost, Long> {

    List<MaterialCost> findAllByYearMonthEquals(Integer yM);
}
