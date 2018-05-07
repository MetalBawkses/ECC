package com.elektronika.costcalc.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CostHolder {

    public CostHolder(BigDecimal sumOfWorkCostExtra, BigDecimal sumOfSocialContributionCost, BigDecimal sumOfVocationalContributionTrainingCost) {
        this.sumOfWorkCostExtra = sumOfWorkCostExtra.setScale(2, RoundingMode.HALF_UP);
        this.sumOfSocialContributionCost = sumOfSocialContributionCost.setScale(2, RoundingMode.HALF_UP);
        this.sumOfVocationalContributionTrainingCost = sumOfVocationalContributionTrainingCost.setScale(2, RoundingMode.HALF_UP);
    }

    BigDecimal sumOfWorkCostExtra;
    BigDecimal sumOfSocialContributionCost;
    BigDecimal sumOfVocationalContributionTrainingCost;

    public BigDecimal getSumOfWorkCostExtra() {
        return sumOfWorkCostExtra;
    }

    public BigDecimal getsumOfSocialContributionCost() {
        return sumOfSocialContributionCost;
    }

    public BigDecimal getSumOfVocationalContributionTrainingCost() {
        return sumOfVocationalContributionTrainingCost;
    }

    public void updateExistingValues(BigDecimal sumOfWorkCostExtraNew,
                                     BigDecimal sumOfSocialContributionCostNew,
                                     BigDecimal sumOfVocationalContributionTrainingCostNew){
        this.sumOfWorkCostExtra = sumOfWorkCostExtra.add(sumOfWorkCostExtraNew).setScale(2, RoundingMode.HALF_UP);
        this.sumOfSocialContributionCost = sumOfSocialContributionCost.add(sumOfSocialContributionCostNew).setScale(2, RoundingMode.HALF_UP);
        this.sumOfVocationalContributionTrainingCost = sumOfVocationalContributionTrainingCost.add(sumOfVocationalContributionTrainingCostNew).setScale(2, RoundingMode.HALF_UP);

    }

    @Override
    public String toString() {
        return "CostHolder{" +
                "sumOfWorkCostExtra=" + sumOfWorkCostExtra +
                ", ketto=" + sumOfSocialContributionCost +
                ", sumOfVocationalContributionTrainingCost=" + sumOfVocationalContributionTrainingCost +
                '}';
    }
}
