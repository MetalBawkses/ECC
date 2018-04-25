package com.elektronika.costcalc.model;

import javax.persistence.*;

@Entity
public class WorkerMonthly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Worker worker;

    @Column(nullable = false)
    private Float socialContribution;

    @Column(nullable = false)
    private Integer hourlyRate;

    @Column(nullable = false)
    private Float vocationalTrainingContribution;

    @Column(nullable = false)
    private Integer yearMonth;

    public WorkerMonthly() {
    }

    public WorkerMonthly(Worker worker, Float socialContribution, Float vocationalTrainingContribution, Integer yearMonth, Integer hourlyRate) {
        this.worker = worker;
        this.socialContribution = socialContribution;
        this.vocationalTrainingContribution = vocationalTrainingContribution;
        this.yearMonth = yearMonth;
        this.hourlyRate = hourlyRate;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker workerId) {
        this.worker = workerId;
    }

    public Float getSocialContribution() {
        return socialContribution;
    }

    public void setSocialContribution(Float socialContribution) {
        this.socialContribution = socialContribution;
    }

    public Float getVocationalTrainingContribution() {
        return vocationalTrainingContribution;
    }

    public void setVocationalTrainingContribution(Float vocationalTrainingContribution) {
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
