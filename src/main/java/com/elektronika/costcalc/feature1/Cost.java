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
    private Product productId;

    @Column(nullable = false)
    private Float cost;

    @Column(nullable = false)
    private Integer yearMonth;

    public Cost(Product productId, Float cost, Integer yearMonth) {
        this.productId = productId;
        this.cost = cost;
        this.yearMonth = yearMonth;
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

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }
}
