package com.elektronika.costcalc.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("workCost")
public class WorkCost extends Cost {

    @Column(precision = 25, scale = 10)
    private BigDecimal hoursOfWork;

    @ManyToOne
    private Worker worker;

    @Column(precision = 25, scale = 10)
    private BigDecimal socialContributionCost;

    @Column(precision = 25, scale = 10)
    private BigDecimal vocationalTrainingContributionCost;
    @Column(precision = 25, scale = 10)
    private BigDecimal workCostExtra;

    public WorkCost() {
    }

    public WorkCost(Product productId,
                    BigDecimal cost,
                    Integer yearMonth,
                    BigDecimal hoursOfWork,
                    Worker worker,
                    boolean directCost,
                    BigDecimal socialContributionCost,
                    BigDecimal vocationalTrainingContributionCost,
                    BigDecimal workCostExtra){
        super(productId, cost, yearMonth, directCost);
        this.hoursOfWork = hoursOfWork;
        this.worker = worker;
        this.socialContributionCost = socialContributionCost;
        this.vocationalTrainingContributionCost = vocationalTrainingContributionCost;
        this.workCostExtra = workCostExtra;
    }

    public BigDecimal getWorkCostExtra() {
        return workCostExtra;
    }

/*    public WorkCost(Product productId, Worker worker, BigDecimal hoursOfWork){
        this.cost =
    }*/

    public void setWorkCostExtra(BigDecimal workCostExtra) {
        this.workCostExtra = workCostExtra;
    }

    public BigDecimal getSocialContributionCost() {
        return socialContributionCost;
    }

    public void setSocialContributionCost(BigDecimal socialContributionCost) {
        this.socialContributionCost = socialContributionCost;
    }

    public BigDecimal getVocationalTrainingContributionCost() {
        return vocationalTrainingContributionCost;
    }

    public void setVocationalTrainingContributionCost(BigDecimal vocationalTrainingContributionCost) {
        this.vocationalTrainingContributionCost = vocationalTrainingContributionCost;
    }

    public BigDecimal getHoursOfWork() {
        return hoursOfWork;
    }

    public void setHoursOfWork(BigDecimal hoursOfWork) {
        this.hoursOfWork = hoursOfWork;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker workerId) {
        this.worker = workerId;
    }

}
