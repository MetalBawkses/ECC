package com.elektronika.costcalc.corecomponents;


import com.elektronika.costcalc.feature1.WorkCost;
import com.elektronika.costcalc.feature1.LeaseWorkCost;
import com.elektronika.costcalc.feature1.MaterialCost;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer amount;

    @OneToMany(mappedBy = "productId",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<LeaseWorkCost> leaseWorkCosts = new ArrayList<>();

    @OneToMany(mappedBy = "productId",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<MaterialCost> materialCosts = new ArrayList<>();

    @OneToMany(mappedBy = "productId",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<WorkCost> workCosts = new ArrayList<>();

    public List<WorkCost> getWorkCosts() {
        return workCosts;
    }

    public void setWorkCosts(List<WorkCost> workCosts) {
        this.workCosts = workCosts;
    }

    public List<MaterialCost> getMaterialCosts() {
        return materialCosts;
    }

    public void setMaterialCosts(List<MaterialCost> materialCosts) {
        this.materialCosts = materialCosts;
    }

    public List<LeaseWorkCost> getLeaseWorkCosts() {
        return leaseWorkCosts;
    }

    public void setLeaseWorkCosts(List<LeaseWorkCost> leaseWorkCosts) {
        this.leaseWorkCosts = leaseWorkCosts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String productName) {
        this.name = productName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
