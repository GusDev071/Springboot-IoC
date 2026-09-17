package com.gustavo.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gustavo.springboot.di.app.springboot_di.models.Product;
import com.gustavo.springboot.di.app.springboot_di.repositories.ProductRepository;


@Service 
public class ProductServiceImpl implements ProductService {

   
    private ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List <Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double priceTAX = p.getPrice() * 1.25d;
            //Product newProduct = new Product(p.getId(), p.getName(), priceTAX.longValue());
            Product newProduct = (Product) p.clone();
            newProduct.setPrice(priceTAX.longValue());
            return newProduct;
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }

}
