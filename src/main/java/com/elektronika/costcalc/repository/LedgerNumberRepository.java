package com.elektronika.costcalc.repository;

import com.elektronika.costcalc.model.LedgerNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public interface LedgerNumberRepository extends JpaRepository <LedgerNumber, Long> {

    @Query("select l.ledgerNumber from LedgerNumber l")
    Set<Integer> getLedgerNumberToSet();

//    @Override
//    List<LedgerNumber> findAll();
}
