package com.elektronika.costcalc.feature1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LedgerNumber {

    public LedgerNumber(){}

    public LedgerNumber(Integer leftEnd, Integer rightEnd, Integer ledgerNumber) {
        this.leftEnd = leftEnd;
        this.rightEnd = rightEnd;
        this.ledgerNumber = ledgerNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer leftEnd;

    private Integer rightEnd;

    private Integer ledgerNumber;

    private boolean directCost;

    public Integer getLeftEnd() {
        return leftEnd;
    }

    public void setLeftEnd(Integer left) {
        this.leftEnd = left;
    }

    public Integer getRightEnd() {
        return rightEnd;
    }

    public void setRightEnd(Integer right) {
        this.rightEnd = right;
    }

    public Integer getLedgerNumber() {
        return ledgerNumber;
    }

    public void setLedgerNumber(Integer ledgerNumber) {
        this.ledgerNumber = ledgerNumber;
    }

    public boolean isDirectCost() {
        return directCost;
    }

    public void setDirectCost(boolean directCost) {
        this.directCost = directCost;
    }
}
