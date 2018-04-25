package com.elektronika.costcalc.feature1;

import com.elektronika.costcalc.corecomponents.Product;

import javax.persistence.*;

@Entity
@DiscriminatorValue("leaseWorkCost")
public class LeaseWorkCost extends Cost{

    private String billNumber;

    public LeaseWorkCost(Product productId, Float cost, Integer yearMonth, String billNumber, boolean directCost){
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
