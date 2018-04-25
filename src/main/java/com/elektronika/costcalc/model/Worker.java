package com.elektronika.costcalc.model;

import com.elektronika.costcalc.feature1.DevelopmentCost;
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


    @OneToMany(mappedBy = "worker",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<WorkCost> workCosts = new ArrayList<>();

    @OneToMany(mappedBy = "worker",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<DevelopmentCost> developmentCosts = new ArrayList<>();

    @OneToMany(mappedBy = "worker",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<WorkerMonthly> workerMonthlies;

    {
        workerMonthlies = new ArrayList<>();
    }

    public Worker() {
    }

    public Worker(String name, String division) {
        this.name = name;
        this.division = division;

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

    public List<WorkerMonthly> getWorkerMonthlies() {
        return workerMonthlies;
    }

    public List<DevelopmentCost> getDevelopmentCosts() {
        return developmentCosts;
    }
}
