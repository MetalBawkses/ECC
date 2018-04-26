package com.elektronika.costcalc.repository;

import com.elektronika.costcalc.model.MaterialCost;

import javax.transaction.Transactional;

@Transactional
public interface MaterialCostRepository extends CostBaseRepository<MaterialCost>/*JpaRepository <MaterialCost, Long> */{

//    List<MaterialCost> findAllByYearMonthEquals(Integer yM);
//
//    @Query("select m.cost from MaterialCost m where m.yearMonth= :ym")
//    List<Float> findAllCost(@Param("ym") Integer ym);
//
//    @Query("select sum(m.cost) from MaterialCost m where m.yearMonth= :ym")
//    Float findAllCost2(@Param("ym") Integer ym);
}
