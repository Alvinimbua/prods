package com.imbuka.products.service;

import com.imbuka.products.entity.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);
    List<Product> getProducts();
    Product getProductById(int id);

    boolean updateProduct(Product product);
    boolean deleteProduct(int id);
}








