package com.gustavo.springboot.di.app.springboot_di.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.Resource;

import com.gustavo.springboot.di.app.springboot_di.models.Product;


import tools.jackson.databind.ObjectMapper;

public class ProductRepositoryJson implements ProductRepository{

    private List<Product> list;
    
   

    public ProductRepositoryJson(Resource resource) {
        readValueJson(resource);
    }

     private void readValueJson(Resource resource) {
        /* Resource resource = new ClassPathResource("json/product.json"); */
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            list = Arrays.asList(objectMapper.readValue(resource.getInputStream(), Product[].class));
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(Long id) {
        return list.stream().filter(p -> {
            return  p.getId().equals(id);
        }).findFirst().orElseThrow();
    }

}
