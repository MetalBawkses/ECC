package com.elektronika.costcalc.feature1;

import com.elektronika.costcalc.corecomponents.Product;
import com.elektronika.costcalc.model.Worker;

import javax.persistence.*;

@Entity
@DiscriminatorValue("workCost")
public class WorkCost extends Cost{

    private Float hoursOfWork;

    @ManyToOne
    private Worker workerId;


    public WorkCost() {
    }

    public WorkCost(Product productId, Float cost, Integer yearMonth, Float hoursOfWork, Worker workerId){
        super(productId, cost, yearMonth);
        this.hoursOfWork = hoursOfWork;
        this.workerId = workerId;
    }


    public Float getHoursOfWork() {
        return hoursOfWork;
    }

    public void setHoursOfWork(Float hoursOfWork) {
        this.hoursOfWork = hoursOfWork;
    }

    public Worker getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Worker workerId) {
        this.workerId = workerId;
    }

}
