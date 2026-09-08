package com.gustavo.springboot.di.app.springboot_di.repositories;

import  java.util.List;
import java.util.Arrays;

import com.gustavo.springboot.di.app.springboot_di.models.Product;

public class ProductRepository {

    private List<Product> data;

    public ProductRepository() { //almacena los productos en memoria, no en una base de datos
        this.data = Arrays.asList(
            new Product(1L, "memoria usb", 100L),
            new Product(2L, "Monitor", 200L),
            new Product(3L, "Procesador", 300L),
            new Product(4L, "Motherboard", 400L)
        );
    }

    public List<Product> findAll() { //devolvemos todos los productos que tenemos en memoria
        return this.data;
    }

    public Product findById(Long id) { //buscamos un producto por su id
        return this.data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

}
