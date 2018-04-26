package com.elektronika.costcalc.repository;

import com.elektronika.costcalc.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
