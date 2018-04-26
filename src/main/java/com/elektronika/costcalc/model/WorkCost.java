package com.elektronika.costcalc.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("workCost")
public class WorkCost extends Cost {

    private Float hoursOfWork;

    @ManyToOne
    private Worker worker;


    public WorkCost() {
    }

    public WorkCost(Product productId, Float cost, Integer yearMonth, Float hoursOfWork, Worker worker, boolean directCost){
        super(productId, cost, yearMonth, directCost);
        this.hoursOfWork = hoursOfWork;
        this.worker = worker;
    }


    public Float getHoursOfWork() {
        return hoursOfWork;
    }

    public void setHoursOfWork(Float hoursOfWork) {
        this.hoursOfWork = hoursOfWork;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker workerId) {
        this.worker = workerId;
    }

}
