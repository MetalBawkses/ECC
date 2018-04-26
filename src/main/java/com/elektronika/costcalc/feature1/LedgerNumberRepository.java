package com.elektronika.costcalc.feature1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface LedgerNumberRepository extends JpaRepository <LedgerNumber, Long> {

//    @Override
//    List<LedgerNumber> findAll();
}
