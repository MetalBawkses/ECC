package com.elektronika.costcalc.corecomponents;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByAmountBetweenAndNameIsLike(Float from, Float to, String name);
}
