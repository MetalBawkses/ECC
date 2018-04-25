package com.elektronika.costcalc.feature1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import javax.transaction.Transactional;

@Transactional
public interface LeaseWorkCostRepository extends CostBaseRepository <LeaseWorkCost>/*JpaRepository<LeaseWorkCost, Long>*/ {
//    List<MaterialCost> findAllByYearMonthEquals(Integer yM);
}
