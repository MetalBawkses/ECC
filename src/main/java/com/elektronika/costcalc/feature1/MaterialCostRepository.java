package com.elektronika.costcalc.feature1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

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
