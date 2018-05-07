package com.elektronika.costcalc.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class WorkerMonthly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Worker worker;

    @Column(nullable = false, precision = 25, scale = 10)
    private BigDecimal socialContribution;

    @Column(nullable = false)
    private Integer hourlyRate;

    @Column(nullable = false, precision = 25, scale = 10)
    private BigDecimal vocationalTrainingContribution;
    @Column(nullable = false, precision = 25, scale = 10)
    private BigDecimal workCostExtra;
    @Column(nullable = false)
    private Integer yearMonth;

    public WorkerMonthly() {
    }

    public WorkerMonthly(Worker worker, BigDecimal socialContribution, BigDecimal vocationalTrainingContribution, Integer yearMonth, Integer hourlyRate, BigDecimal workCostExtra) {
        this.worker = worker;
        this.socialContribution = socialContribution;
        this.vocationalTrainingContribution = vocationalTrainingContribution;
        this.yearMonth = yearMonth;
        this.hourlyRate = hourlyRate;
        this.workCostExtra = workCostExtra;
    }

    public BigDecimal getWorkCostExtra() {
        return workCostExtra;
    }

    public void setWorkCostExtra(BigDecimal workCostExtra) {
        this.workCostExtra = workCostExtra;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker workerId) {
        this.worker = workerId;
    }

    public BigDecimal getSocialContribution() {
        return socialContribution;
    }

    public void setSocialContribution(BigDecimal socialContribution) {
        this.socialContribution = socialContribution;
    }

    public BigDecimal getVocationalTrainingContribution() {
        return vocationalTrainingContribution;
    }

    public void setVocationalTrainingContribution(BigDecimal vocationalTrainingContribution) {
        this.vocationalTrainingContribution = vocationalTrainingContribution;
    }

    public Integer getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Integer hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public Integer getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(Integer yearMonth) {
        this.yearMonth = yearMonth;
    }
}
