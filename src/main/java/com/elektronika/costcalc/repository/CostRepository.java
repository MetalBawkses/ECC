package com.elektronika.costcalc.repository;


import com.elektronika.costcalc.model.Cost;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;


public interface CostRepository extends CostBaseRepository<Cost>{

    @Query("select sum(c.cost) from Cost c where c.product.id between :prodLeft and :prodRight and c.yearMonth = :ym and TYPE(c) = :eType and c.directCost = :dc")
    BigDecimal monthlyCostsByProdIdAndYearMonthAndCostType(@Param("prodLeft") Integer prodLeft,
                                                           @Param("prodRight") Integer prodRight,
                                                           @Param("ym") Integer ym,
                                                           @Param("eType") Object eType,
                                                           @Param("dc") Boolean directCost);



}