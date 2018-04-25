package com.elektronika.costcalc.feature1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CodeTable {

    public CodeTable(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer leftEnd;

    private Integer rightEnd;

    private Integer ledgerNumber;

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
}
