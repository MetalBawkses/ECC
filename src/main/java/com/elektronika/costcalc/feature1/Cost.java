package com.elektronika.costcalc.feature1;



import com.elektronika.costcalc.corecomponents.Product;

import javax.persistence.*;

@Entity
@Table(name = "cost")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "cost_type", discriminatorType = DiscriminatorType.STRING)
public class Cost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
//    @JoinColumn(name = "id")
    private Product product;

    @Column(nullable = false)
    private Float cost;

    @Column(nullable = false)
    private Integer yearMonth;

    @Column(nullable = false)
    private boolean directCost;

    public Cost(Product product, Float cost, Integer yearMonth, boolean directCost) {
        this.product = product;
        this.cost = cost;
        this.yearMonth = yearMonth;
        this.directCost = directCost;
    }

    public Cost() {
    }


    public Long getId() {
        return id;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Integer getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(Integer yearMonth) {
        this.yearMonth = yearMonth;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product productId) {
        this.product = productId;
    }
}
