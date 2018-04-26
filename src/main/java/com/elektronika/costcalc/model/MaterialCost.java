package com.elektronika.costcalc.model;


import javax.persistence.*;

@Entity
@DiscriminatorValue("materialCost")
public class MaterialCost extends Cost {


    private Float selfProducedMaterialCost;

    public MaterialCost(Product productId, Float cost, Integer yearMonth, Float selfProducedMaterialCost, boolean directCost) {
        super(productId, cost, yearMonth, directCost);
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



