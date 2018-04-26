package com.elektronika.costcalc.repository;


import com.elektronika.costcalc.model.WorkCost;

import javax.transaction.Transactional;

@Transactional
public interface WorkCostRepository extends CostBaseRepository<WorkCost>{

}
//public interface WorkCostRepository extends JpaRepository <WorkCost, Long> {
//
//    List<MaterialCost> findAllByYearMonthEquals(Integer yM);
//}
