package com.elektronika.costcalc.feature1;


import javax.transaction.Transactional;

@Transactional
public interface WorkCostRepository extends CostBaseRepository<WorkCost>{

}
//public interface WorkCostRepository extends JpaRepository <WorkCost, Long> {
//
//    List<MaterialCost> findAllByYearMonthEquals(Integer yM);
//}
