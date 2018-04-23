package com.elektronika.costcalc.corecomponents;


import com.elektronika.costcalc.feature1.WorkCost;
import com.elektronika.costcalc.feature1.LeaseWorkCost;
import com.elektronika.costcalc.feature1.MaterialCost;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
public class Product {

    public Product(){}

    public Product(int id, String name, int amount){
        this.name = name;
        this.id = id;
        this.amount = amount;
    }



    @Id
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer amount;

    @OneToMany(mappedBy = "productId")
    private List<LeaseWorkCost> leaseWorkCosts = new ArrayList<>();

    @OneToMany(mappedBy = "productId")
    private List<MaterialCost> materialCosts = new ArrayList<>();

    @OneToMany(mappedBy = "productId")
    private List<WorkCost> workCosts = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public List<LeaseWorkCost> getLeaseWorkCosts() {
        return leaseWorkCosts;
    }

    public void setLeaseWorkCosts(List<LeaseWorkCost> leaseWorkCosts) {
        this.leaseWorkCosts = leaseWorkCosts;
    }

    public List<WorkCost> getWorkCosts() {
        return workCosts;
    }

    public void setWorkCosts(List<WorkCost> workCosts) {
        this.workCosts = workCosts;
    }
}
