package com.elektronika.costcalc.feature1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialCostRepository extends JpaRepository <MaterialCost, Long> {

    List<MaterialCost> findAllByYearMonthEquals(Integer yM);
}
