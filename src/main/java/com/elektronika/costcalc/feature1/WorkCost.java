package com.elektronika.costcalc.feature1;

import com.elektronika.costcalc.corecomponents.Product;
import com.elektronika.costcalc.model.Worker;

import javax.persistence.*;

@Entity
@Table(name = "work_cost")
public class WorkCost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;

    @Column(nullable = false)
    private Integer hoursOfWork;

    @ManyToOne
//    @Column(nullable = false)
    private Worker workerId;

    @Column(nullable = false)
    private Integer yearMonth;

    public WorkCost() {
    }

    public WorkCost(Product productId, Integer hoursOfWork, Worker workerId, Integer yearMonth) {
        this.productId = productId;
        this.hoursOfWork = hoursOfWork;
        this.workerId = workerId;
        this.yearMonth = yearMonth;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Integer getHoursOfWork() {
        return hoursOfWork;
    }

    public void setHoursOfWork(Integer hoursOfWork) {
        this.hoursOfWork = hoursOfWork;
    }

    public Worker getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Worker workerId) {
        this.workerId = workerId;
    }

    public Integer getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(Integer yearMonth) {
        this.yearMonth = yearMonth;
    }
}
