package com.imbuka.products.service.impl;

import com.imbuka.products.entity.Product;
import com.imbuka.products.repository.ProductsRepository;
import com.imbuka.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductsRepository productsRepository;

    @Override
    public Product saveProduct(Product product) {
        return productsRepository.save(product);
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(productsRepository.findAll());
    }

    @Override
    public Product getProductById(int id) {
        return productsRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateProduct(Product product) {
        log.info("Product to be updated: id={}", product.getId());
        Product productFromDb = this.getProductById(product.getId());
        if (productFromDb != null) {
            //customer is in the db hence update
            log.info("Product found in Database ******** updating the customer with id={}", product.getId());
            productsRepository.save(product);
            return true;
        } else {
            //product not found, cannot update database
            return false;
        }
    }

    @Override
    public boolean deleteProduct(int id) {
        Product product = this.getProductById(id);
        if (product != null) {
            productsRepository.delete(product);
            return true;
        } else {
            //no customer found in db to delete
            return false;
        }
    }
}








