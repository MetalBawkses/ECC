package com.elektronika.costcalc.feature1;

import com.elektronika.costcalc.corecomponents.Product;

import javax.persistence.*;

@Entity
@Table(name = "lease_work_cost")
public class LeaseWorkCost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;

    @Column(nullable = false)
    private Float cost;

    @Column(nullable = false)
    private String billNumber;

    @Column(nullable = false)
    private Integer yearMonth;

    public LeaseWorkCost(){

    }

    public LeaseWorkCost(Product productId, Float cost, String billNumber, Integer yearMonth) {
        this.productId = productId;
        this.cost = cost;
        this.billNumber = billNumber;
        this.yearMonth = yearMonth;
    }

    public Integer getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(Integer yearMonth) {
        this.yearMonth = yearMonth;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float workCost) {
        this.cost = workCost;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    @Override
    public String toString() {
        return "LeaseWorkCost{" +
                "id=" + id +
                ", productId=" + productId +
                ", workCost=" + cost +
                ", billNumber=" + billNumber +
                ", yearMonth=" + yearMonth +
                '}';
    }
}
