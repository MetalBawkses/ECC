package com.elektronika.costcalc.feature1;

import com.elektronika.costcalc.corecomponents.Product;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("developmentCost")
public class DevelopmentCost extends Cost {




    public DevelopmentCost(Product product, Float cost, Integer yearMonth, boolean directCost) {
        super(product, cost, yearMonth, directCost);
    }

    public DevelopmentCost() {
    }


}
