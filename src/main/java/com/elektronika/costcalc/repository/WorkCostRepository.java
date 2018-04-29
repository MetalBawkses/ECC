package com.elektronika.costcalc.repository;


import com.elektronika.costcalc.model.WorkCost;

import javax.transaction.Transactional;

@Transactional
public interface WorkCostRepository extends CostBaseRepository<WorkCost>{

}

