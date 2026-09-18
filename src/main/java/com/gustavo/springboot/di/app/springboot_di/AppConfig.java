package com.gustavo.springboot.di.app.springboot_di;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import com.gustavo.springboot.di.app.springboot_di.repositories.ProductRepository;
import com.gustavo.springboot.di.app.springboot_di.repositories.ProductRepositoryJson;

@Configuration 
@PropertySource ("classpath:config.properties")
public class AppConfig {

     @Value ("classpath:json/product.json")
    private Resource resource;

    @Bean("productJson")
    public ProductRepository productRepositoryJson(){
        return new ProductRepositoryJson(resource);
    }


}
