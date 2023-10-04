package com.imbuka.products.controller;

import com.imbuka.products.entity.Product;
import com.imbuka.products.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/createProduct")
    public Product createProduct(@RequestBody @Valid Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/getAllProducts")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/find/{id}")
    public Product getProductById(@PathVariable int id) throws Exception {
        return productService.getProductById(id);
    }

    @PutMapping("/update/{id}")
    public Boolean updateProduct(@PathVariable int id, @RequestBody Product product) throws Exception {
        product.setId(id);
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }
}
