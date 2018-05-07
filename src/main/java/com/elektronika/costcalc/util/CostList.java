package com.elektronika.costcalc.util;

import com.elektronika.costcalc.model.CostHolder;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CostList {

    private int ledgerNumber;
    private BigDecimal matCost;
    private BigDecimal leaseWorkCost;
    private BigDecimal workCost;
    private CostHolder costHolder;

    public CostList(int ledgerNumber, BigDecimal matCost, BigDecimal leaseWorkCost, BigDecimal workCost, CostHolder costHolder) {
        this.ledgerNumber = ledgerNumber;
        this.matCost = matCost.setScale(2, RoundingMode.HALF_UP);
        this.leaseWorkCost = leaseWorkCost.setScale(2, RoundingMode.HALF_UP);
        this.workCost = workCost.setScale(2, RoundingMode.HALF_UP);
        this.costHolder = costHolder;

    }

    public CostHolder getCostHolder() {
        return costHolder;
    }

    public int getLedgerNumber() {
        return ledgerNumber;
    }

    public BigDecimal getMatCost() {
        return matCost;
    }

    public BigDecimal getLeaseWorkCost() {
        return leaseWorkCost;
    }

    public BigDecimal getWorkCost() {
        return workCost;
    }

    public void updateExistingValues(BigDecimal matCostNew,
                                     BigDecimal leaseWorkCostNew,
                                     BigDecimal workCostNew,
                                     CostHolder costHolderNew){
        this.matCost = matCost.add(matCostNew).setScale(2, RoundingMode.HALF_UP);
        this.leaseWorkCost = leaseWorkCost.add(leaseWorkCostNew).setScale(2, RoundingMode.HALF_UP);
        this.workCost = workCost.add(workCostNew).setScale(2, RoundingMode.HALF_UP);
        costHolder.updateExistingValues(costHolderNew.getSumOfWorkCostExtra(),
                costHolderNew.getsumOfSocialContributionCost(),
                costHolderNew.getSumOfVocationalContributionTrainingCost());
    }

    @Override
    public String toString() {
        return "CostList{" +
                "ledgerNumber=" + ledgerNumber +
                ", matCost=" + matCost +
                ", leaseWorkCost=" + leaseWorkCost +
                ", workCost=" + workCost +
                ", costHolder=" + costHolder +
                '}';
    }
}
