package com.geekbrains.controllers;

import com.geekbrains.data.Product;
import com.geekbrains.servises.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;


@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/delete/{id}")
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/products/change_cost")
    public void changeCost(@RequestParam Long id, @RequestParam Integer delta) {
        productService.changeCost(id, delta);
    }
}
