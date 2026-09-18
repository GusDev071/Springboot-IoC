package com.gustavo.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

/* import org.springframework.beans.factory.annotation.Autowired; */
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gustavo.springboot.di.app.springboot_di.models.Product;
import com.gustavo.springboot.di.app.springboot_di.repositories.ProductRepository;


@Service 
public class ProductServiceImpl implements ProductService {

/*     @Autowired 
    @Qualifier ("productFoo") */

    @Value ("${app.value.TAX}")
    private Double TAX;
   
    private ProductRepository repository;

    public ProductServiceImpl(@Qualifier("productJson") ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List <Product> findAll() {
        return repository.findAll().stream().map(p -> {
            Double priceTAX = p.getPrice() * TAX;
            //Product newProduct = new Product(p.getId(), p.getName(), priceTAX.longValue());
            // este es el mejor ejemplo para hacer inmutable un objeto
            Product newProduct = (Product) p.clone(); 
            newProduct.setPrice(priceTAX.longValue());
            return newProduct;
           /*  p.setPrice(priceTAX.longValue());
            return p; */
        }).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }

}
