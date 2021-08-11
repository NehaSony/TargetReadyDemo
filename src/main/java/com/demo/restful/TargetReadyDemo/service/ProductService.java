package com.demo.restful.TargetReadyDemo.service;

import com.demo.restful.TargetReadyDemo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ProductService {

    Product product = new Product();

    public List<Product> getAllProducts() {
    return product.init();
    }

    public Product getProductById(int id) {
        //todo
        List<Product> productList;
        productList = product.init();
        return product;
    }

    public Product updateProduct(Product product) {
        //todo
        return product;
    }
}
