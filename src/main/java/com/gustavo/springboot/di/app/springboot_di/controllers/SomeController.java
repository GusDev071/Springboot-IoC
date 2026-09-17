package com.gustavo.springboot.di.app.springboot_di.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gustavo.springboot.di.app.springboot_di.models.Product;
import com.gustavo.springboot.di.app.springboot_di.services.ProductService;

import java.util.List;

@RestController 
@RequestMapping ("/api")

public class SomeController {

    private ProductService service;

    public SomeController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> list(){
        return service.findAll();
    }

    @GetMapping ("/{id}")
    public Product getProductById(@PathVariable Long id){
        return service.findById(id);
    }

}
