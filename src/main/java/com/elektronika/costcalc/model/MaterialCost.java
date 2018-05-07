package com.elektronika.costcalc.model;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("materialCost")
public class MaterialCost extends Cost {

    @Column(precision = 25, scale = 10)
    private BigDecimal selfProducedMaterialCost;

    public MaterialCost(Product productId, BigDecimal cost, Integer yearMonth, BigDecimal selfProducedMaterialCost, boolean directCost) {
        super(productId, cost, yearMonth, directCost);
        this.selfProducedMaterialCost = selfProducedMaterialCost;
    }

    public MaterialCost() {
    }


    public BigDecimal getSelfProducedMaterialCost() {
        return selfProducedMaterialCost;
    }

    public void setSelfProducedMaterialCost(BigDecimal selfProducedMaterialCost) {
        this.selfProducedMaterialCost = selfProducedMaterialCost;
    }


}



