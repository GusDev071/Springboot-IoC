package com.gustavo.springboot.di.app.springboot_di.repositories;

import java.util.Collections;
import java.util.List;

/* import org.springframework.context.annotation.Primary; */
import org.springframework.stereotype.Repository;

import com.gustavo.springboot.di.app.springboot_di.models.Product;

/* @Primary //hace que cuando haya dos repositories le de prioridad a uno y no choquen  */
@Repository ("productFoo")
public class ProductRepositoryFoo implements ProductRepository {

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Monitor Asus XD", 700L));
    }

    @Override
    public Product findById(Long id) {
        return new Product(id, "Monitor Asus XD", 700L);
    }
    
}
