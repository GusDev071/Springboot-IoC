package com.gustavo.springboot.di.app.springboot_di.repositories;

import  java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
/* import org.springframework.web.context.annotation.RequestScope; */
/* import org.springframework.web.context.annotation.SessionScope; */

import java.util.Arrays;

import com.gustavo.springboot.di.app.springboot_di.models.Product;
 
/* @SessionScope */ // hace que las peticiones sean por session
/* @RequestScope */ 

@Primary
@Repository ("productList") // estos sirve para daele un identificador al repository
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> data;

    public ProductRepositoryImpl() { //almacena los productos en memoria, no en una base de datos
        this.data = Arrays.asList(
            new Product(1L, "memoria usb", 100L),
            new Product(2L, "Monitor", 200L),
            new Product(3L, "Procesador", 300L),
            new Product(4L, "Motherboard", 400L)
        );
    }


    @Override //devolvemos todos los productos que tenemos en memoria  
    public List<Product> findAll() { //devolvemos todos los productos que tenemos en memoria
        return this.data;
    }
    
    @Override
    public Product findById(Long id) { //buscamos un producto por su id
        return this.data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

}
