package com.elektronika.costcalc.feature1;


import com.elektronika.costcalc.corecomponents.Product;

import javax.persistence.*;

@Entity
@Table(name = "material_cost")
public class MaterialCost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

/*    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;*/

    @Column(nullable = false)
    private Float cost;

/*    @Column(nullable = false)
    private Integer selfProducedMaterialCost;*/

    @Column(nullable = false)
    private Integer yearMonth;

    public MaterialCost() {
    }

    public MaterialCost(Float cost, /*Integer selfProducedMaterialCost,*/ Integer yearMonth) {
        this.cost = cost;
        /*this.selfProducedMaterialCost = selfProducedMaterialCost;*/
        this.yearMonth = yearMonth;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

/*    public Integer getSelfProducedMaterialCost() {
        return selfProducedMaterialCost;
    }

    public void setSelfProducedMaterialCost(Integer selfProducedMaterialCost) {
        this.selfProducedMaterialCost = selfProducedMaterialCost;
    }*/

    public Integer getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(Integer yearMonth) {
        this.yearMonth = yearMonth;
    }
}



