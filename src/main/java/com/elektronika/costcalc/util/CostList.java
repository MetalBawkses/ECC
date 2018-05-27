package com.elektronika.costcalc.util;

import com.elektronika.costcalc.model.WorkCostExtensions;
import static com.elektronika.costcalc.util.BigDecimalUtil.scaleIfNotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CostList {

    private int ledgerNumber;
    private BigDecimal matCost;
    private BigDecimal leaseWorkCost;
    private BigDecimal workCost;
    private WorkCostExtensions workCostExtensions;

    public CostList(int ledgerNumber, BigDecimal matCost, BigDecimal leaseWorkCost, BigDecimal workCost, WorkCostExtensions workCostExtensions) {
        this.ledgerNumber = ledgerNumber;
        this.matCost = scaleIfNotNull(matCost);
        this.leaseWorkCost = scaleIfNotNull(leaseWorkCost);
        this.workCost = scaleIfNotNull(workCost);
        this.workCostExtensions = workCostExtensions;

    }

    public WorkCostExtensions getWorkCostExtensions() {
        return workCostExtensions;
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
                                     WorkCostExtensions workCostExtensionsNew){

        this.matCost = scaleIfNotNull(matCost.add(matCostNew));
        this.leaseWorkCost = scaleIfNotNull(leaseWorkCost.add(leaseWorkCostNew));
        this.workCost = scaleIfNotNull(workCost.add(workCostNew));
        workCostExtensions.updateExistingValues(workCostExtensionsNew.getSumOfWorkCostExtra(),
                workCostExtensionsNew.getsumOfSocialContributionCost(),
                workCostExtensionsNew.getSumOfVocationalContributionTrainingCost());
    }

    @Override
    public String toString() {
        return "CostList{" +
                "ledgerNumber=" + ledgerNumber +
                ", matCost=" + matCost +
                ", leaseWorkCost=" + leaseWorkCost +
                ", workCost=" + workCost +
                ", workCostExtensions=" + workCostExtensions +
                '}';
    }
}
