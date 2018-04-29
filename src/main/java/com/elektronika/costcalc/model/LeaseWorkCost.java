package com.elektronika.costcalc.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("leaseWorkCost")
public class LeaseWorkCost extends Cost {

    private String billNumber;

    public LeaseWorkCost(Product productId, BigDecimal cost, Integer yearMonth, String billNumber, boolean directCost){
        super(productId, cost, yearMonth, directCost);
        this.billNumber = billNumber;
    }

    public LeaseWorkCost() {
    }


    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }


}
