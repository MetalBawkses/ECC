package com.elektronika.costcalc.model;



import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cost")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "cost_type", discriminatorType = DiscriminatorType.STRING)
public class Cost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @Column(nullable = false, precision = 25, scale = 10)
    protected BigDecimal cost;

    @Column(nullable = false)
    private Integer yearMonth;

    @Column(nullable = false)
    private boolean directCost;

    public Cost(Product product, BigDecimal cost, Integer yearMonth, boolean directCost) {
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

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
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

    public boolean isDirectCost() {
        return directCost;
    }

    public void setDirectCost(boolean directCost) {
        this.directCost = directCost;
    }
}
