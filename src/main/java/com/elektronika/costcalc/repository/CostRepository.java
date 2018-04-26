package com.elektronika.costcalc.repository;


import com.elektronika.costcalc.model.Cost;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CostRepository extends CostBaseRepository<Cost>{

    List<Cost> findCostByProductIdBetween(Integer prodLeft, Integer prodRight);

    Integer countCostsByProductId(Integer prodId);

    @Query("select sum(c.cost) from Cost c where c.product.id between :prodLeft and :prodRight and c.yearMonth = :ym and TYPE(c) = MaterialCost ")
    Float findMaterialCostByProductIdBetweenAndYearMonth(@Param("prodLeft") Integer prodLeft, @Param("prodRight") Integer prodRight, @Param("ym") Integer ym);

    @Query("select sum(c.cost) from Cost c where c.product.id between :prodLeft and :prodRight and c.yearMonth = :ym and TYPE(c) = WorkCost ")
    Float findWorkCostByProductIdBetweenAndYearMonth(@Param("prodLeft") Integer prodLeft, @Param("prodRight") Integer prodRight, @Param("ym") Integer ym);

    @Query("select sum(c.cost) from Cost c where c.product.id between :prodLeft and :prodRight and c.yearMonth = :ym and TYPE(c) = LeaseWorkCost ")
    Float findLeaseWorkCostByProductIdBetweenAndYearMonth(@Param("prodLeft") Integer prodLeft, @Param("prodRight") Integer prodRight, @Param("ym") Integer ym);


//
//    @Query("select sum(c.cost) from Cost c where TYPE(c) = MaterialCost ")
//    Float findCostsByType();

}