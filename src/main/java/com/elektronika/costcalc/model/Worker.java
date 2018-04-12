package com.elektronika.costcalc.model;

import com.elektronika.costcalc.feature1.WorkCost;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String division;


    @OneToMany(mappedBy = "workerId",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    private List<WorkCost> workCosts = new ArrayList<>();

    @OneToMany(mappedBy = "workerId",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    private List<WorkerMonthly> workerMonthlies = new ArrayList<>();

    public Worker() {
    }

    public Worker(String name, String division, Integer hourlyRate, List<WorkCost> workCosts, List<WorkerMonthly> workerMonthlies) {
        this.name = name;
        this.division = division;
        this.workCosts = workCosts;
        this.workerMonthlies = workerMonthlies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public List<WorkCost> getWorkCosts() {
        return workCosts;
    }

    public void setWorkCosts(List<WorkCost> workCosts) {
        this.workCosts = workCosts;
    }

    public List<WorkerMonthly> getWorkerMonthlies() {
        return workerMonthlies;
    }

    public void setWorkerMonthlies(List<WorkerMonthly> workerMonthlies) {
        this.workerMonthlies = workerMonthlies;
    }
}
