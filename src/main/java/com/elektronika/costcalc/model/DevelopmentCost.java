package com.elektronika.costcalc.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("developmentCost")
public class DevelopmentCost extends Cost {

    @ManyToOne
    private Worker worker;


    public DevelopmentCost(Product product, BigDecimal cost, Integer yearMonth, boolean directCost) {
        super(product, cost, yearMonth, directCost);
    }

    public DevelopmentCost() {
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}
