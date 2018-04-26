package com.elektronika.costcalc.repository;

import com.elektronika.costcalc.model.LeaseWorkCost;

import javax.transaction.Transactional;

@Transactional
public interface LeaseWorkCostRepository extends CostBaseRepository <LeaseWorkCost>/*JpaRepository<LeaseWorkCost, Long>*/ {
//    List<MaterialCost> findAllByYearMonthEquals(Integer yM);
}
