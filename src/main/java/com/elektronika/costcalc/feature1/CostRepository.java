package com.elektronika.costcalc.feature1;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CostRepository extends CostBaseRepository<Cost>{

    List<Cost> findCostByProductIdBetween(Integer prodLeft, Integer prodRight);

    Integer countCostsByProductId(Integer prodId);

    @Query("select sum(c.cost) from Cost c where c.product.id between :prodLeft and :prodRight and c.yearMonth = :ym")
    Float findCostByProductIdBetweenAndYearMonth(@Param("prodLeft") Integer prodLeft, @Param("prodRight") Integer prodRight, @Param("ym") Integer ym);


    @Query("select sum(c.cost) from Cost c where TYPE(c) = MaterialCost ")
    Float findCostsByType();

}