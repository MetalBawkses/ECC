package com.elektronika.costcalc.corecomponents;

import com.elektronika.costcalc.feature1.WorkCost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<WorkCost> findWorkCostbyProductId(Long id) {
        return productRepository.findOne(id).getWorkCosts();
    }

    public void saveProduct(Product entity) {
        productRepository.save(entity);
    }

}