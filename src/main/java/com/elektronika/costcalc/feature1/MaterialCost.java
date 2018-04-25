package com.elektronika.costcalc.feature1;


import com.elektronika.costcalc.corecomponents.Product;

import javax.persistence.*;

@Entity
@DiscriminatorValue("materialCost")
public class MaterialCost extends Cost {


    private Float selfProducedMaterialCost;

    public MaterialCost(Product productId, Float cost, Integer yearMonth, Float selfProducedMaterialCost) {
        super(productId, cost, yearMonth);
        this.selfProducedMaterialCost = selfProducedMaterialCost;
    }

    public MaterialCost() {
    }


    public Float getSelfProducedMaterialCost() {
        return selfProducedMaterialCost;
    }

    public void setSelfProducedMaterialCost(Float selfProducedMaterialCost) {
        this.selfProducedMaterialCost = selfProducedMaterialCost;
    }


}



