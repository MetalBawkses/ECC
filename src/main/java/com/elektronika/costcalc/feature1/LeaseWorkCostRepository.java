package com.elektronika.costcalc.feature1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LeaseWorkCostRepository extends JpaRepository<LeaseWorkCost, Long> {
    List<MaterialCost> findAllByYearMonthEquals(Integer yM);
}
