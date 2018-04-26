package com.elektronika.costcalc.repository;

import com.elektronika.costcalc.model.DevelopmentCost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DevelopmentCostRepository extends JpaRepository <DevelopmentCost, Long> {
}
