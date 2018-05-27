package com.elektronika.costcalc.model;

import java.math.BigDecimal;
import static com.elektronika.costcalc.util.BigDecimalUtil.scaleIfNotNull;

public class WorkCostExtensions {

    public WorkCostExtensions(BigDecimal sumOfWorkCostExtra, BigDecimal sumOfSocialContributionCost, BigDecimal sumOfVocationalContributionTrainingCost) {

        this.sumOfWorkCostExtra = scaleIfNotNull(sumOfWorkCostExtra);
        this.sumOfSocialContributionCost = scaleIfNotNull(sumOfSocialContributionCost);
        this.sumOfVocationalContributionTrainingCost = scaleIfNotNull(sumOfVocationalContributionTrainingCost);
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
        this.sumOfWorkCostExtra = sumOfWorkCostExtra.add(scaleIfNotNull(sumOfWorkCostExtraNew));
        this.sumOfSocialContributionCost = sumOfSocialContributionCost.add(scaleIfNotNull(sumOfSocialContributionCostNew));
        this.sumOfVocationalContributionTrainingCost = sumOfVocationalContributionTrainingCost.add(scaleIfNotNull(sumOfVocationalContributionTrainingCostNew));

    }

    @Override
    public String toString() {
        return "WorkCostExtensions{" +
                "sumOfWorkCostExtra=" + sumOfWorkCostExtra +
                ", ketto=" + sumOfSocialContributionCost +
                ", sumOfVocationalContributionTrainingCost=" + sumOfVocationalContributionTrainingCost +
                '}';
    }
}
