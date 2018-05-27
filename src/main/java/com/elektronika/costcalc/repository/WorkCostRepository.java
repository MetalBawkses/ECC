package com.elektronika.costcalc.repository;


import com.elektronika.costcalc.model.WorkCostExtensions;
import com.elektronika.costcalc.model.WorkCost;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface WorkCostRepository extends CostBaseRepository<WorkCost>{

    @Query("select new com.elektronika.costcalc.model.WorkCostExtensions(" +
            " sum(w.workCostExtra)," +
            " sum(w.socialContributionCost)," +
            " sum(w.vocationalTrainingContributionCost) " +
            ") from WorkCost w where w.product.id between :prodLeft and :prodRight and w.yearMonth = :ym and w.directCost = :dc")
    WorkCostExtensions allMonthlyCost(@Param("prodLeft") Integer prodLeft,
                                      @Param("prodRight") Integer prodRight,
                                      @Param("ym") Integer ym,
                                      @Param("dc") Boolean directCost);

}

