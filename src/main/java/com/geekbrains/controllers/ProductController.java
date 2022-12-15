package com.geekbrains.controllers;

import com.geekbrains.data.Product;
import com.geekbrains.servises.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping( "/products")
    public List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/products/{id}")
    public void deleteProductById(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }

    @PutMapping("/products")
    public void changeCost(@RequestParam("productId") Long id, @RequestParam("delta") Integer delta) {
        productService.changeCost(id, delta);
    }

    @PostMapping("/products")
    public void addProduct(@RequestParam("productId")Long id,
                           @RequestParam("name")String name,
                           @RequestParam("cost") Double cost,
                           @RequestParam("description")String description){
        productService.addProduct(id,name,cost,description);

    }
}
