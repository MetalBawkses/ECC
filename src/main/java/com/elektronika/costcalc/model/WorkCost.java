package com.elektronika.costcalc.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("workCost")
public class WorkCost extends Cost {

    private BigDecimal hoursOfWork;

    @ManyToOne
    private Worker worker;


    public WorkCost() {
    }

    public WorkCost(Product productId, BigDecimal cost, Integer yearMonth, BigDecimal hoursOfWork, Worker worker, boolean directCost){
        super(productId, cost, yearMonth, directCost);
        this.hoursOfWork = hoursOfWork;
        this.worker = worker;
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
